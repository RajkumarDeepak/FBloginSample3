package com.example.android.fbloginsample;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by Raushan on 10/18/2016.
 */

public class MyApplication extends Application {
    public void onCreate(){
        super.onCreate();
        printHashKey();

    }
    public void printHashKey(){

            try {
                PackageInfo info = getPackageManager().getPackageInfo(
                        "com.example.android.fbloginsample",
                        PackageManager.GET_SIGNATURES);
                for (Signature signature : info.signatures) {
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
                }
            } catch (PackageManager.NameNotFoundException e) {

            } catch (NoSuchAlgorithmException e) {

            }

        }

        }




