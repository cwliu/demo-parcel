package com.codylab.parcel;

import java.io.Serializable;

public class SerializableDog extends Dog implements Serializable {

    private String mName;
    private String mOwner;

    public SerializableDog(String name, String owner) {
        super(name, owner);
        this.mName = name;
        this.mOwner = owner;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public String getOwnerName() {
        return mOwner;
    }
}
