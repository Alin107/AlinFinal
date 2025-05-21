package com.example.alinfinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button btnLogin, btnFP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in2);

        // ربط عناصر الواجهة
        emailEditText = findViewById(R.id.etEmail);
        passwordEditText = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnFP = findViewById(R.id.btnFP);

        // زر تسجيل الدخول
        btnLogin.setOnClickListener(v -> {
            readAndValidateInputs();


        });

        // زر "نسيت كلمة المرور"
        btnFP.setOnClickListener(v -> {
            Intent intent = new Intent(SignInActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

    }

    /**
     * قراءة القيم من حقول الإدخال والتحقق من صحتها
     * @return true إذا كانت القيم صحيحة، false إذا كانت خاطئة
     */
    private void readAndValidateInputs() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        boolean isValid = true;

        // التحقق من البريد الإلكتروني
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Enter a valid email address");
            isValid = false;
        }

        // التحقق من كلمة المرور
        if (password.isEmpty() || password.length() < 6) {
            passwordEditText.setError("Password must be at least 6 characters");
            isValid = false;
        }

FirebaseAuth mAuth = FirebaseAuth.getInstance();


        if (isValid) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // تسجيل الدخول ناجح
                                Toast.makeText(SignInActivity.this, "تم تسجيل الدخول بنجاح.", Toast.LENGTH_SHORT).show();

                                // الانتقال إلى الشاشة التالية
                                Intent intent = new Intent(SignInActivity.this, selectActivity.class);
                                startActivity(intent);
                                finish(); // إنهاء النشاط الحالي حتى لا يرجع المستخدم إليه بالزر "رجوع"
                            } else {
                                // فشل في تسجيل الدخول
                                Toast.makeText(SignInActivity.this, "فشل في تسجيل الدخول. تحقق من البريد وكلمة المرور.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

    }
       }


