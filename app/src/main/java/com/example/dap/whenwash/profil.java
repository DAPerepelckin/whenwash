package com.example.dap.whenwash;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import static com.example.dap.whenwash.MainActivity.APP_PREFERENCES;
import static com.example.dap.whenwash.MainActivity.APP_PREFERENCES_EMAIL;
import static com.example.dap.whenwash.MainActivity.APP_PREFERENCES_PASSWORD;
import static com.example.dap.whenwash.R.layout.abc_alert_dialog_button_bar_material;
import static com.example.dap.whenwash.R.layout.item;

public class profil extends AppCompatActivity {
    private static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_profil);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu1, menu);
        return true;
    }

    public void SaveDataNULL(){
        SharedPreferences values = getApplicationContext()
                .getSharedPreferences(APP_PREFERENCES, 0);
        SharedPreferences.Editor editor = values.edit();
        editor.putString(APP_PREFERENCES_EMAIL,"");
        editor.putString(APP_PREFERENCES_PASSWORD,"");
        editor.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                return true;
            case android.R.id.home:
                finish();
                return true;
            case R.id.exit:
                SaveDataNULL();
                Intent mStartActivity = new Intent(context, MainActivity.class);
                int mPendingIntentId = 123456;
                PendingIntent mPendingIntent = PendingIntent.getActivity(context, mPendingIntentId,    mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager mgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
                mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1, mPendingIntent);
                System.exit(0);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}