package com.codylab.parcel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onButtonAClicked(View view){
        SerializableDog dog = new SerializableDog("Dodo");
        ParcelableDog parcelableDog = new ParcelableDog("Super Dodo", "Cody");

        startActivity(TargetActivity.newIntent(this, dog, parcelableDog));
    }
}
