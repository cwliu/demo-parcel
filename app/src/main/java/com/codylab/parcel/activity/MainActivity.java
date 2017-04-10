package com.codylab.parcel.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.codylab.parcel.Dog;
import com.codylab.parcel.ParcelableDog;
import com.codylab.parcel.R;
import com.codylab.parcel.SerializableDog;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNoEncapsulationClicked(View view) {
        startActivity(SecondActivity.newIntent(this, "Dodo", "Cody"));
    }

    public void onSerializableClicked(View view) {
        startActivity(SecondActivity.newIntent(this, new SerializableDog("Dodo", "Cody")));
    }

    public void onParcelClicked(View view) {
        startActivity(SecondActivity.newIntent(this, new ParcelableDog("Dodo", "Cody")));
    }

    public void onGsonClicked(View view) {
        String dogJson = new Gson().toJson(new Dog("Dodo", "Cody"));
        startActivity(SecondActivity.newIntent(this, dogJson));
    }
}
