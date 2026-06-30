package app.example.projekkota;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NilaiActivity extends AppCompatActivity {

    TextView tvNilai, tvKeterangan;
    Button btnKembaliMenu, btnUlangi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai);

        tvNilai = findViewById(R.id.tvNilai);
        tvKeterangan = findViewById(R.id.tvKeterangan);
        btnKembaliMenu = findViewById(R.id.btnKembaliMenu);
        btnUlangi = findViewById(R.id.btnUlangi);

        int skor = getIntent().getIntExtra("SKOR", 0);
        int total = getIntent().getIntExtra("JUMLAH_SOAL", 0);

        tvNilai.setText("Skor Anda: " + skor + " dari " + total);

        if (skor == total) {
            tvKeterangan.setText("Sempurna! Kamu menjawab semua soal dengan benar 🎉");
        } else if (skor >= total * 0.7) {
            tvKeterangan.setText("Bagus! Kamu lulus kuis 👍");
        } else {
            tvKeterangan.setText("Coba lagi ya, semangat belajar 💪");
        }

        btnKembaliMenu.setOnClickListener(v -> {
            Intent i = new Intent(NilaiActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        });

        btnUlangi.setOnClickListener(v -> {
            Intent i = new Intent(NilaiActivity.this, QuizActivity.class);
            startActivity(i);
            finish();
        });
    }
}
