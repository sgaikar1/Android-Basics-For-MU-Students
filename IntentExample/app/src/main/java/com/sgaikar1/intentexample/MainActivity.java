package com.sgaikar1.intentexample;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends Activity
{
    Button btnBrowser, btnDialer, btnMap, btnContact;
    int request_Code = 1;
    private Button btnNew;

    // Called when the activity is first created. 
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBrowser = (Button) findViewById(R.id.btn_webbrowser);
        btnBrowser.setOnClickListener(new OnClickListener()
        {
            public void onClick(View arg0){
                Intent i = new
                        Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/sgaikar1"));
                startActivity(i);
            }
        });


//Make calls button---
        btnDialer = (Button) findViewById(R.id.btn_makecalls);
        btnDialer.setOnClickListener(new OnClickListener()
        {
            public void onClick(View arg0){
                Intent i = new
                        Intent(android.content.Intent.ACTION_DIAL,
                        Uri.parse("tel:+919821507043"));
                startActivity(i);
            }
        });


//Show Map button


        btnMap = (Button) findViewById(R.id.btn_showMap);
        btnMap.setOnClickListener(new OnClickListener()
        {
            public void onClick(View arg0)
            {
                Intent i = new
                        Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("geo:19.030906,72.864826"));
                startActivity(i);
            }
        });


//Choose Contact button


        btnContact = (Button) findViewById(R.id.btn_chooseContact);
        btnContact.setOnClickListener(new OnClickListener()
        {
            public void onClick(View arg0){
                Intent i = new
                        Intent(android.content.Intent.ACTION_PICK);
                i.setType(ContactsContract.Contacts.CONTENT_TYPE);
                startActivityForResult(i,request_Code);
            }
        });

        btnNew = (Button) findViewById(R.id.btn_new);
        btnNew.setOnClickListener(new OnClickListener()
        {
            public void onClick(View arg0){
                Intent i = new
                        Intent(MainActivity.this, NotificationActivity.class);
                startActivity(i);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == request_Code)
        {
            if (resultCode == RESULT_OK)
            {

                Toast.makeText(this,data.getData().toString(),
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(
                        android.content.Intent.ACTION_VIEW,
                        Uri.parse(data.getData().toString()));
                startActivity(i);
            }
        }
    }
}