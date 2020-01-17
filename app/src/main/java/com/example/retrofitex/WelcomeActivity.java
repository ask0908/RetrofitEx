package com.example.retrofitex;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    private TextView tvname, tvhobby;
    private Button btnlogout;
    // 쉐어드 헬퍼 클래스를 써서 username 및 hobby 같은 값을 채운다
    private PreferenceHelper preferenceHelper;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        preferenceHelper = new PreferenceHelper(this);

        tvhobby = (TextView) findViewById(R.id.tvhobby);
        tvname = (TextView) findViewById(R.id.tvname);
        btnlogout = (Button) findViewById(R.id.btn);

        tvname.setText("Welcome "+preferenceHelper.getName());
        tvhobby.setText("Your hobby is "+preferenceHelper.getHobby());

        // 로그아웃 버튼
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 사용자가 버튼을 누르면 putIsLogin()의 값을 false로 설정한다
                preferenceHelper.putIsLogin(false);

                // 그리고 메인 액티비티로 이동한다
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);

                // 이 두 플래그를 쓰면 뒤로가기를 눌러도 이전 화면으로 돌아가지지 않는다
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                // 뒤로가기 성공 시 액티비티를 죽인다
                WelcomeActivity.this.finish();
            }
        });
    }
}
