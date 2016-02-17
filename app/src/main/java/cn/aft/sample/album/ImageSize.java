package cn.aft.sample.album;

public class ImageSize {

	private int displayWidth;
	private int displayHeight;

	public ImageSize(int displayWidth, int displayHeight) {
		super();
		this.displayWidth = displayWidth;
		this.displayHeight = displayHeight;
	}

	public int getDisplayWidth() {
		return displayWidth;
	}

	public int getDisplayHeight() {
		return displayHeight;
	}

	@Override
	public String toString() {
		return "ImageSize [displayWidth=" + displayWidth + ", displayHeight=" + displayHeight + "]";
	}

}
