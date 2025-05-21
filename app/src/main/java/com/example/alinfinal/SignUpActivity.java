package com.example.alinfinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import androidx.annotation.NonNull;

/**
 * شاشة تسجيل حساب جديد في التطبيق.
 * يقوم المستخدم بإدخال بريد إلكتروني وكلمة مرور.
 * يتم التحقق من صحة المدخلات، ثم إنشاء حساب في Firebase Authentication.
 */
public class SignUpActivity extends AppCompatActivity {

    // تعريف المتغيرات لعناصر واجهة المستخدم
    private EditText emailEditText, passwordEditText;
    private Button btnSave;
    private FirebaseAuth mAuth; // كائن للتعامل مع Firebase Authentication

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // تفعيل عرض الواجهة بكامل الشاشة
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        // ضبط الحواف (Insets) لملاءمة الشاشات الحديثة
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ربط العناصر من واجهة XML
        emailEditText = findViewById(R.id.etEmail);         // حقل البريد الإلكتروني
        passwordEditText = findViewById(R.id.etPassword);   // حقل كلمة المرور
        btnSave = findViewById(R.id.btnSave);               // زر "إنشاء الحساب"

        // تهيئة FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        // عند الضغط على زر "حفظ"
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount(); // استدعاء الدالة التي تنشئ الحساب
            }
        });
    }

    /**
     * دالة لإنشاء حساب جديد بعد التحقق من البريد وكلمة المرور.
     */
    private void createAccount() {
        // قراءة المدخلات
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // علم للتحقق من صحة المدخلات
        boolean isValid = true;

        // التحقق من صحة البريد الإلكتروني
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("أدخل بريدًا إلكترونيًا صحيحًا");
            isValid = false;
        }

        // التحقق من قوة كلمة المرور
        if (password.isEmpty() || password.length() < 6) {
            passwordEditText.setError("كلمة المرور يجب أن تكون 6 حروف أو أكثر");
            isValid = false;
        }

        // إذا كانت المدخلات صحيحة
        if (isValid) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // الحساب تم إنشاؤه بنجاح
                                Toast.makeText(SignUpActivity.this, "تم إنشاء الحساب بنجاح", Toast.LENGTH_SHORT).show();

                                // الانتقال إلى شاشة اختيار الوظيفة أو الشاشة الرئيسية
                                Intent intent = new Intent(SignUpActivity.this, selectActivity.class);
                                startActivity(intent);
                                finish(); // إنهاء شاشة التسجيل
                            } else {
                                // فشل في إنشاء الحساب
                                Toast.makeText(SignUpActivity.this, "فشل في إنشاء الحساب: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }
}
