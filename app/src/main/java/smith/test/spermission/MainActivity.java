package smith.test.spermission;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import smith.lib.tools.perms.SPermissions;
import smith.test.spermission.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private SPermissions sp;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        smith.test.spermission.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sp = SPermissions.with((Activity) getApplicationContext());

        if (!sp.hasPermission(Manifest.permission.CAMERA)) {
            sp.requestPermission(Manifest.permission.CAMERA);
                sp.requestPermissions(new String[] {
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                });
        }
    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] resultCodes) {
        super.onRequestPermissionsResult(requestCode, permissions, resultCodes);
        if (requestCode == SPermissions.REQUEST_CODE) {
            if (sp.hasPermission(Manifest.permission.READ_CONTACTS)) {
                // do work here
            }
        }
    }
        
}
