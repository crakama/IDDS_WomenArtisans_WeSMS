package com.example.cate.wesms;

/**
 * Created by Cate on 1/19/2016.
 */
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
    String phoneNumber,message;
    // DatabaseHandler db;


    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
        // db=new DatabaseHandler(context);
        try {

         // bundle is null

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
            //try {
                //JSONParser jp = new JSONParser();
                //String url = "http://202.125.140.65:3000/shop_owners/index";
                //List<NameValuePair> params = new ArrayList<NameValuePair>();
                //params.add(new BasicNameValuePair("sms_content", message));
               // params.add(new BasicNameValuePair("sms_phonenumber", phoneNumber));
              //  jp.getJSONFromUrl(url, params);
          //  } catch (Exception ex) {
            //    ex.printStackTrace();
         //   }
            return null;
        }
    }
}