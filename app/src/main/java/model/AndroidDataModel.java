package model;

public class AndroidDataModel {
    private String author, title, link, description, date;
    private int image;

    public AndroidDataModel(String author, String title, String link, String description, int image, String date) {
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

    public int getImage() {
        return image;
    }

    public String getDate() {
        return date;
    }
}
