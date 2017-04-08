package com.codylab.parcel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.Serializable;

public class TargetActivity extends AppCompatActivity {

    private static final String TAG = "TargetActivity";

    private final static String KEY_DOG = "dog";
    private static final String KEY_DOG_PARCELABLE = "dog_parcelable";

    public static Intent newIntent(Context context, Serializable dog, ParcelableDog dog2){
        Intent intent = new Intent(context, TargetActivity.class);
        intent.putExtra(KEY_DOG, dog);
        intent.putExtra(KEY_DOG_PARCELABLE, dog2);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);


        SerializableDog dog = (SerializableDog) getIntent().getSerializableExtra(KEY_DOG);
        Log.d(TAG, dog.getName());

        ParcelableDog dogParcelable = getIntent().getParcelableExtra(KEY_DOG_PARCELABLE);
        Log.d(TAG, dogParcelable.getName());
        Log.d(TAG, dogParcelable.getOwner());
    }
}
