package smith.lib.tools.perms;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/**
 * Request access for some features in the android device with this class with a fast and convenient
 * way! ask for permissions at one or at a single request, and check weather your app has access to
 * that features.
 */
@SuppressWarnings({"unused", "deprecation"})
public class SPermissions extends ComponentActivity {

    private final Activity activity;
    private SPermissionsCallback callback;
    private int requestCode = -1;
    private final ActivityResultLauncher<Intent> storageResultLauncher;

    /**
     * The static request code declared by <b>{@code SPermissions}</b> module.
     * Use it to request for some permissions with a unique code.
     */
    public static final int REQUEST_CODE = 700;

    private SPermissions(@NonNull Activity activity) {
        this.activity = activity;
        storageResultLauncher = ((ComponentActivity) activity).registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), o -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (callback != null) this.callback.onAskPermissionResult(Environment.isExternalStorageManager(),
                        requestCode == -1 ? REQUEST_CODE : requestCode);
            }
        });
    }

    /**
     * Set up the {@code SPermissions} class and initialise a new instance from this method.
     * @param activity pass the current activity you are using this lib from.
     */
    @NonNull
    public static SPermissions with(@NonNull Activity activity) {
        return new SPermissions(activity);
    }

    /**
     * Check weather your app has successful access to specific feature using a permission.
     * Permissions like {@link Manifest.permission#ACCESS_FINE_LOCATION} and so on...
     * @param permission the required permission like {@link Manifest.permission#CAMERA}
     * @return true if access to specific features granted.
     */
    public boolean hasPermission(@NonNull String permission) {
        return ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Check weather your app has successful access to specific features using an array of string
     * permissions at once. Permissions like {@link Manifest.permission#ACCESS_FINE_LOCATION} and so on...
     * @param permissions the required permissions like {@link Manifest.permission#CAMERA}, and
     * {@link Manifest.permission#WRITE_EXTERNAL_STORAGE}.
     * @return true if access to specific features granted.
     */
    public boolean hasPermissions(@NonNull String[] permissions) {
        for (String permission : permissions) if (!hasPermission(permission)) return false;
        return true;
    }

    /**
     * Make a request to get granted to access some features in the device with this method, ask for
     * permission you need in a convenient way.
     * @param permission the required permission to be granted.
     */
    public void askPermission(@NonNull String permission) {
        ActivityCompat.requestPermissions(activity, new String[]{permission}, REQUEST_CODE);
    }

    /**
     * Make a request to get granted to access some features in the device with this method, ask for
     * permissions you need in a convenient way at once.
     * @param permissions the required permissions to be granted as string array.
     */
    public void askPermissions(@NonNull String[] permissions) {
        ActivityCompat.requestPermissions(activity, permissions, REQUEST_CODE);
    }

    /**
     * Make a request to get granted to access some features in the device with this method, ask for
     * permission you need in a convenient way.
     * @param permission the required permission to be granted.
     * @param requestCode the code to distinguish multiple permission grant access requests.
     */
    public void askPermission(@NonNull String permission, int requestCode) {
        ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
    }

    /**
     * Make a request to get granted to access some features in the device with this method, ask for
     * permissions you need in a convenient way at once.
     * @param permissions the required permissions to be granted as string array.
     * @param requestCode the code to distinguish multiple permission grant access requests.
     */
    public void askPermissions(@NonNull String[] permissions, int requestCode) {
        ActivityCompat.requestPermissions(activity, permissions, requestCode);
    }

    /**
     * Make a request to get granted to access Reading and Writing in external storage features in
     * the device with this method, ask for permissions {@link  Manifest.permission#READ_EXTERNAL_STORAGE}
     * and {@link  Manifest.permission#WRITE_EXTERNAL_STORAGE} for android -10 and below, and {@code Scoped Storage Access} for android
     * +11 and above.
     *
     * @param callback the onAskPermissionResult to be called when the permissions are granted or not.
     */
    public void askStorageAccess(SPermissionsCallback callback) {
        this.callback = callback;
        askStorage(-1);
    }

    /**
     * Make a request to get granted to access Reading and Writing in external storage features in
     * the device with this method, ask for permissions {@link  Manifest.permission#READ_EXTERNAL_STORAGE}
     * and {@link  Manifest.permission#WRITE_EXTERNAL_STORAGE} for android -10 and below, and {@code Scoped Storage Access} for android
     * +11 and above.
     *
     * @param callback the onAskPermissionResult to be called when the permissions are granted or not.
     * @param requestCode the unique identifier of the request being asked.
     */
    public void askStorageAccess(SPermissionsCallback callback, int requestCode) {
        this.callback = callback;
        askStorage(requestCode);
    }

    private void askStorage(int requestCode) {
        this.requestCode = requestCode;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Intent intent = new Intent();
            try {
                intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
            } catch (Exception e) {
                intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
            }
            storageResultLauncher.launch(intent);
        } else {
            askPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    requestCode == -1 ? REQUEST_CODE : requestCode);
        }
    }

    /**
     * Check weather your app has successful access to Reading and Writing in external storage features.
     * Permissions like {@link Manifest.permission#READ_EXTERNAL_STORAGE}, {@link Manifest.permission#WRITE_EXTERNAL_STORAGE}.
     * and {@link Environment#isExternalStorageManager()}.
     *
     * @return true if access to external storage is granted.
     */
    public boolean hasStorageAccess() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            return Environment.isExternalStorageManager();
        } else {
            return hasPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE});
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == SPermissions.REQUEST_CODE || requestCode == this.requestCode) {
            if (grantResults.length > 0) {
                if (hasPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})) {
                    if (callback != null) callback.onAskPermissionResult(true, requestCode);
                }
            }
        } else {
            if (callback != null) callback.onAskPermissionResult(false, -1);
        }
    }
}
