package com.example.alinfinal.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alinfinal.R;
import com.example.alinfinal.data.Job;
import com.example.alinfinal.data.Workplace;

import java.util.List;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.JobViewHolder> {

    private List<Workplace> workplaceList;

    public JobsAdapter(List<Job> workplaceList) {
        this.workplaceList = workplaceList;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_item, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        Workplace workplace = workplaceList.get(position);
        holder.textViewJobName.setText(workplace.getName());
        holder.textViewJobLocation.setText(workplace.getLocation());
    }

    @Override
    public int getItemCount() {
        return workplaceList.size();
    }

    static class JobViewHolder extends RecyclerView.ViewHolder {
        TextView textViewJobName, textViewJobLocation;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewJobName = itemView.findViewById(R.id.textView_title);
        //   textViewJobLocation = itemView.findViewById(R.id.textViewJobLocation);
        }
    }
}
