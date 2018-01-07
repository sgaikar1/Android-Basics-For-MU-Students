package com.sgaikar1.xmlandjsonparsingexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santosh Gaikar on 18/12/17.
 */

public class JsonParsingActivity extends Activity{

    private Button btnParse,btnCreate;
    private TextView text;
    private String personData = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        btnCreate = (Button)findViewById(R.id.btn_create);
        btnParse= (Button)findViewById(R.id.btn_parse);
        text= (TextView)findViewById(R.id.text);


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person.Address address = new Person.Address("Antophill","Mumbai","Maharashtra");
                Person.PhoneNumber phoneNumber1 = new Person.PhoneNumber("Home","022-23333333");
                Person.PhoneNumber phoneNumber2 = new Person.PhoneNumber("Mobile","9821507043");
                List<Person.PhoneNumber> listPhone = new ArrayList<>();
                listPhone.add(phoneNumber1);
                listPhone.add(phoneNumber2);

                Person person = new Person("Santosh","Gaikar",address,listPhone);

                personData = JsonUtil.toJSon(person);
                text.setText(personData);
            }
        });

        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(personData)) {
                    parseJsonText(personData);
                }
            }
        });


    }

    private void parseJsonText(String personData) {
        try {
            JSONObject jObj = new JSONObject(personData);
            String name = jObj.getString("name");
            String surname = jObj.getString("surname");

            JSONObject subObj = jObj.getJSONObject("address");
            String city = subObj.getString("city");
            String address = subObj.getString("address");
            String state = subObj.getString("state");

            StringBuilder sb = new StringBuilder();
            sb.append(name+" "+surname+"\n\n"
                    +"Address \n"
                    +address+" "+city+" "+state+"\n\n"
                    +"Phone Number \n");

            JSONArray jArr = jObj.getJSONArray("phoneNumber");

            for (int i=0; i < jArr.length(); i++) {
                JSONObject obj = jArr.getJSONObject(i);
                sb.append(obj.getString("type"));
                sb.append(" "+obj.getString("num")+"\n");
            }

            text.setText(sb);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}