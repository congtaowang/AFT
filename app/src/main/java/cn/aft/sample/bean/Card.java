package cn.aft.sample.bean;

/**
 * 16/2/18 by congtaowang.
 * Version 1.0
 */
public class Card {

    private String imgUrl;
    private String title;
    private String content;

    public Card() {
    }

    public Card(String imgUrl, String title, String content) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
