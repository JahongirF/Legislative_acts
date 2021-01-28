package com.example.legislative_acts.Data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ActsViewModal extends AndroidViewModel {

    private static ActsDataBase dataBase;
    private LiveData<List<ActsData>> listLiveData;

    public ActsViewModal(@NonNull Application application) {
        super(application);

        dataBase = ActsDataBase.getInstance(getApplication());
        listLiveData = dataBase.acts_dao().getAllActs();
    }

    public LiveData<List<ActsData>> getListLiveData() {
        return listLiveData;
    }

    public void insert(ActsData actsData) {
        new InsertToDB().execute(actsData);
    }

    private static class InsertToDB extends AsyncTask<ActsData, Void, Void> {

        @Override
        protected Void doInBackground(ActsData... actsData) {

            if (actsData.length > 0 && actsData != null)
            {
                dataBase.acts_dao().insert(actsData[0]);
            }
                return null;
        }
    }

    public void delete(ActsData actsData)
    {
        new DeleteFromDB().execute(actsData);
    }

    private static class DeleteFromDB extends AsyncTask<ActsData,Void,Void>
    {

        @Override
        protected Void doInBackground(ActsData... actsData) {

            if (actsData != null && actsData.length > 0)
            {
                dataBase.acts_dao().delete(actsData[0]);
            }

            return null;
        }
    }

    public ActsData getActByAllParameters(String title, int position, String titleSection, int positionSection, String titleChapter, int positionChapter){
        try {
            return new GetActByAllParameters(title,position,titleSection,positionSection,titleChapter,positionChapter).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class GetActByAllParameters extends AsyncTask<Void,Void,ActsData>
    {

        private String title;
        private int position;
        private String titleSection;
        private int positionSection;
        private String titleChapter;
        private int positionChapter;

        public GetActByAllParameters(String title, int position, String titleSection, int positionSection, String titleChapter, int positionChapter) {
            this.title = title;
            this.position = position;
            this.titleSection = titleSection;
            this.positionSection = positionSection;
            this.titleChapter = titleChapter;
            this.positionChapter = positionChapter;
        }

        @Override
        protected ActsData doInBackground(Void... voids) {
            return dataBase.acts_dao().getActsByALLParameters(title,position,titleSection,positionSection,titleChapter,positionChapter);
        }
    }

    public ActsData getActByLessParameters(String title, int position, String titleSection, int positionSection)
    {
        try {
            return new GetActByLessParameters(title,position,titleSection,positionSection).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static class GetActByLessParameters extends AsyncTask<Void,Void,ActsData>
    {
        private String title;
        private int position;
        private String titleSection;
        private int positionSection;

        public GetActByLessParameters(String title, int position, String titleSection, int positionSection) {
            this.title = title;
            this.position = position;
            this.titleSection = titleSection;
            this.positionSection = positionSection;
        }

        @Override
        protected ActsData doInBackground(Void... voids) {
            return dataBase.acts_dao().getActsByLessParameters(title,position,titleSection,positionSection);
        }
    }

    public void DeleteAllActs(){
        new DeleteAllActsFromDB().execute();
    }

    private static class DeleteAllActsFromDB extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {

            dataBase.acts_dao().deleteAllActs();

            return null;
        }
    }
}
