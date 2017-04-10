package com.codylab.parcel.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.codylab.parcel.Dog;
import com.codylab.parcel.ParcelableDog;
import com.codylab.parcel.R;
import com.codylab.parcel.SerializableDog;
import com.google.gson.Gson;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    private final static String KEY_DOG_SERIALIZABLE = "dog_serializable";
    private static final String KEY_DOG_PARCELABLE = "dog_parcelable";
    private static final String KEY_DOG_GSON = "dog_gson";
    private static final String KEY_DOG_NAME = "dog_name";
    private static final String KEY_DOG_OWNER = "dog_owner_name";

    public static Intent newIntent(Context context, String dogName, String dogOwnerName){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(KEY_DOG_NAME, dogName);
        intent.putExtra(KEY_DOG_OWNER, dogOwnerName);
        return intent;
    }

    public static Intent newIntent(Context context, SerializableDog serializableDog){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(KEY_DOG_SERIALIZABLE, serializableDog);
        return intent;
    }

    public static Intent newIntent(Context context, ParcelableDog parcelableDog){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(KEY_DOG_PARCELABLE, parcelableDog);
        return intent;
    }

    public static Intent newIntent(Context context, String gsonDog){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(KEY_DOG_GSON, gsonDog);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        Dog dog = null;

        String dogName = getIntent().getStringExtra(KEY_DOG_NAME);
        if(dogName != null){
            dog = new Dog(dogName, getIntent().getStringExtra(KEY_DOG_OWNER));
        }

        SerializableDog serializableDog = (SerializableDog) getIntent().getSerializableExtra(KEY_DOG_SERIALIZABLE);
        if(serializableDog != null){
            dog = serializableDog;
        }

        ParcelableDog parcelableDog = getIntent().getParcelableExtra(KEY_DOG_PARCELABLE);
        if(parcelableDog != null){
            dog = parcelableDog;
        }

        String dogGson = getIntent().getStringExtra(KEY_DOG_GSON);
        if(dogGson != null){
            Gson gson = new Gson();
            dog = gson.fromJson(dogGson, Dog.class);

        }

        if(dog != null){
            Log.d(TAG, dog.getName());
            Log.d(TAG, dog.getOwnerName());

            ((TextView) findViewById(R.id.dogName)).setText(dog.getName());
            ((TextView) findViewById(R.id.ownerName)).setText(dog.getOwnerName());
        }
    }
}
