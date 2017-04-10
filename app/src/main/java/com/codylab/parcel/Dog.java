package com.codylab.parcel;

public class Dog {

    private String mName;
    private String mOwner;

    public Dog(String name, String owner) {
        this.mName = name;
        this.mOwner = owner;
    }

    public Dog(){
        // For the subclasses that implement serializable SerializableDog class
        // https://goo.gl/oxrKmj
    }

    public String getName() {
        return mName;
    }

    public String getOwnerName() {
        return mOwner;
    }
}
