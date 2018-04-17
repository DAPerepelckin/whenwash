package com.example.dap.whenwash;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.dap.whenwash.MainActivity.APP_PREFERENCES;
import static com.example.dap.whenwash.MainActivity.APP_PREFERENCES_EMAIL;
import static com.example.dap.whenwash.MainActivity.APP_PREFERENCES_PASSWORD;
import static com.example.dap.whenwash.R.layout.abc_alert_dialog_button_bar_material;
import static com.example.dap.whenwash.R.layout.item;

public class profil extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static Context context;
    private String email="";
    private String password1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_profil);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                } else {
                }
                // ...
            }
        };
        dial();


    }

    public void SaveData(){
        SharedPreferences values = getApplicationContext()
                .getSharedPreferences(APP_PREFERENCES, 0);
        SharedPreferences.Editor editor = values.edit();
        editor.putString(APP_PREFERENCES_EMAIL,email);
        editor.putString(APP_PREFERENCES_PASSWORD,password1);
        editor.commit();
    }

    public void dial(){
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.auth, null);
        AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(this);
        mDialogBuilder.setView(promptsView);
        final EditText userInput = (EditText) promptsView.findViewById(R.id.input_text);
        final EditText userInput1 = (EditText) promptsView.findViewById(R.id.input_text1);

        mDialogBuilder.setCancelable(false).setPositiveButton("OK",null).setNegativeButton("Назад",null).setNeutralButton("Добавить",null);

        final AlertDialog dialog = mDialogBuilder.create();
        dialog.show();
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = userInput.getText().toString();
                password1 = userInput1.getText().toString();
                if(!email.isEmpty()||!password1.isEmpty()) {

                    mAuth.signInWithEmailAndPassword(email, password1)
                            .addOnCompleteListener(profil.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        SaveData();
                                        dialog.dismiss();
                                    }else{
                                        Toast.makeText(profil.this, R.string.auth_failed,
                                        Toast.LENGTH_SHORT).show();
                                    }

                                }
                    });
                }
            }

        });
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                finish();
            }
        });
        dialog.getButton(DialogInterface.BUTTON_NEUTRAL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = userInput.getText().toString();
                password1 = userInput1.getText().toString();
                if(!email.isEmpty()||!password1.isEmpty()) {
                mAuth.createUserWithEmailAndPassword(email, password1)
                        .addOnCompleteListener(profil.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    SaveData();
                                    dialog.dismiss();
                                }else{
                                    Toast.makeText(profil.this, task.getException().toString(),
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });

            }}
        });


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