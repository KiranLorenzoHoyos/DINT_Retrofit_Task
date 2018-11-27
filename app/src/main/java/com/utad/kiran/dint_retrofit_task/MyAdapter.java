package com.utad.kiran.dint_retrofit_task;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.StatisticsViewHolder> {
    private List<StatisticsRank> dataObject;

    public MyAdapter(List<StatisticsRank> dataObject) {
        this.dataObject = dataObject;
    }

    @Override
    public StatisticsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.activity_retrofit, viewGroup, false);
        return new StatisticsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatisticsViewHolder statisticsViewHolder, int i) {
        final StatisticsRank item = dataObject.get(i);
        statisticsViewHolder.txtStatisticsTitle.setText(item.getLabel());
        statisticsViewHolder.txtStatisticsValue.setText(item.getDisplayValue());
        statisticsViewHolder.txtStatisticsRank.setText(item.getRank());
    }

    @Override
    public int getItemCount() {
        return dataObject.size();
    }

    public class StatisticsViewHolder extends RecyclerView.ViewHolder {
        private TextView txtStatisticsTitle, txtStatisticsValue, txtStatisticsRank;

        public StatisticsViewHolder(View itemView) {
            super(itemView);
            txtStatisticsTitle = itemView.findViewById(R.id.title);
            txtStatisticsValue = itemView.findViewById(R.id.value);
            txtStatisticsRank = itemView.findViewById(R.id.rank);
        }
    }
}
