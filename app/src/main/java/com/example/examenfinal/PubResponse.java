package com.example.examenfinal;

public class PubResponse {

    private  String title;
    private  String date_published;
    private  String section;
    private  String doi;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    @Override
    public String toString() {
        return "PubResponse{" +
                "title='" + title + '\'' +
                ", date_published='" + date_published + '\'' +
                ", section='" + section + '\'' +
                ", doi='" + doi + '\'' +
                '}';
    }
}
