package com.example.paz.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText etUname, etPword;
    Button btnSave, btnDisplay;
    TextView textView3;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUname = (EditText) findViewById(R.id.name);
        etPword = (EditText) findViewById(R.id.password);
        textView3 = (TextView) findViewById(R.id.displayinformation);
        btnSave = (Button) findViewById(R.id.button4);
        btnDisplay = (Button) findViewById(R.id.button3);
        preferences = getPreferences(Context.MODE_PRIVATE);

    }

    public void saveInfo(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",etUname.getText().toString());
        editor.putString("pwd",etUname.getText().toString());
        editor.commit();
        Toast.makeText(this, "SAVED IN SHARED PREFERENCES!!!", Toast.LENGTH_LONG).show();

    }

    public void displayInfo(View view){
        String user = preferences.getString("user","");
        String password = preferences.getString("pwd","");
        textView3.setText("User is "+ user + "amd the password is " +password);
    }
}
