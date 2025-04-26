package com.example.alinfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.alinfinal.data.Worker;
import com.example.alinfinal.data.WorkerRepository;

public class addworker_Activity extends AppCompatActivity {

    private EditText etId, etName, etAge, etLocation;
    private Button btnSaveWorker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addworker); // XML تبع الشاشة

        // ربط العناصر
        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etLocation = findViewById(R.id.etLocation);
        btnSaveWorker = findViewById(R.id.btnSaveWorker);

        // لما يكبس على زر حفظ
        btnSaveWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString().trim();
                String name = etName.getText().toString().trim();
                int age = Integer.parseInt(etAge.getText().toString().trim());
                String location = etLocation.getText().toString().trim();

                // انشاء العامل
                Worker worker = new Worker(id, name, age, location);

                // إضافة العامل للمستودع
                WorkerRepository.addWorker(worker);

                finish(); // نسكر الشاشة ونرجع للوراء
            }
        });
    }
}
