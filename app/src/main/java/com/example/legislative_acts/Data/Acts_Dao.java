package com.example.legislative_acts.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Acts_Dao {

    @Insert
    void insert(ActsData actsData);

    @Delete
    void delete(ActsData actsData);

    @Query("SELECT * FROM Acts_table")
    LiveData<List<ActsData>> getAllActs();

    @Query("SELECT * FROM Acts_table WHERE title IS :title AND position IS :position AND titleSection IS :titleSection AND positionSection IS :positionSection AND titleChapter IS :titleChapter AND positionChapter IS :positionChapter")
    ActsData getActsByALLParameters(String title, int position, String titleSection, int positionSection, String titleChapter, int positionChapter);

    @Query("SELECT * FROM Acts_table WHERE title IS :title AND position IS :position AND titleSection IS :titleSection AND positionSection IS :positionSection")
    ActsData getActsByLessParameters(String title, int position, String titleSection, int positionSection);

    @Query("DELETE FROM Acts_table")
    void deleteAllActs();

}
