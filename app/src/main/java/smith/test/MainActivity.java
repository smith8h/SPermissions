package smith.test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.util.Log;
import android.content.Context;
import android.widget.Toast;
import smith.lib.tools.perms.SPermissions;
import smith.test.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding binding;
    private SPermissions sp;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        
        sp = SPermissions.with(this);
        
        String[] permissions = {
            SPermissions.WRITE_EXTERNAL_STORAGE,
            SPermissions.READ_EXTERNAL_STORAGE
        };
        
        if (sp.hasPermission(SPermissions.CAMERA)) {
            if (sp.hasPermissions(permissions)) {
                sp.requestPermission(SPermissions.ACCESS_FINE_LOCATION);
                // sp.requestPermissions(permissions);
            }
        }
        
    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] resultCodes) {
        super.onRequestPermissionsResult(requestCode, permissions, resultCodes);
        if (requestCode == SPermissions.REQUEST_CODE) {
            if (sp.hasPermission(SPermissions.READ_CONTACTS)) {
                // do work here
            }
        }
    }
        
}
