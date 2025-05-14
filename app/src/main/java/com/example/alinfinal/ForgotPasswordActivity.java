package com.example.alinfinal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;




public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private Button buttonResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // ربط عناصر الواجهة
        editTextEmail = findViewById(R.id.editText_email);
        buttonResetPassword = findViewById(R.id.button_resetPassword);

        // عند الضغط على زر Reset Password
        buttonResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(ForgotPasswordActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                } else {
                    // هون ممكن تبعت الإيميل لسيرفر أو تعمل أي لوجيك
                    Toast.makeText(ForgotPasswordActivity.this, "Reset link sent to " + email, Toast.LENGTH_SHORT).show();
                    // هون كمان ممكن ترجع للمستخدم على شاشة تسجيل الدخول مثلا
                }
            }
        });

        @SuppressLint("WrongViewCast") Button BackToLogin = findViewById(R.id.textView_backToLogin);
        BackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Intent intent = new Intent(ForgotPasswordActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });


        Intent intent = new Intent(ForgotPasswordActivity.this, selectActivity.class);
        startActivity(intent);
        finish(); // نغلق شاشة الإضافة
    }
}
