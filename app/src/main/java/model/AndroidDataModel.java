package model;

import android.content.res.TypedArray;

public class AndroidDataModel {
    private String author, title, link, description, date;
    private TypedArray image;

    public AndroidDataModel(String author, String title, String link, String description, TypedArray image, String date) {
        this.author = author;
        this.title = title;
        this.link = link;
        this.description = description;
        this.image = image;
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public TypedArray getImage() {
        return image;
    }

    public String getDate() {
        return date;
    }
}
