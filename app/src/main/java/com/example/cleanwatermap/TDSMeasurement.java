package com.example.cleanwatermap;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.threeten.bp.LocalDateTime;

public class TDSMeasurement implements Parcelable {
    String id;
    @SerializedName("body")
    LocalDateTime date;
    String deviceName;
    int tdsValue;

    static private String defaultDeviceName = "TDS-3";

    public TDSMeasurement(int tdsValue) {
        this.tdsValue = tdsValue;
        this.date = LocalDateTime.now();
        this.deviceName = defaultDeviceName;
    }

    private TDSMeasurement(Parcel in) {
        id = in.readString();
        date = (LocalDateTime) in.readValue(LocalDateTime.class.getClassLoader());
        deviceName = in.readString();
        tdsValue = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeValue(date);
        dest.writeString(deviceName);
        dest.writeInt(tdsValue);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<TDSMeasurement> CREATOR = new Parcelable.Creator<TDSMeasurement>() {
        @Override
        public TDSMeasurement createFromParcel(Parcel in) {
            return new TDSMeasurement(in);
        }

        @Override
        public TDSMeasurement[] newArray(int size) {
            return new TDSMeasurement[size];
        }
    };
}