package com.example.bilal.tempsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bilal on 1/5/16.
 */
public class SmsBroadcastreciever extends BroadcastReceiver {
    final SmsManager sms = SmsManager.getDefault();
    SmsProcessor smspr = new SmsProcessor();
    String phoneNumber,message;
    // DatabaseHandler db

    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
       // db=new DatabaseHandler(context);
        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;
                    message = currentMessage.getDisplayMessageBody();
                    Log.i("SmsReceiver", "senderNum: " + senderNum + "; message: " + message);

                    Asynctask_replaymessage a=new Asynctask_replaymessage();
                    a.execute();
                    // Show Alert

                } // end for loop
            } // bundle is null

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e);

        }
    }
    public class Asynctask_replaymessage extends AsyncTask<String, Void, Void> {

        public Asynctask_replaymessage() {
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... args) {
            try {
                // Receiving...
                Log.i("SmsReceiver", "senderNum: " + phoneNumber + "; message: " + message);

                // Processing

                String repl = smspr.receive(phoneNumber,message);

                // Send Reply

                Log.i("SmsReply", "recNum: " + phoneNumber + "; message: " + repl);
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, repl, null, null);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }

}
