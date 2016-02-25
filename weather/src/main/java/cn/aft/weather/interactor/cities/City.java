package cn.aft.weather.interactor.cities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 2016/02/24 by congtaowang.
 * Version 1.0
 */
public class City implements Parcelable {

    private String cityName;
    private String cityID;

    public City() {
    }

    public City(Parcel source) {
        cityName = source.readString();
        cityID = source.readString();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cityName);
        dest.writeString(cityID);
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
}
