package com.example.otp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText optNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestSMSPermission();

        optNumber = findViewById(R.id.et_otpNumber);
        new OTP_Receiver().setEditText(optNumber);
    }

    private void requestSMSPermission() {
        String permission = Manifest.permission.RECEIVE_SMS;

        int grant = ContextCompat.checkSelfPermission(this,permission);
        if(grant != PackageManager.PERMISSION_GRANTED){
            String[] permission_list = new String[1];
            permission_list[0] = permission;

            ActivityCompat.requestPermissions(this,permission_list,1);
        }
    }
}
