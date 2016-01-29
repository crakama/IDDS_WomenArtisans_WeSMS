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

        long scTime = 5000;//2mins

        // Start the SMS Listener
        Intent intent = new Intent(this, MyAlarmManager.class);
        startService(intent);

        //Starting Routine Services
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

                // Routines ...

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