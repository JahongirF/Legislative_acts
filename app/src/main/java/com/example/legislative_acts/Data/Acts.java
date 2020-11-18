package com.example.legislative_acts.Data;

import java.util.List;

public class Acts {

    private int image;
    private String title;
    private boolean expended;
    private List<Acts_Subtitle> acts_subtitles;
    private int arrow_image;

    public Acts(int image, String title) {
        this.image = image;
        this.title = title;
        this.expended = false;

    }

    public Acts(int image, String title, List<Acts_Subtitle> acts_subtitles, int arrow_image) {
        this.image = image;
        this.title = title;
        this.expended = false;
        this.acts_subtitles = acts_subtitles;
        this.arrow_image = arrow_image;
    }

    public Acts(int image, String title, List<Acts_Subtitle> acts_subtitles) {
        this.image = image;
        this.title = title;
        this.expended = false;
        this.acts_subtitles = acts_subtitles;
    }

    public int getArrow_image() {
        return arrow_image;
    }

    public void setArrow_image(int arrow_image) {
        this.arrow_image = arrow_image;
    }

    public List<Acts_Subtitle> getActs_subtitles() {
        return acts_subtitles;
    }

    public void setActs_subtitles(List<Acts_Subtitle> acts_subtitles) {
        this.acts_subtitles = acts_subtitles;
    }

    public boolean isExpended() {
        return expended;
    }

    public void setExpended(boolean expended) {
        this.expended = expended;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
