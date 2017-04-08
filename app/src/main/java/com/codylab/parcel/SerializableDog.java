package com.codylab.parcel;

import java.io.Serializable;

class SerializableDog implements Serializable {
    private final String mName;

    public SerializableDog(String name){
        this.mName = name;
    }

    public String getName() {
        return mName;
    }
}
