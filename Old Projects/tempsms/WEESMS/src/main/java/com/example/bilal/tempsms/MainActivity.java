package com.example.bilal.tempsms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = new Intent(this, MyAlarmManager.class);

        long scTime = 5000;//2mins

        //Intent intent = new Intent(this, MyAlarmManager.class);
        //startService(intent);
        //Asynctask_polling1 a=new Asynctask_polling1();
        //a.execute();

    }

    public class Asynctask_polling1 extends AsyncTask<String, Void, Void> {

        public Asynctask_polling1() {
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... args) {
            try {

                // routine


                /*JSONParser jp = new JSONParser();
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
*/

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


        }
    }

}
