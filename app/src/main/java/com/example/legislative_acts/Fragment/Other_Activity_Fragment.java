package com.example.legislative_acts.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.legislative_acts.Adapter.Other_Adapter;
import com.example.legislative_acts.R;

import java.util.ArrayList;
import java.util.List;

public class Other_Activity_Fragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Other> otherList;
    private Other_Adapter adapter;
    private LayoutAnimationController layoutAnimationController;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.other_app_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_other);
        layoutAnimationController = AnimationUtils.loadLayoutAnimation(getContext(),R.anim.layout_animation_fall_down);
        adapter = new Other_Adapter();
        otherList = new ArrayList<>();

        otherList.add(new Other(R.drawable.icon_app_1,"План счетов","Эта программа бухгалтерского учета и быстро получить информацию из некоторых...","Скачать ->",R.drawable.ic_googleplay,"https://play.google.com/store/apps/details?id=com.example.legislative_acts.Fragment"));
        otherList.add(new Other(R.drawable.icon_app_2,"НСБУ/БХМС/BXMS","В приложении пользователь имеет доступ ко всем Национальным Стандартам Бухгалтерского учета...","Скачать ->",R.drawable.ic_googleplay,"https://play.google.com/store/apps/details?id=com.example.legislative_acts.Fragment"));
        otherList.add(new Other(R.drawable.icon_app_4,"Бухгалтерские проводки","Эта программа предназначена для лучшего понимания концепций узбекских бухгалтерских проводок и...","Скачать ->",R.drawable.ic_googleplay,"https://play.google.com/store/apps/details?id=com.example.legislative_acts.Fragment"));
        otherList.add(new Other(R.drawable.icon_app_5,"Экзаменатор для Бухгалтера","Данное приложение поможет вам закрепить и проверить ваши знания по бухгалтерии....","Скачать ->",R.drawable.ic_googleplay,"https://play.google.com/store/apps/details?id=com.example.legislative_acts.Fragment"));

        adapter.setOtherList(otherList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        recyclerView.setLayoutAnimation(layoutAnimationController);

        return view;
    }
}
