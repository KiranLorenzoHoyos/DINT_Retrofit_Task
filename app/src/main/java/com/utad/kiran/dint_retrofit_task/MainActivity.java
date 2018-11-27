package com.utad.kiran.dint_retrofit_task;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nickname_statistics;
    private Spinner spinner;
    private MyAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton buttonGo;
    private RetrofitViewModel retrofitViewModel;
    private String platformGame;
    private String epic_nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nickname_statistics = findViewById(R.id.nickname_statistics);
        spinner = findViewById(R.id.spinner);
        buttonGo = findViewById(R.id.buttonGo);
        changeData("","");
        onclick();
    }

    private void changeData(String platformGame,String epic_nickname){
        retrofitViewModel = ViewModelProviders.of(this).get(RetrofitViewModel.class);
        retrofitViewModel.statisticsData.observe(this, statisticsObjectData -> {
            if(statisticsObjectData!=null){
                Log.d("Service","Changes: "+statisticsObjectData);
                generateStatisticsList(statisticsObjectData);
            }
        });
        retrofitViewModel.getData(platformGame, epic_nickname);
    }

    private void generateStatisticsList(List<StatisticsRank> listStatistics) {
        recyclerView = findViewById(R.id.recycleview_statistics);
        adapter = new MyAdapter(listStatistics);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void onclick(){
        buttonGo.setOnClickListener(v -> {
            platformGame = spinner.getSelectedItem().toString();
            epic_nickname = nickname_statistics.getText().toString();
            retrofitViewModel.getData(platformGame, epic_nickname);

        });
    }
}

