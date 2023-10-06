package smith.lib.tools.perms;

import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

@SuppressWarnings({"unused"})
public class SPermissions {

    private final Activity activity;
    public static final int REQUEST_CODE = 700;

    private SPermissions(@NonNull Activity activity) {
        this.activity = activity;
    }

    @NonNull
    public static SPermissions with(@NonNull Activity activity) {
        return new SPermissions(activity);
    }

    public boolean hasPermission(@NonNull String permission) {
        return ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
    }

    public boolean hasPermissions(@NonNull String[] permissions) {
        for (String permission : permissions) if (!hasPermission(permission)) return false;
        return true;
    }

    public void requestPermission(@NonNull String permission) {
        ActivityCompat.requestPermissions(activity, new String[]{permission}, REQUEST_CODE);
    }

    public void requestPermissions(@NonNull String[] permissions) {
        ActivityCompat.requestPermissions(activity, permissions, REQUEST_CODE);
    }

    public void requestPermission(@NonNull String permission, int requestCode) {
        ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
    }

    public void requestPermissions(@NonNull String[] permissions, int requestCode) {
        ActivityCompat.requestPermissions(activity, permissions, requestCode);
    }
}
