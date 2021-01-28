package com.example.legislative_acts.Data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Acts_table")
public class ActsData {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private int position;
    private String titleSection;
    private int positionSection;
    private String titleChapter;
    private int positionChapter;


    public ActsData(int id, String title, int position, String titleSection, int positionSection, String titleChapter, int positionChapter) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.titleSection = titleSection;
        this.positionSection = positionSection;
        this.titleChapter = titleChapter;
        this.positionChapter = positionChapter;
    }

    @Ignore
    public ActsData(String title, int position,String titleSubject, int positionSubject, String titleChapter, int positionChapter) {
        this.title = title;
        this.position = position;
        this.titleSection = titleSubject;
        this.positionSection = positionSubject;
        this.titleChapter = titleChapter;
        this.positionChapter = positionChapter;

    }

    @Ignore
    public ActsData(String title, int position, String titleSection, int positionSection) {
        this.title = title;
        this.position = position;
        this.titleSection = titleSection;
        this.positionSection = positionSection;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTitleSection() {
        return titleSection;
    }

    public void setTitleSection(String titleSection) {
        this.titleSection = titleSection;
    }

    public int getPositionSection() {
        return positionSection;
    }

    public void setPositionSection(int positionSection) {
        this.positionSection = positionSection;
    }

    public String getTitleChapter() {
        return titleChapter;
    }

    public void setTitleChapter(String titleChapter) {
        this.titleChapter = titleChapter;
    }

    public int getPositionChapter() {
        return positionChapter;
    }

    public void setPositionChapter(int positionChapter) {
        this.positionChapter = positionChapter;
    }
}
