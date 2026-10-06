package com.mob.xtravuwatchdog.utils;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbConstants;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FileUtils {

    private final static String TAG="FileUtils";
    public static String getUSBProblematic(Context context){
        UsbManager usbManager = (UsbManager) context.getSystemService(Context.USB_SERVICE);
        if (usbManager == null) {
            Log.e(TAG, "Unable to get USB_SERVICE");
            return "";
        }
        UsbAccessory[] accessoryList = usbManager.getAccessoryList();
        if (accessoryList != null) {
            for (UsbAccessory usbAccessory : accessoryList) {
                // here we check the vendor
                Log.d(TAG, "getUSBProblematic: " + usbAccessory.toString());
            }
        }

        HashMap<String, UsbDevice> deviceList = usbManager.getDeviceList();
        if(deviceList != null) {
            List<UsbDevice> usbDeviceList = new ArrayList<>(deviceList.values());

            for (Iterator<UsbDevice> iterator = usbDeviceList.iterator(); iterator.hasNext();) {
                UsbDevice next = iterator.next();

                boolean isMassStorage = false;
                for (int i = 0; i < next.getInterfaceCount(); i++) {
                    // Check USB interface type is mass storage
                    UsbInterface usbInterface = next.getInterface(i);
                    if(usbInterface.getInterfaceClass() == UsbConstants.USB_CLASS_MASS_STORAGE && usbInterface.getEndpointCount() == 2) {

                        // Check endpoints support bulk transfer
                        for (int j = 0; j < usbInterface.getEndpointCount(); j++) {
                            UsbEndpoint endpoint = usbInterface.getEndpoint(j);
                            if(endpoint != null) {
                                if(endpoint.getType() == UsbConstants.USB_ENDPOINT_XFER_BULK){

                                    // Valid mass storage
                                    isMassStorage = true;
                                }
                            }
                        }
                    }
                }

                if(!isMassStorage) {
                    iterator.remove();
                }
            }

            for (UsbDevice usbDevice : usbDeviceList) {
                Log.d(TAG, "getUSBProblematic: Device Name" + usbDevice.getDeviceName());
                Log.d(TAG, "getUSBProblematic: Device Desc" + usbDevice.toString());
            }
        }
        return "";
    }
  /*
    getUSBProblematic: Device Name/dev/bus/usb/001/002
    getUSBProblematic: Device DescUsbDevice[mName=/dev/bus/usb/001/002,mVendorId=1008,mProductId=6533,mClass=0,mSubclass=0,mProtocol=0,mManufacturerName=HP,mProductName=USB Flash Drive,mVersion=1.10,mSerialNumber=070D29148C01D306,mConfigurations=[
    UsbConfiguration[mId=1,mName=null,mAttributes=128,mMaxPower=150,mInterfaces=[
    UsbInterface[mId=0,mAlternateSetting=0,mName=null,mClass=8,mSubclass=6,mProtocol=80,mEndpoints=[
    UsbEndpoint[mAddress=129,mAttributes=2,mMaxPacketSize=512,mInterval=0]
    UsbEndpoint[mAddress=2,mAttributes=2,mMaxPacketSize=512,mInterval=0]]]]
  */
    public static String getUSB(){
        File storageDirectory = new File("/storage");
        if(!storageDirectory.exists()) {
            Log.e(TAG, "getUSB: '/storage' does not exist on this device");
            return "";
        }

        File[] files = storageDirectory.listFiles();
        if(files == null) {
            Log.e(TAG, "getUSB: Null when requesting directories inside '/storage'");
            return "";
        }

        List<String> possibleUSBStorageMounts = new ArrayList<>();
        for (File file : files) {
            String path = file.getPath();
            if (path.contains("emulated") ||
                    path.contains("sdcard") ||
                    path.contains("self")) {
                Log.d(TAG, "getUSB: Found '" + path + "' - not USB");
            } else {
                possibleUSBStorageMounts.add(path);
            }
        }

        if (possibleUSBStorageMounts.size() == 0) {
            Log.e(TAG, "getUSB: Did not find any possible USB mounts");
            return "";
        }
        if(possibleUSBStorageMounts.size() > 1) {
            Log.d(TAG, "getUSB: Found multiple possible USB mount points, choosing the first one");
        }

        return possibleUSBStorageMounts.get(0);
    }
    public static String getAllStoragePath() {
        String finalPath = "";
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("mount");
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            String line;
            String[] pathArray = new String[4];
            int i = 0;

            BufferedReader br = new BufferedReader(inputStreamReader);
            while ((line = br.readLine()) != null) {
                String mount = "";
                if (line.contains("secure"))
                    continue;
                if (line.contains("asec"))
                    continue;

                if (line.contains("fat")) {// TF card
                    String columns[] = line.split(" ");
                    if (columns.length > 1) {
                        mount = mount.concat(columns[1] + "/someFiles");

                        pathArray[i++] = mount;

                        // check directory inputStream exist or not
                        File dir = new File(mount);
                        if (dir.exists() && dir.isDirectory()) {
                            // do something here
                            finalPath = mount;
                            break;
                        }
                    }
                }
            }

            for(String path:pathArray){
                if(path!=null){
                    finalPath =finalPath + path +"\n";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalPath;
    }
}
