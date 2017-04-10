package com.codylab.parcel;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableDog extends Dog implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(getName());
        out.writeString(getOwnerName());
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
        super(in.readString(), in.readString());
    }

    public ParcelableDog(String name, String owner) {
        super(name, owner);
    }
}
