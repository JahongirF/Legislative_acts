package com.example.legislative_acts.Fragment;

public class Other {

    private int imageView_other;
    private String textView_other_title;
    private String textView_other_subject;
    private String textView_other_download;
    private int imageView_download;
    private String url;

    public Other(int imageView_other, String textView_other_title, String textView_other_subject, String textView_other_download, int imageView_download, String url) {
        this.imageView_other = imageView_other;
        this.textView_other_title = textView_other_title;
        this.textView_other_subject = textView_other_subject;
        this.textView_other_download = textView_other_download;
        this.imageView_download = imageView_download;
        this.url = url;
    }

    public Other(int imageView_other, String textView_other_title, String textView_other_subject, String textView_other_download, int imageView_download) {
        this.imageView_other = imageView_other;
        this.textView_other_title = textView_other_title;
        this.textView_other_subject = textView_other_subject;
        this.textView_other_download = textView_other_download;
        this.imageView_download = imageView_download;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImageView_other() {
        return imageView_other;
    }

    public void setImageView_other(int imageView_other) {
        this.imageView_other = imageView_other;
    }

    public String getTextView_other_title() {
        return textView_other_title;
    }

    public void setTextView_other_title(String textView_other_title) {
        this.textView_other_title = textView_other_title;
    }

    public String getTextView_other_subject() {
        return textView_other_subject;
    }

    public void setTextView_other_subject(String textView_other_subject) {
        this.textView_other_subject = textView_other_subject;
    }

    public String getTextView_other_download() {
        return textView_other_download;
    }

    public void setTextView_other_download(String textView_other_download) {
        this.textView_other_download = textView_other_download;
    }

    public int getImageView_download() {
        return imageView_download;
    }

    public void setImageView_download(int imageView_download) {
        this.imageView_download = imageView_download;
    }
}
