package smith.lib.tools.perms;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SPermissions {

    private Activity activity;
    public static final int REQUEST_CODE = 700;
    
    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static final String READ_CONTACTS = Manifest.permission.READ_CONTACTS;
    public static final String CAMERA = Manifest.permission.CAMERA;
    public static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public static final String ACCESS_NETWORK_STATE = Manifest.permission.ACCESS_NETWORK_STATE;
    public static final String ACCESS_WIFI_STATE = Manifest.permission.ACCESS_WIFI_STATE;
    
    private SPermissions(Activity act) { activity = act; }
    
    public static SPermissions with(Activity act) { return new SPermissions(act); }
    
    public boolean hasPermission(String permission) {
        return ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
    }
    
    public boolean hasPermissions(String... permissions) {
        for (String permission: permissions) if (!hasPermission(permission)) return false;
        return true;
    }
    
    public void requestPermission(String permission) {
        ActivityCompat.requestPermissions(activity, new String[] { permission }, REQUEST_CODE);
    }
    
    public void requestPermissions(String... permissions) {
        ActivityCompat.requestPermissions(activity, permissions, REQUEST_CODE);
    }
    
    public void requestPermission(String permission, int requestCode) {
        ActivityCompat.requestPermissions(activity, new String[] { permission }, requestCode);
    }
    
    public void requestPermissions(int requestCode, String... permissions) {
        ActivityCompat.requestPermissions(activity, permissions, requestCode);
    }
}
