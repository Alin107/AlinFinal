package com.example.alinfinal; // استبدل باسم الحزمة الخاص بك

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class selectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select); // تأكد من أن XML هذه هي التي تستخدمها

        // تعريف الأزرار
        Button workerButton = findViewById(R.id.workerButton);
        Button placeButton = findViewById(R.id.placeButton);

        // عند الضغط على زر Worker
        workerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // الانتقال إلى شاشة تفاصيل العامل
                Intent intent = new Intent(selectActivity.this, addworker_Activity.class);
                startActivity(intent);
            }
        });

        // عند الضغط على زر Place
        placeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // الانتقال إلى شاشة إضافة مكان العمل
                Intent intent = new Intent(selectActivity.this, AddWorkpasActivity.class);
                startActivity(intent);
            }
        });
    }
}
