package com.mob.xtravuwatchdog.utils;



import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


import com.mob.xtravuwatchdog.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class GeneralUtils {
    private static final String TAG = "GeneralUtils";
    private Dialog appUpdatedDialog;
    public void showToast(String message, Context appCompatActivity)
    {

        try {
            if (appUpdatedDialog != null && appUpdatedDialog.isShowing()) {
                appUpdatedDialog.dismiss();
            }
            appUpdatedDialog = new Dialog(appCompatActivity);
            appUpdatedDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            appUpdatedDialog.setContentView(R.layout.show_toast_dialog);
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            Window window = appUpdatedDialog.getWindow();
            lp.copyFrom(window.getAttributes());
            appUpdatedDialog.setCancelable(true);
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.MATCH_PARENT;
            window.setAttributes(lp);
            appUpdatedDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            appUpdatedDialog.show();
            appUpdatedDialog.setCanceledOnTouchOutside(true);
            TextView title = appUpdatedDialog.findViewById(R.id.tv_desc);
            title.setText(message);

            appUpdatedDialog.findViewById(R.id.txtOk).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appUpdatedDialog.dismiss();
                }
            });

            appUpdatedDialog.findViewById(R.id.llLoginWithPhn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appUpdatedDialog.dismiss();
                }
            });

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    /*
     public void showToast(String message, Context context) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    */

    public boolean isInternetAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting()
                && cm.getActiveNetworkInfo().isAvailable()
                && cm.getActiveNetworkInfo().isConnected();
    }

    public Spanned getStringFromHtmlText(String baseString) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(baseString, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(baseString);
        }
    }

    public Boolean isValidEmail(String Email) {

        return (!TextUtils.isEmpty(Email) && Patterns.EMAIL_ADDRESS.matcher(Email).matches());
    }

    public Boolean isValidPwd(String pwd) {
        //"^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$"
        return pwd.length() > 5;
    }

    /*create hash key*/
    public  final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /*  public static void getTickerTime(long matchEndTIme) {

            long difference = matchEndTIme - System.currentTimeMillis();

            long x = difference / 1000;
            long seconds = x % 60;
            x /= 60;
            long minutes = x % 60;
            x /= 60;
            long hours = x % 24;
            x /= 24;
            long days = x;
        }*/

    public long getLongTime(String endDate) {
        long timeInMilliseconds = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
        try {
            Date mDate = sdf.parse(endDate);
            timeInMilliseconds = mDate.getTime();
//            System.out.println("Date in milli :: " + timeInMilliseconds);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeInMilliseconds;
    }

    /*
       private String getImeiNumber(Context mContext) {
            final TelephonyManager telephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //getDeviceId() is Deprecated so for android O we can use getImei() method
                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                    //
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return null;
                }
                return telephonyManager.getImei();
            }
            else {
                return telephonyManager.getDeviceId();
            }

        }*/
    /*

        private void askForPermission(String permission, Integer requestCode) {
          //  if (ContextCompat.checkSelfPermission(MainActivity.this, permission) != PackageManager.PERMISSION_GRANTED) {

                // Should show an explanation
                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permission)) {

                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);

                } else {

                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);
                }
            } else {
                imei = getImeiNumber();
                getClientPhoneNumber();
                androidid=getAndroidId();
                Toast.makeText(this,permission + " is already granted.", Toast.LENGTH_SHORT).show();
            }
        }



        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
        {
            switch (requestCode) {
                case 1: {

                    // If request is cancelled, the result arrays are empty.
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                        imei = getImeiNumber();
                        getClientPhoneNumber();
                        androidid=getAndroidId();

                    } else {

                        Toast.makeText(MainActivity.this, "You have Denied the Permission", Toast.LENGTH_SHORT).show();
                    }
                    return;
                }
            }
        }

    */

    /*
    Regex for Full Name
    */

    public static boolean checkName(String str) {
        String expression = "^[a-zA-Z\\s]+";
        return str.matches(expression);
    }

    public static boolean checkIFSCCode(String str) {
        String expression = "^[A-Za-z0-9]+";
        return str.matches(expression);
    }

    public static void printHashKey(Context pContext) {
        try {
            PackageInfo info = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
            for (android.content.pm.Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i(TAG, "printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "printHashKey()", e);
        } catch (Exception e) {
            Log.e(TAG, "printHashKey()", e);
        }
    }

    public static boolean isServiceRunning(Context context, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

}