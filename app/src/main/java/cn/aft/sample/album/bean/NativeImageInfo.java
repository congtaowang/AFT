package cn.aft.sample.album.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class NativeImageInfo implements Parcelable {

	public String url;
	public int orientation;
	public int size;// bytes
	public String desc;

	public NativeImageInfo() {
	}

	public NativeImageInfo(Parcel source) {
		url = source.readString();
		orientation = source.readInt();
		size = source.readInt();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(url);
		dest.writeInt(orientation);
		dest.writeInt(size);
	}

	public static final Creator<NativeImageInfo> CREATOR = new Creator<NativeImageInfo>() {

		@Override
		public NativeImageInfo createFromParcel(Parcel source) {
			return new NativeImageInfo(source);
		}

		@Override
		public NativeImageInfo[] newArray(int size) {
			return new NativeImageInfo[size];
		}
	};

	@Override
	public String toString() {
		return "NativeImageInfo [url=" + url + ", orientation=" + orientation + ", size=" + size + ", desc=" + desc
				+ "]";
	}

}
