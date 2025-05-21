package com.example.alinfinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.alinfinal.data.Workplace;
import com.example.alinfinal.data.WorkplaceRepository;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddWorkpasActivity extends AppCompatActivity {

    private EditText editTextNamePlace, editTextLocationPlace, editTextDescriptionPlace;

    // مستودع اماكن العمل (مؤقت حاليا داخل الاكتيفيتي، لاحقا بنعمله بشكل أفضل)
    public static WorkplaceRepository workplaceRepository = new WorkplaceRepository();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);

/*
        ViewCompat.setOnApplyWindowInsetsListener(this.<View>findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
 تعريف العناصر
*/

        editTextNamePlace = findViewById(R.id.editText_namePlace);
        editTextLocationPlace = findViewById(R.id.editText_locationPlace);
        editTextDescriptionPlace = findViewById(R.id.editText_descriptionPlace);
        Button buttonSavePlace = findViewById(R.id.button_savePlace);

        buttonSavePlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
// Save the workplace object to Firebase Realtime Database under the "workplaces" node
        // using the generated workplaceId
// Get a reference to the "workplaces" node in Firebase Realtime Database
DatabaseReference workplacesRef = FirebaseDatabase.getInstance().getReference("workplaces");
// Retrieve the key for a new workplace
String workplaceId = workplacesRef.push().getKey();
workplace.setId(workplaceId);

        workplacesRef.child("workplaces").child(workplaceId).setValue(workplace)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Data saved successfully!
                        Toast.makeText(AddWorkpasActivity.this, "Workplace added successfully to Firebase!", Toast.LENGTH_SHORT).show();

                        // Optional: Clear fields
                        editTextNamePlace.setText("");
                        editTextLocationPlace.setText("");
                        editTextDescriptionPlace.setText("");

                        // Optional: Navigate to another activity (e.g., MainActivity)
                        // Intent intent = new Intent(AddWorkpasActivity.this, MainActivity.class);
                        // startActivity(intent);
                        // finish(); // Close this activity
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Failed to save data
                        Toast.makeText(AddWorkpasActivity.this, "Failed to add workplace: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        // Log the error for debugging
                        // Log.e("FirebaseError", "Error saving workplace", e);
                    }
                });

//        // إضافة المكان إلى المستودع
//        workplaceRepository.addWorkplace(workplace);
//
//        // رسالة نجاح
//        Toast.makeText(this, "Workplace added successfully!", Toast.LENGTH_SHORT).show();
//
//        // انتقال لشاشة ثانية (بدك تحددلي وين تروح بالضبط؟ هون حطيت مثال بس)
//        Intent intent = new Intent(AddWorkpasActivity.this, MainActivity.class);
//        startActivity(intent);
//        finish(); // نغلق شاشة الإضافة
    }
}
