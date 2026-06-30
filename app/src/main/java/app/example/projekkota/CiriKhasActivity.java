package app.example.projekkota;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CiriKhasActivity extends AppCompatActivity {

    private ImageView ivGambarKota;
    private TextView tvNamaKota, tvMakanan, tvPakaian, tvSenjata, tvRumah,
            tvMusik, tvKesenian, tvBahasa, tvIkon;

    private Button btnNextKota, btnBackKota, btnPrevCiriKhas;
    private int posisi = 0;

    private final List<CiriKhas> daftarCiriKhas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cirikhaskota);

        // Inisialisasi view
        ivGambarKota = findViewById(R.id.ivGambarKota);
        tvNamaKota = findViewById(R.id.tvNamaKota);
        tvMakanan = findViewById(R.id.tvMakanan);
        tvPakaian = findViewById(R.id.tvPakaian);
        tvSenjata = findViewById(R.id.tvSenjata);
        tvRumah = findViewById(R.id.tvRumah);
        tvMusik = findViewById(R.id.tvMusik);
        tvKesenian = findViewById(R.id.tvKesenian);
        tvBahasa = findViewById(R.id.tvBahasa);
        tvIkon = findViewById(R.id.tvIkon);
        btnNextKota = findViewById(R.id.btnNextKota);
        btnBackKota = findViewById(R.id.btnBackKota);
        btnPrevCiriKhas = findViewById(R.id.btnPrevCiriKhas);

        isiDataCiriKhas();
        tampilkanCiriKhas(posisi);

        btnNextKota.setOnClickListener(v -> {
            if (posisi < daftarCiriKhas.size() - 1) {
                posisi++;
                tampilkanCiriKhas(posisi);
            }
        });

        btnPrevCiriKhas.setOnClickListener(v -> {
            if (posisi > 0) {
                posisi--;
                tampilkanCiriKhas(posisi);
            }
        });

        btnBackKota.setOnClickListener(v -> {
            startActivity(new Intent(CiriKhasActivity.this, MainActivity.class));
            finish();
        });
    }

    private void tampilkanCiriKhas(int index) {
        CiriKhas kota = daftarCiriKhas.get(index);
        tvNamaKota.setText(kota.nama);
        tvMakanan.setText("Makanan Khas: " + kota.makanan);
        tvPakaian.setText("Pakaian Adat: " + kota.pakaian);
        tvSenjata.setText("Senjata Tradisional: " + kota.senjata);
        tvRumah.setText("Rumah Adat: " + kota.rumah);
        tvMusik.setText("Alat Musik: " + kota.musik);
        tvKesenian.setText("Kesenian Daerah: " + kota.kesenian);
        tvBahasa.setText("Bahasa Daerah: " + kota.bahasa);
        tvIkon.setText("Ikon Kota: " + kota.ikon);
        ivGambarKota.setImageResource(kota.gambar);
    }

    private void isiDataCiriKhas() {
        daftarCiriKhas.add(new CiriKhas("Jakarta", "Kerak Telor", "Baju Sadariah", "Golok", "Rumah Kebaya", "Tanjidor", "Ondel-Ondel", "Betawi", "Monas", R.drawable.jakarta));
        daftarCiriKhas.add(new CiriKhas("Surabaya", "Rawon", "Baju Cak & Ning", "Clurit", "Limasan", "Gambang", "Ludruk", "Jawa Timur", "Tugu Pahlawan", R.drawable.surabaya));
        daftarCiriKhas.add(new CiriKhas("Bandung", "Batagor", "Kebaya Sunda", "Kujang", "Kasepuhan", "Angklung", "Wayang Golek", "Sunda", "Gedung Sate", R.drawable.bandung));
        daftarCiriKhas.add(new CiriKhas("Medan", "Bika Ambon", "Ulos", "Piso Gaja", "Rumah Bolon", "Gondang", "Tortor", "Batak", "Istana Maimun", R.drawable.medan));
        daftarCiriKhas.add(new CiriKhas("Semarang", "Lumpia", "Kebaya Jawa", "Keris", "Joglo", "Gambang", "Wayang", "Jawa", "Lawang Sewu", R.drawable.semarang));
        daftarCiriKhas.add(new CiriKhas("Makassar", "Coto", "Baju Bodo", "Badik", "Tongkonan", "Gendang", "Pakarena", "Bugis", "Pantai Losari", R.drawable.makasar));
        daftarCiriKhas.add(new CiriKhas("Denpasar", "Ayam Betutu", "Pakaian Bali", "Keris", "Candi Bentar", "Gamelan", "Kecak", "Bali", "Pura Jagatnatha", R.drawable.denpasar));
        daftarCiriKhas.add(new CiriKhas("Yogyakarta", "Gudeg", "Surjan", "Keris", "Joglo", "Gamelan", "Srimpi", "Jawa", "Keraton", R.drawable.yogyakarta));
        daftarCiriKhas.add(new CiriKhas("Padang", "Rendang", "Bundo Kanduang", "Karih", "Gadang", "Saluang", "Tari Piring", "Minang", "Pantai Air Manis", R.drawable.padang));
        daftarCiriKhas.add(new CiriKhas("Palembang", "Pempek", "Aesan Gede", "Tombak", "Limas", "Gendang", "Sriwijaya", "Palembang", "Ampera", R.drawable.palembang));
        daftarCiriKhas.add(new CiriKhas("Malang", "Bakso Malang", "Pakaian Jawa", "Celurit", "Limasan", "Gamelan", "Jaranan", "Jawa", "Gunung Bromo", R.drawable.malang));
        daftarCiriKhas.add(new CiriKhas("Balikpapan", "Kepiting", "Dayak", "Mandau", "Lamin", "Sape", "Giring-Giring", "Dayak", "Pantai Kemala", R.drawable.balikpapan));
        daftarCiriKhas.add(new CiriKhas("Manado", "Tinutuan", "Minahasa", "Sabel", "Walewangko", "Kolintang", "Maengket", "Manado", "Bukit Kasih", R.drawable.manado));
        daftarCiriKhas.add(new CiriKhas("Pontianak", "Pengkang", "Teluk Belanga", "Mandau", "Rumah Panjang", "Sape", "Monong", "Melayu", "Tugu Khatulistiwa", R.drawable.pontianak));
        daftarCiriKhas.add(new CiriKhas("Banjarmasin", "Soto Banjar", "Baamar Galung", "Mandau", "Banjar", "Panting", "Baksa Kembang", "Banjar", "Pasar Terapung", R.drawable.banjarmasin));
        daftarCiriKhas.add(new CiriKhas("Banda Aceh", "Kuah Pliek U", "Ulee Balang", "Rencong", "Rumoh Aceh", "Serune Kale", "Saman", "Aceh", "Masjid Raya", R.drawable.bandaaceh));
        daftarCiriKhas.add(new CiriKhas("Mataram", "Ayam Taliwang", "Sasak", "Keris Lombok", "Bale", "Gendang Beleq", "Peresean", "Sasak", "Senggigi", R.drawable.mataram));
        daftarCiriKhas.add(new CiriKhas("Jayapura", "Papeda", "Koteka", "Busur", "Honai", "Tifa", "Yospan", "Papua", "Danau Sentani", R.drawable.jayapura));
        daftarCiriKhas.add(new CiriKhas("Kupang", "Se'i Sapi", "Timor", "Sundu", "Lopo", "Sasando", "Likurai", "Dawan", "Pantai Lasiana", R.drawable.kupang));
        daftarCiriKhas.add(new CiriKhas("Ternate", "Ikan Bakar", "Manteren Lamo", "Parang", "Sasadu", "Tifa", "Cakalele", "Ternate", "Benteng Oranje", R.drawable.ternate));
    }

    // Inner Class
    public static class CiriKhas {
        String nama, makanan, pakaian, senjata, rumah, musik, kesenian, bahasa, ikon;
        int gambar;

        public CiriKhas(String nama, String makanan, String pakaian, String senjata, String rumah,
                        String musik, String kesenian, String bahasa, String ikon, int gambar) {
            this.nama = nama;
            this.makanan = makanan;
            this.pakaian = pakaian;
            this.senjata = senjata;
            this.rumah = rumah;
            this.musik = musik;
            this.kesenian = kesenian;
            this.bahasa = bahasa;
            this.ikon = ikon;
            this.gambar = gambar;
        }
    }
}
