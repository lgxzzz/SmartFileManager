package com.smart.filemanager.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import com.smart.filemanager.utils.SharedPreferenceUtil;

public class StartUI extends Activity {
    boolean mIsFirstTimeUse = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.start);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy( builder.build() );

        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestReadExternalPermission();
        }else{
            start();
        }

    }

    @SuppressLint("NewApi")
    private void requestReadExternalPermission() {
        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            Log.d("lgx", "READ permission IS NOT granted...");

            if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {

                Log.d("lgx", "11111111111111");

            } else {
                // 0 是自己定义的请求coude
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
                Log.d("lgx", "222222222222");
            }
        } else {
            Log.d("lgx", "READ permission is granted...");
            start();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        Log.d("lgx", "requestCode=" + requestCode + "; --->" + permissions.toString()
                + "; grantResult=" + grantResults.toString());
        switch (requestCode) {
            case 0: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted
                    // request successfully, handle you transactions
                    start();
                } else {

                    // permission denied
                    // request failed
                    Toast.makeText(getApplicationContext(),"请先授权读取权限",Toast.LENGTH_LONG).show();
                }

                return;
            }
            default:
                break;

        }
    }

    public void start(){
        mIsFirstTimeUse = SharedPreferenceUtil.getFirstTimeUse();

        if (mIsFirstTimeUse) {
            Intent intent = new Intent(StartUI.this, WelcomActivity.class);
            startActivity(intent);
            finish();
        } else {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent mainIntent = new Intent(StartUI.this, MainActivity.class);
                    startActivity(mainIntent);
                    overridePendingTransition(R.anim.fade, R.anim.hold);
                    finish();
                }
            }, 1200);
        }
    }
}
