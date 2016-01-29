package com.example.bilal.tempsms;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.telephony.SmsManager;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by bilal on 1/16/16.
 */public class MyAlarmManager extends IntentService {

    private String tag = "MyService";
    private Handler mHandler = new Handler();
    // timer handling
    private Timer mTimer = null;
    public static final long NOTIFY_INTERVAL = 5 * 60 * 1000; // 60 seconds

    public MyAlarmManager() {
        super("MyService");

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (mTimer != null) {
            mTimer.cancel();
        } else {
            // recreate new
            mTimer = new Timer();
        }
        // schedule task
        mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 60 * 1000, NOTIFY_INTERVAL);

    }
    class TimeDisplayTimerTask extends TimerTask {

        @Override
        public void run() {
            // run on another thread
            mHandler.post(new Runnable() {

                @Override
                public void run() {
                    Asynctask_polling a=new Asynctask_polling();
                    a.execute();
                }

            });
        }
    }
    public class Asynctask_polling extends AsyncTask<String, Void, Void> {

        public Asynctask_polling() {
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... args) {
            /*
            try {
                JSONParser jp = new JSONParser();
                String url = "http://202.125.140.65:3000/shop_owners/sms_listener.json";
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                JSONArray as=jp.getJSONFromUrl(url, params);
                for(int i=0;i<as.length();i++){
                    JSONObject j=as.getJSONObject(i);
                    SmsManager smsManager = SmsManager.getDefault();
                    String ph=j.getString("recipient_phonenumber");
                    String msg=j.getString("content");
                    smsManager.sendTextMessage(ph, null, msg , null, null);

                }


            } catch (Exception ex) {
                ex.printStackTrace();
            }
            */
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


        }
    }
}
