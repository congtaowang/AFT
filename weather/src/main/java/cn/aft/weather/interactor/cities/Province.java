package cn.aft.weather.interactor.cities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 2016/02/24 by congtaowang.
 * Version 1.0
 */
public class Province implements Parcelable {

    private String provinceName;
    private List<City> cities;

    public Province() {
    }

    public Province(Parcel source) {
        provinceName = source.readString();
        cities = new ArrayList<>();
        source.readTypedList(cities, City.CREATOR);
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(provinceName);
        dest.writeTypedList(cities);
    }

    public static final Creator<Province> CREATOR = new Creator<Province>() {
        @Override
        public Province createFromParcel(Parcel source) {
            return new Province(source);
        }

        @Override
        public Province[] newArray(int size) {
            return new Province[size];
        }
    };


}
