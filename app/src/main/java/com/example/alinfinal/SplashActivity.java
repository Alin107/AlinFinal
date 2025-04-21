
    package com.example.alinfinal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

    public class SplashActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash); // اسم ملف XML تبعك

            // الانتقال التلقائي لواجهة التطبيق الرئيسية (مثلاً JobActivity)
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(SplashActivity.this, SplashActivity.class);
                startActivity(intent);
                finish(); // نغلق شاشة السبلاش
            }, 2000); // 2 ثانية
        }
    }


