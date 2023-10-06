package smith.test.spermission;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import smith.lib.tools.perms.SPermissions;
import smith.test.spermission.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private SPermissions sp = SPermissions.with(this);
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        smith.test.spermission.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        if (!sp.hasPermission(Manifest.permissions.CAMERA)) {
            sp.requestPermission(Manifest.permissions.CAMERA);
//                sp.requestPermissions(Manifest.permissions.WRITE_EXTERNAL_STORAGE,
//                        Manifest.permissions.READ_EXTERNAL_STORAGE);
        }
        
    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] resultCodes) {
        super.onRequestPermissionsResult(requestCode, permissions, resultCodes);
        if (requestCode == SPermissions.REQUEST_CODE) {
            if (sp.hasPermission(Manifest.permissions.READ_CONTACTS)) {
                // do work here
            }
        }
    }
        
}
