package smith.test.spermission;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import smith.lib.tools.perms.SPermissions;
import smith.lib.tools.perms.SPermissionsCallback;
import smith.test.spermission.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements SPermissionsCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        smith.test.spermission.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SPermissions sp = SPermissions.with(this);
        if (!sp.hasStorageAccess()) sp.askStorageAccess(this);
        sp.askStorageAccess(this);
    }

    @Override
    public void onAskPermissionResult(boolean isGranted, int requestCode) {
        Toast.makeText(this, requestCode + ": " + isGranted, Toast.LENGTH_SHORT).show();
        System.out.println(requestCode + ": " + isGranted);
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] resultCodes) {
//        super.onRequestPermissionsResult(requestCode, permissions, resultCodes);
//        if (requestCode == SPermissions.REQUEST_CODE) {
//            if (sp.hasPermission(Manifest.permission.READ_CONTACTS)) {
//                // do work here
//            }
//        }
//    }
        
}
