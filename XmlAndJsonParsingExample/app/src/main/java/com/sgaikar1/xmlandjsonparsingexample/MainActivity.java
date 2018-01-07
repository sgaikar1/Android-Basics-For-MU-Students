package com.sgaikar1.xmlandjsonparsingexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnJson,btnXml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnXml = (Button)findViewById(R.id.btn_xml);
        btnJson = (Button)findViewById(R.id.btn_json);

        btnXml.setOnClickListener(this);
        btnJson.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_xml:
                Intent intent = new Intent(this, XmlParsingActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_json:
                Intent i = new Intent(this, JsonParsingActivity.class);
                startActivity(i);
                break;
        }

    }
}
