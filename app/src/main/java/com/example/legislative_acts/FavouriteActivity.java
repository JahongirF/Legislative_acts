package com.example.legislative_acts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.example.legislative_acts.Adapter.Favourite_Adapter;
import com.example.legislative_acts.Data.ActsData;
import com.example.legislative_acts.Data.ActsViewModal;

import java.util.List;

public class FavouriteActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ActsViewModal viewModal;
    private Favourite_Adapter adapter;
    private LayoutAnimationController layoutAnimationController;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        recyclerView = findViewById(R.id.recyclerView_favourite);
        viewModal = ViewModelProviders.of(this).get(ActsViewModal.class);
        layoutAnimationController = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_fall_down);
        adapter = new Favourite_Adapter();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final LiveData<List<ActsData>> getBXMS = viewModal.getListLiveData();
        getBXMS.observe(this, new Observer<List<ActsData>>() {
            @Override
            public void onChanged(final List<ActsData> saveDates) {
                adapter.setGetBXMS(saveDates);

                adapter.setOnLongClickListener(new Favourite_Adapter.OnLongClickListener() {
                    @Override
                    public void OnLongClick(int position, ActsData saveDate) {
                        viewModal.delete(saveDate);
                    }
                });

                adapter.setOnClickBXMSListener(new Favourite_Adapter.OnClickBXMSListener() {
                    @Override
                    public void OnClickListener(int position, ActsData actsData) {
                        Intent intent = new Intent(FavouriteActivity.this,Detail_Activity.class);
                        intent.putExtra("title", actsData.getTitle());
                        intent.putExtra("position",actsData.getPosition());
                        intent.putExtra("titleSubject",actsData.getTitleSection());
                        intent.putExtra("positionSubject",actsData.getPositionSection());
                        intent.putExtra("titleChapter", actsData.getTitleChapter());
                        intent.putExtra("positionChapter", actsData.getPositionChapter());
//                        Toast.makeText(FavouriteActivity.this, ""+actsData.getTitleSection().length(), Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                });

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                recyclerView.setLayoutAnimation(layoutAnimationController);
            }
        });
    }
}