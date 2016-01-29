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
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bilal on 1/5/16.
 */
public class SmsBroadcastreciever extends BroadcastReceiver {

    String phoneNumber,message;
    // DatabaseHandler db;


    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
       // db=new DatabaseHandler(context);
        try {

          if (bundle != null) {

               final Object[] pdusObj = (Object[]) bundle.get("pdus");

               for (int i = 0; i < pdusObj.length; i++) {

                   SmsMessage currentSMS = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    phoneNumber = currentSMS.getDisplayOriginatingAddress();

                   String senderNum = phoneNumber;
                   message = currentSMS.getDisplayMessageBody();
                    Log.i("SmsReceiver", "senderNum: " + senderNum + "; message: " + message);

                  // SmsManager sms = SmsManager.getDefault();
                   //sms.sendTextMessage(senderNum, null, "Test 2 IDDS", null, null);


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

                // message data
                String senderNo = phoneNumber;
                String sms_content = message;

                // process message and prepare reply
                String sms_reply = SmsProcessor.process(senderNo, sms_content);

                // send reply
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, sms_reply , null, null);


                /*JSONParser jp = new JSONParser();
                String url = "http://202.125.140.65:3000/shop_owners/index";
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("sms_content", message));
                params.add(new BasicNameValuePair("sms_phonenumber", phoneNumber));
                jp.getJSONFromUrl(url, params);**/
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }

}
