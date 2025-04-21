package com.example.alinfinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

/**
 * شاشة تسجيل الدخول في التطبيق.
 * تحتوي على:
 * - حقل إدخال الإيميل
 * - حقل إدخال كلمة المرور
 * - زر تسجيل الدخول (Login)
 * - زر نسيان كلمة المرور (Forget Password)
 */
public class SignInActivity extends AppCompatActivity {

    // تعريف المتغيرات لعناصر الواجهة
    private Button loginButton;
    private Button forgetPasswordButton;
    private EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // تفعيل الوضع Edge to Edge (الشاشة تمتد للحواف)
        EdgeToEdge.enable(this);

        // ربط الواجهة بهذا الكلاس (activity_sign_in2.xml)
        setContentView(R.layout.activity_sign_in2);

        // ربط العناصر من الواجهة باستخدام ID
        loginButton = findViewById(R.id.btnLogin); // زر تسجيل الدخول
        forgetPasswordButton = findViewById(R.id.etFP); // زر نسيان كلمة المرور

        emailEditText = findViewById(R.id.etEmail); // حقل إدخال الإيميل (تأكد من وجوده في XML)
        passwordEditText = findViewById(R.id.etPassword); // حقل إدخال كلمة المرور

        // عند الضغط على زر "Login"، ينتقل إلى الشاشة الرئيسية (selectActivity)
        loginButton.setOnClickListener(v -> {
            // إنشاء نية (Intent) للانتقال إلى selectActivity
            Intent intent = new Intent(SignInActivity.this, selectActivity.class);
            startActivity(intent); // تشغيل النشاط الجديد
        });

        // عند الضغط على زر "Forget Password"، ينتقل إلى شاشة استعادة كلمة المرور
        forgetPasswordButton.setOnClickListener(v -> {
            // إنشاء نية للانتقال إلى ForgotPasswordActivity
            Intent intent = new Intent(SignInActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });
    }
}
