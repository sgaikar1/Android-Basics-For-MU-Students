package com.sgaikar1.sqliteexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler db = new DBHandler(this);

        // Inserting Shop/Rows
        Log.d("Insert: ", "Inserting ..");
        db.addShop(new Shop("MacD", " 291/12, Opp Chembur station, Chembur"));
        db.addShop(new Shop("Burger King", "Star Mall, Dadar"));
        db.addShop(new Shop("Pizza hut", "91SpringBoard, Andheri"));
        db.addShop(new Shop("Dominoz", "Sindhi camp, Sion"));

        // Reading all shops
        Log.d("Reading: ", "Reading all shops..");
        List<Shop> shops = db.getAllShops();

        for (Shop shop : shops) {
            String log = "Id: " + shop.getId() + " ,\tShop Name: " + shop.getName() + "\n\t\t\tShop Address: " + shop.getAddress()+"\n\n\n";
            // Writing shops  to log
            Log.d("Shop: : ", log);
        }
    }
}
