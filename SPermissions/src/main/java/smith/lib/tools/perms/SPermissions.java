package smith.lib.tools.perms;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/**
 * Request access for some features in the android device with this class with a fast and convenient
 * way! ask for permissions at one or at a single request, and check weather your app has access to
 * that features.
 */
@SuppressWarnings({"unused"})
public class SPermissions {

    private final Activity activity;

    /**
     * The static request code declared by <b>{@code SPermissions}</b> module.
     * Use it to request for some permissions with a unique code.
     */
    public static final int REQUEST_CODE = 700;

    private SPermissions(@NonNull Activity activity) {
        this.activity = activity;
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
    public void requestPermission(@NonNull String permission) {
        ActivityCompat.requestPermissions(activity, new String[]{permission}, REQUEST_CODE);
    }

    /**
     * Make a request to get granted to access some features in the device with this method, ask for
     * permissions you need in a convenient way at once.
     * @param permissions the required permissions to be granted as string array.
     */
    public void requestPermissions(@NonNull String[] permissions) {
        ActivityCompat.requestPermissions(activity, permissions, REQUEST_CODE);
    }

    /**
     * Make a request to get granted to access some features in the device with this method, ask for
     * permission you need in a convenient way.
     * @param permission the required permission to be granted.
     * @param requestCode the code to distinguish multiple permission grant access requests.
     */
    public void requestPermission(@NonNull String permission, int requestCode) {
        ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
    }

    /**
     * Make a request to get granted to access some features in the device with this method, ask for
     * permissions you need in a convenient way at once.
     * @param permissions the required permissions to be granted as string array.
     * @param requestCode the code to distinguish multiple permission grant access requests.
     */
    public void requestPermissions(@NonNull String[] permissions, int requestCode) {
        ActivityCompat.requestPermissions(activity, permissions, requestCode);
    }
}
