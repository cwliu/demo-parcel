# demo-parcel

A simple project to demonstrate how to pass an object between Android activities

## Screenshots

![activity-1](https://i.imgur.com/3ZAm9ZK.png)
![activity-2](https://i.imgur.com/AqsfNTh.png)

Passing an object from between activities needs some extra efforts, there are at least three ways to archive this goal:

1. Using a serializable interface
2. Using a parcelable interface
3. Using Google's Gson library to convert from an object to a JSON string

## Scenario

For instance, passing two strings to another activity could be archived like this:

```
Intent intent = new Intent(context, SecondActivity.class);
intent.putExtra(KEY_DOG_NAME, dogName);
intent.putExtra(KEY_DOG_OWNER, dogOwnerName);
```

If there are too many parameters, we can encapsulate them into a dog object:

```
public class Dog {

    private String mName;
    private String mOwner;

    public Dog(String name, String owner) {
        this.mName = name;
        this.mOwner = owner;
    }
    ...
}
```

However, Only primitive types, serializable and parcelable could be transferred to another activity. In the following, I will demonstrate how to get these done with examples.

## Serializable

```
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
```

Here is an example that a SerialzableDog class extends Serializable. Please note that we need to define the data fields must be defined here.


## Parcel

[Parcel](https://goo.gl/Ieh8YM) is a container for a message(data and object reference) that can be sent through an IBinder. Here is a  basic example:

```
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
```

## Gson

Using [Gson](https://github.com/google/gson), you don't need to modify the existing object implementation.

Serialize an object to JSON string:

```
String dogJson = new Gson().toJson(new Dog("Dodo", "Cody"));
startActivity(SecondActivity.newIntent(this, dogJson));
```

Deserialize JSON string to a basic object:

```
String dogGson = getIntent().getStringExtra(KEY_DOG_GSON);
if(dogGson != null){
    Gson gson = new Gson();
    Dog dog = gson.fromJson(dogGson, Dog.class);
}

```

## Conclusion

1. Serializable is easier to implement than parcel
2. Parcel is faster, but it is only available on Android and [it is not appropriate to save into a file](https://goo.gl/xzyINb).
3. Parcel array could be passed via intent
4. Gson is the most straightforward way to use. No modification needed to existed classes
