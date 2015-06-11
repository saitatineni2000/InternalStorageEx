package com.example.saisandeep.internalstorageex;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    EditText username,password;
    Button save,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username= (EditText) findViewById(R.id.editText);
        password= (EditText) findViewById(R.id.editText2);
        save= (Button) findViewById(R.id.button);
        next= (Button) findViewById(R.id.button2);
    }


    public void save(View v){

        String textUsername=username.getText().toString();
        String textPassword=password.getText().toString();

        textUsername=textUsername+" ";

        FileOutputStream fos=null;
        File file=null;
        try {
            file=getFilesDir();//gets the directory of the file stored
            fos=openFileOutput("sandeep.txt", Context.MODE_PRIVATE);
            fos.write(textUsername.getBytes());
            fos.write(textPassword.getBytes());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {

                try {
                    if (fos != null) {
                    fos.close();}
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }

        Toast.makeText(this,"Saved successfully"+file+" /sandeep.txt",Toast.LENGTH_SHORT).show();

    }

    public void next(View v){

        Intent i=new Intent(this,ActivityB.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
