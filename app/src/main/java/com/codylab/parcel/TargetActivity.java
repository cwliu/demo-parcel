package com.codylab.parcel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import java.io.Serializable;

public class TargetActivity extends AppCompatActivity {

    private static final String TAG = "TargetActivity";

    private final static String KEY_DOG_SERIALIZABLE = "dog_serializable";
    private static final String KEY_DOG_PARCELABLE = "dog_parcelable";
    private static final String KEY_DOG_GSON = "dog_gson";

    public static Intent newIntent(Context context,
                                   Serializable serializable, ParcelableDog parcelableDog,
                                   String gsonDog){
        Intent intent = new Intent(context, TargetActivity.class);
        intent.putExtra(KEY_DOG_SERIALIZABLE, serializable);
        intent.putExtra(KEY_DOG_PARCELABLE, parcelableDog);
        intent.putExtra(KEY_DOG_GSON, gsonDog);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);


        SerializableDog dog = (SerializableDog) getIntent().getSerializableExtra(KEY_DOG_SERIALIZABLE);
        Log.d(TAG, dog.getName());

        ParcelableDog dogParcelable = getIntent().getParcelableExtra(KEY_DOG_PARCELABLE);
        Log.d(TAG, dogParcelable.getName());
        Log.d(TAG, dogParcelable.getOwner());

        String dogGson = getIntent().getStringExtra(KEY_DOG_GSON);
        Gson gson = new Gson();
        Dog gsonDog = gson.fromJson(dogGson, Dog.class);
        Log.d(TAG, gsonDog.getName());
    }
}
