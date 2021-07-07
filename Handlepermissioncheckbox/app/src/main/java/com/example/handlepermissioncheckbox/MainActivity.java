package com.example.handlepermissioncheckbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mbtn;
    private static int REQ_CODE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn=findViewById(R.id.btnRequestPermission);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String []permission={Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this,permission,REQ_CODE);


            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            shown("Granted");
        else if (grantResults[0] == PackageManager.PERMISSION_DENIED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,
                        "Permission denied by checking don't show again, go to settings and enable ", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void shown(String massage)
    {
        Toast.makeText(this,massage,Toast.LENGTH_SHORT).show();
    }
}