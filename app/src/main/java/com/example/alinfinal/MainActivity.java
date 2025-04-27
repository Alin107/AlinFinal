package com.example.alinfinal;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.alinfinal.adapter.JobsAdapter;
import com.example.alinfinal.data.Job;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private JobsAdapter jobsAdapter;
    private List<Job> jobList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView_jobs);

        // إعداد الـ RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // إعداد البيانات
        jobList = new ArrayList<>();
        jobList.add(new Job("Software Engineer", "New York"));
        jobList.add(new Job("Graphic Designer", "California"));
        jobList.add(new Job("Project Manager", "Texas"));

        // إعداد الـ Adapter
        jobsAdapter = new JobsAdapter(jobList);
        recyclerView.setAdapter(jobsAdapter);
    }
}
