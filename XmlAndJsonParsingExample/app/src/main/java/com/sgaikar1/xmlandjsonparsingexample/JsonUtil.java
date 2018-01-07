package com.sgaikar1.xmlandjsonparsingexample;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Santosh Gaikar on 18/12/17.
 */

public class JsonUtil {

    public static String toJSon(Person person) {
        try {
            // Here we convert Java Object to JSON
            JSONObject jsonObj = new JSONObject();
            // Set the first name/pair
            jsonObj.put("name", person.getName());
            jsonObj.put("surname", person.getSurname());
            // we need another object to store the address
            JSONObject jsonAdd = new JSONObject();
            jsonAdd.put("address", person.getAddress().getAddress());
            jsonAdd.put("city", person.getAddress().getCity());
            jsonAdd.put("state", person.getAddress().getState());

            // We add the object to the main object
            jsonObj.put("address", jsonAdd);

            // and finally we add the phone number
            // In this case we need a json array to hold the java list
            JSONArray jsonArr = new JSONArray();

            for (Person.PhoneNumber pn : person.getPhoneList()) {
                JSONObject pnObj = new JSONObject();
                pnObj.put("num", pn.getNumber());
                pnObj.put("type", pn.getType());
                jsonArr.put(pnObj);
            }

            jsonObj.put("phoneNumber", jsonArr);

            return jsonObj.toString();

        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        return null;

    }

}