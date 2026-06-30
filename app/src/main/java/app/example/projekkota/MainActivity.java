package app.example.projekkota;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Button btnMateri, btnSoal, btnCiriKhas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Inisialisasi tombol
        btnMateri = findViewById(R.id.btnMateri);
        btnSoal = findViewById(R.id.btnSoal);
        btnCiriKhas = findViewById(R.id.btnCiriKhas);

        // Aksi saat tombol diklik
        btnMateri.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MateriActivity.class);
            startActivity(intent);
        });

        btnSoal.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            startActivity(intent);
        });

        btnCiriKhas.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CiriKhasActivity.class);
            startActivity(intent);
        });

        Button btnInfo = findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

    }
}
