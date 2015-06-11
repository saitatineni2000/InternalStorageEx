package com.example.saisandeep.internalstorageex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by saisandeep on 3/16/2015.
 */
public class ActivityB extends Activity {

    Button load,previous;
    TextView usernameRetreive,passwordRetreive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityb);
        load= (Button) findViewById(R.id.button3);
        previous= (Button) findViewById(R.id.button4);
        usernameRetreive= (TextView) findViewById(R.id.textView5);
        passwordRetreive= (TextView) findViewById(R.id.textView6);


    }

    public void load(View v){

        FileInputStream fis=null;
        try {
            fis=openFileInput("sandeep.txt");
            int read=-1;
            StringBuffer buffer=new StringBuffer();

            while((read=fis.read())!= -1)
            {
                buffer.append((char)read);
            }

            Log.d("Sandeep",buffer.toString());

            String text1=buffer.substring(0,buffer.indexOf(" "));
            String text2=buffer.substring(buffer.indexOf(" ")+1);

            usernameRetreive.setText(text1);
            passwordRetreive.setText(text2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

                try {
                    if (fis != null) {
                    fis.close();}
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
        Toast.makeText(this, "Loaded successfully", Toast.LENGTH_SHORT).show();
    }

    public void previous(View v){

        Intent in=new Intent(this,MainActivity.class);
        startActivity(in);
    }
}
