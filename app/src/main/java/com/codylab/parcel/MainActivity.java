package com.codylab.parcel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onButtonAClicked(View view){
        SerializableDog serializableDog = new SerializableDog("Dodo");
        ParcelableDog parcelableDog = new ParcelableDog("Super Dodo", "Cody");

        Dog normalDog = new Dog("Normal dodo");

        Gson gson = new Gson();
        String gsonDog = gson.toJson(normalDog);
        startActivity(TargetActivity.newIntent(
                this, serializableDog, parcelableDog, gsonDog)
        );
    }
}
