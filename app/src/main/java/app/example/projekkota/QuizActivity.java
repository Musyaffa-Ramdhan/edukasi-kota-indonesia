package app.example.projekkota;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView tvNoSoal, tvPertanyaan, tvHasil;
    private RadioGroup rgPilihan;
    private RadioButton rbA, rbB, rbC, rbD;
    private Button btnJawab, btnPrevSoal, btnBackSoal;

    private int indexSoal = 0;
    private int skor = 0;

    private final List<Soal> daftarSoal = new ArrayList<>();
    private final List<String> jawabanUser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soal);

        tvNoSoal = findViewById(R.id.tvNoSoal);
        tvPertanyaan = findViewById(R.id.tvPertanyaan);
        tvHasil = findViewById(R.id.tvHasil);
        rgPilihan = findViewById(R.id.rgPilihan);
        rbA = findViewById(R.id.rbPilihanA);
        rbB = findViewById(R.id.rbPilihanB);
        rbC = findViewById(R.id.rbPilihanC);
        rbD = findViewById(R.id.rbPilihanD);
        btnJawab = findViewById(R.id.btnJawab);
        btnPrevSoal = findViewById(R.id.btnPrevSoal);
        btnBackSoal = findViewById(R.id.btnBackSoal);

        isiDaftarSoal();
        for (int i = 0; i < daftarSoal.size(); i++) jawabanUser.add(null);
        tampilkanSoal(indexSoal);

        btnJawab.setOnClickListener(v -> {
            int selectedId = rgPilihan.getCheckedRadioButtonId();
            if (selectedId == -1) {
                tvHasil.setText("Silakan pilih jawaban terlebih dahulu.");
                return;
            }

            RadioButton rbDipilih = findViewById(selectedId);
            String jawabanDipilih = rbDipilih.getText().toString();
            Soal soalSaatIni = daftarSoal.get(indexSoal);

            jawabanUser.set(indexSoal, jawabanDipilih);

            if (jawabanDipilih.equals(soalSaatIni.jawabanBenar)) {
                tvHasil.setText("Jawaban benar!");
            } else {
                tvHasil.setText("Jawaban salah! Jawaban yang benar: " + soalSaatIni.jawabanBenar);
            }

            if (indexSoal == daftarSoal.size() - 1) {
                hitungSkorDanSelesai();
            } else {
                indexSoal++;
                tampilkanSoal(indexSoal);
            }
        });

        btnPrevSoal.setOnClickListener(v -> {
            if (indexSoal > 0) {
                indexSoal--;
                tampilkanSoal(indexSoal);
            } else {
                tvHasil.setText("Ini adalah soal pertama.");
            }
        });

        btnBackSoal.setOnClickListener(v -> {
            Intent intent = new Intent(QuizActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void tampilkanSoal(int index) {
        Soal s = daftarSoal.get(index);
        tvNoSoal.setText("Soal " + (index + 1));
        tvPertanyaan.setText(s.pertanyaan);
        rbA.setText(s.pilihan[0]);
        rbB.setText(s.pilihan[1]);
        rbC.setText(s.pilihan[2]);
        rbD.setText(s.pilihan[3]);
        rgPilihan.clearCheck();
        tvHasil.setText("");

        // Tampilkan kembali pilihan yang pernah dipilih
        String jawabanTersimpan = jawabanUser.get(index);
        if (jawabanTersimpan != null) {
            if (jawabanTersimpan.equals(rbA.getText().toString())) rbA.setChecked(true);
            else if (jawabanTersimpan.equals(rbB.getText().toString())) rbB.setChecked(true);
            else if (jawabanTersimpan.equals(rbC.getText().toString())) rbC.setChecked(true);
            else if (jawabanTersimpan.equals(rbD.getText().toString())) rbD.setChecked(true);
        }
    }

    private void hitungSkorDanSelesai() {
        skor = 0;
        for (int i = 0; i < daftarSoal.size(); i++) {
            if (jawabanUser.get(i) != null && jawabanUser.get(i).equals(daftarSoal.get(i).jawabanBenar)) {
                skor++;
            }
        }
        Intent intent = new Intent(QuizActivity.this, NilaiActivity.class);
        intent.putExtra("SKOR", skor);
        intent.putExtra("JUMLAH_SOAL", daftarSoal.size());
        startActivity(intent);
        finish();
    }

    private void isiDaftarSoal() {
        daftarSoal.add(new Soal("Ibukota Indonesia adalah?", new String[]{"Jakarta", "Bandung", "Surabaya", "Medan"}, "Jakarta"));
        daftarSoal.add(new Soal("Monumen terkenal di Jakarta adalah?", new String[]{"Lawang Sewu", "Monas", "Tugu Pahlawan", "Gedung Sate"}, "Monas"));
        daftarSoal.add(new Soal("Makanan khas Padang adalah?", new String[]{"Pempek", "Rendang", "Gudeg", "Rawon"}, "Rendang"));
        daftarSoal.add(new Soal("Senjata tradisional Betawi adalah?", new String[]{"Clurit", "Golok", "Kujang", "Mandau"}, "Golok"));
        daftarSoal.add(new Soal("Kota dengan ikon Gedung Sate?", new String[]{"Bandung", "Jakarta", "Semarang", "Palembang"}, "Bandung"));
        daftarSoal.add(new Soal("Keraton Yogyakarta adalah ikon dari?", new String[]{"Yogyakarta", "Surabaya", "Denpasar", "Medan"}, "Yogyakarta"));
        daftarSoal.add(new Soal("Tari Kecak berasal dari?", new String[]{"Jawa", "Sumatera", "Bali", "Sulawesi"}, "Bali"));
        daftarSoal.add(new Soal("Rumah Gadang berasal dari?", new String[]{"Minangkabau", "Betawi", "Bugis", "Aceh"}, "Minangkabau"));
        daftarSoal.add(new Soal("Bahasa daerah Makassar adalah?", new String[]{"Sunda", "Batak", "Bugis", "Bali"}, "Bugis"));
        daftarSoal.add(new Soal("Alat musik Angklung berasal dari?", new String[]{"Bali", "Sunda", "Batak", "Jawa"}, "Sunda"));
        daftarSoal.add(new Soal("Pakaian Aesan Gede berasal dari?", new String[]{"Palembang", "Lampung", "Aceh", "Papua"}, "Palembang"));
        daftarSoal.add(new Soal("Makanan khas Surabaya?", new String[]{"Gudeg", "Pempek", "Rawon", "Rendang"}, "Rawon"));
        daftarSoal.add(new Soal("Alat musik Tifa berasal dari?", new String[]{"Papua", "NTT", "Jawa", "Minang"}, "Papua"));
        daftarSoal.add(new Soal("Rumah adat Tongkonan berasal dari?", new String[]{"Toraja", "Sunda", "Betawi", "Jawa"}, "Toraja"));
        daftarSoal.add(new Soal("Bahasa daerah dari Padang?", new String[]{"Aceh", "Bugis", "Minang", "Jawa"}, "Minang"));
        daftarSoal.add(new Soal("Pakaian adat Bundo Kanduang berasal dari?", new String[]{"Aceh", "Padang", "Palembang", "Bali"}, "Padang"));
        daftarSoal.add(new Soal("Pantai Losari berada di kota?", new String[]{"Makassar", "Manado", "Lombok", "Kupang"}, "Makassar"));
        daftarSoal.add(new Soal("Rumah adat dari Bali adalah?", new String[]{"Tongkonan", "Joglo", "Candi Bentar", "Limas"}, "Candi Bentar"));
        daftarSoal.add(new Soal("Jembatan Ampera terletak di kota?", new String[]{"Palembang", "Pekanbaru", "Pontianak", "Medan"}, "Palembang"));
        daftarSoal.add(new Soal("Tugu Khatulistiwa berada di?", new String[]{"Pontianak", "Balikpapan", "Jayapura", "Bandung"}, "Pontianak"));
        daftarSoal.add(new Soal("Tari Saman berasal dari daerah?", new String[]{"Aceh", "Sumut", "Jawa", "Bali"}, "Aceh"));
        daftarSoal.add(new Soal("Kota terkenal dengan Ayam Betutu?", new String[]{"Denpasar", "Yogyakarta", "Manado", "Padang"}, "Denpasar"));
        daftarSoal.add(new Soal("Pakaian Adat Sasak berasal dari?", new String[]{"Lombok", "Papua", "Sulawesi", "Maluku"}, "Lombok"));
        daftarSoal.add(new Soal("Sasando adalah alat musik dari?", new String[]{"NTT", "Papua", "Sumatera", "Sulawesi"}, "NTT"));
        daftarSoal.add(new Soal("Danau Sentani terletak di?", new String[]{"Jayapura", "Manado", "Kupang", "Ambon"}, "Jayapura"));
        daftarSoal.add(new Soal("Benteng Oranje ada di kota?", new String[]{"Ternate", "Ambon", "Jayapura", "Kupang"}, "Ternate"));
        daftarSoal.add(new Soal("Tari Maengket berasal dari?", new String[]{"Manado", "Palembang", "Makassar", "Lombok"}, "Manado"));
        daftarSoal.add(new Soal("Bahasa Dawan digunakan di daerah?", new String[]{"NTT", "Papua", "Sumatera", "Jawa"}, "NTT"));
        daftarSoal.add(new Soal("Kota terkenal dengan Pempek?", new String[]{"Palembang", "Medan", "Padang", "Jakarta"}, "Palembang"));
        daftarSoal.add(new Soal("Gunung Bromo ada di dekat kota?", new String[]{"Malang", "Surabaya", "Solo", "Bandung"}, "Malang"));
    }

    public static class Soal {
        String pertanyaan;
        String[] pilihan;
        String jawabanBenar;

        public Soal(String pertanyaan, String[] pilihan, String jawabanBenar) {
            this.pertanyaan = pertanyaan;
            this.pilihan = pilihan;
            this.jawabanBenar = jawabanBenar;
        }
    }
}




