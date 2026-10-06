package com.mob.xtravuwatchdog.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import android.widget.Toast


class UsbBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        val device = intent.getParcelableExtra<UsbDevice>(UsbManager.EXTRA_DEVICE)

        if (UsbManager.ACTION_USB_DEVICE_ATTACHED == action) {
           // Toast.makeText(context, "USB device attached: " + device!!.deviceName, Toast.LENGTH_SHORT).show()
        } else if (UsbManager.ACTION_USB_DEVICE_DETACHED == action) {
           // Toast.makeText(context, "USB device detached: " + device!!.deviceName, Toast.LENGTH_SHORT).show()
        }
    }
}
