package edu.gatech.seclass.jobcompare6300;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RankRecyclerAdapter extends RecyclerView.Adapter<RankRecyclerAdapter.ViewHolder>{

    private ArrayList<JobItem> jobItemList;

    @NonNull
    @Override
    public RankRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rank_item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankRecyclerAdapter.ViewHolder holder, int position) {
        JobItem job = jobItemList.get(position);
        holder.onBind(job, position+1);
        holder.view.setBackgroundColor(job.isSelected() ? Color.rgb(101, 171, 251) : Color.WHITE);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                job.setSelected(!job.isSelected());
                holder.view.setBackgroundColor(job.isSelected() ? Color.rgb(101, 171, 251) : Color.WHITE);
            }
        });
    }

    public void setRankList(ArrayList<JobItem> list){
        this.jobItemList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return jobItemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        TextView rank;
        TextView title;
        TextView company;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            rank = (TextView) itemView.findViewById(R.id.rank);
            title = (TextView) itemView.findViewById(R.id.title);
            company = (TextView) itemView.findViewById(R.id.company);
        }

        void onBind(JobItem item, Integer number){
//            rank.setText(item.getRank());
            rank.setText(number.toString());
            title.setText(item.getTitle());
            company.setText(item.getCompany());
        }
    }

}




