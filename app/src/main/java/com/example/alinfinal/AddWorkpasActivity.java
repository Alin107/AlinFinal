package com.example.alinfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.alinfinal.data.Workplace;
import com.example.alinfinal.data.WorkplaceRepository;

public class AddWorkpasActivity extends AppCompatActivity {

    private EditText editTextNamePlace, editTextLocationPlace, editTextDescriptionPlace;
    private Button buttonSavePlace;

    // مستودع اماكن العمل (مؤقت حاليا داخل الاكتيفيتي، لاحقا بنعمله بشكل أفضل)
    public static WorkplaceRepository workplaceRepository = new WorkplaceRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // تعريف العناصر
        editTextNamePlace = findViewById(R.id.editText_namePlace);
        editTextLocationPlace = findViewById(R.id.editText_locationPlace);
        editTextDescriptionPlace = findViewById(R.id.editText_descriptionPlace);
        buttonSavePlace = findViewById(R.id.button_savePlace);

        buttonSavePlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveWorkplace();
            }
        });
    }

    private void saveWorkplace() {
        String name = editTextNamePlace.getText().toString().trim();
        String location = editTextLocationPlace.getText().toString().trim();
        String description = editTextDescriptionPlace.getText().toString().trim();

        if (name.isEmpty() || location.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // إنشاء كائن مكان عمل جديد
        Workplace workplace = new Workplace(
                String.valueOf(System.currentTimeMillis()), // ID مؤقت
                name,
                location,
                description
        );

        // إضافة المكان إلى المستودع
        workplaceRepository.addWorkplace(workplace);

        // رسالة نجاح
        Toast.makeText(this, "Workplace added successfully!", Toast.LENGTH_SHORT).show();

        // انتقال لشاشة ثانية (بدك تحددلي وين تروح بالضبط؟ هون حطيت مثال بس)
        Intent intent = new Intent(AddWorkpasActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // نغلق شاشة الإضافة
    }
}
