package com.codylab.parcel;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableDog implements Parcelable {

    private String mName;
    private String mOwner;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mName);
        out.writeString(mOwner);
    }

    public static final Parcelable.Creator<ParcelableDog> CREATOR
            = new Parcelable.Creator<ParcelableDog>() {
        public ParcelableDog createFromParcel(Parcel in) {
            return new ParcelableDog(in);
        }

        public ParcelableDog[] newArray(int size) {
            return new ParcelableDog[size];
        }
    };

    public ParcelableDog(Parcel in) {
        mName = in.readString();
        mOwner = in.readString();
    }

    public ParcelableDog(String name, String owner){
        mName = name;
        mOwner = owner;
    }

    public String getName() {
        return mName;
    }

    public String getOwner() {
        return mOwner;
    }
}
