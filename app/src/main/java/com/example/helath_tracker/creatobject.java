package com.example.helath_tracker;

import android.os.Parcel;
import android.os.Parcelable;

public class creatobject implements Parcelable {
    String name;



    public creatobject(String name){
        this.name=name;
    }

    protected creatobject(Parcel in) {
        name = in.readString();
    }

    public static final Creator<creatobject> CREATOR = new Creator<creatobject>() {
        @Override
        public creatobject createFromParcel(Parcel in) {
            return new creatobject(in);
        }

        @Override
        public creatobject[] newArray(int size) {
            return new creatobject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }






}
