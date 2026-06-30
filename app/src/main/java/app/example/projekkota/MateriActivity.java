package app.example.projekkota;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MateriActivity extends AppCompatActivity {

    private TextView tvJudul, tvDeskripsi;
    private ImageView ivKota;
    private Button btnNext, btnPrev, btnKembali;

    private List<Kota> daftarKota = new ArrayList<>();
    private int posisi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi);

        // Inisialisasi komponen
        tvJudul = findViewById(R.id.tvJudulKota);
        tvDeskripsi = findViewById(R.id.tvMateri);
        ivKota = findViewById(R.id.imgKota);
        btnNext = findViewById(R.id.btnKotaNext);
        btnPrev = findViewById(R.id.btnKotaPrev);
        btnKembali = findViewById(R.id.btnKembaliUtama);

        // Daftar 20 Kota (potongan awal - lengkap akan saya upload di langkah berikutnya)
        // Isi daftar kota
        daftarKota.add(new Kota("Jakarta",
                "Jakarta adalah ibu kota Negara Kesatuan Republik Indonesia yang terletak di pesisir barat laut Pulau Jawa. Kota ini menjadi pusat pemerintahan nasional sekaligus pusat ekonomi terbesar di tanah air. Gedung-gedung pencakar langit, pusat bisnis internasional, serta keberadaan lembaga-lembaga negara menunjukkan pentingnya posisi Jakarta sebagai jantung kehidupan Indonesia.\n\n" +
                        "Di sisi lain, Jakarta juga menyimpan warisan sejarah yang tak ternilai. Kawasan Kota Tua menjadi saksi bisu perjalanan masa kolonial Belanda, lengkap dengan bangunan bergaya Eropa klasik. Tak hanya itu, Monumen Nasional (Monas) yang menjulang tinggi di pusat kota menjadi simbol perjuangan rakyat Indonesia dalam merebut kemerdekaan.\n\n" +
                        "Meskipun sering dihadapkan pada persoalan kemacetan dan banjir, Jakarta terus berbenah. Proyek transportasi massal seperti MRT dan LRT mulai mengubah wajah kota menjadi lebih modern dan efisien. Selain itu, ruang-ruang publik seperti taman kota, ruang terbuka hijau, dan jalur sepeda semakin banyak dikembangkan untuk mendukung kualitas hidup warganya.\n\n" +
                        "Jakarta juga kaya akan budaya lokal, terutama dari suku Betawi yang merupakan penduduk asli. Tradisi lenong, tanjidor, dan makanan khas seperti kerak telor masih tetap lestari di tengah modernisasi. Kehidupan malam Jakarta pun penuh warna, mulai dari pertunjukan seni, pusat perbelanjaan mewah, hingga kawasan kuliner yang tak pernah sepi pengunjung.",
                R.drawable.jakarta));

        daftarKota.add(new Kota("Surabaya",
                "Surabaya adalah kota metropolitan terbesar kedua di Indonesia yang terletak di Provinsi Jawa Timur. Kota ini dikenal sebagai kota pahlawan karena peran pentingnya dalam perjuangan melawan penjajah pada peristiwa 10 November 1945. Semangat patriotisme masyarakat Surabaya hingga kini masih terasa kental dalam setiap sudut kota.\n\n" +
                        "Sebagai kota industri dan pelabuhan utama, Surabaya memiliki infrastruktur yang cukup modern dan lengkap. Pelabuhan Tanjung Perak menjadi salah satu pelabuhan tersibuk di Indonesia dan pintu gerbang distribusi barang ke kawasan timur Indonesia. Banyak perusahaan besar, baik nasional maupun internasional, memiliki kantor cabang di kota ini.\n\n" +
                        "Selain sisi industrinya, Surabaya juga menawarkan banyak tempat menarik. Tugu Pahlawan menjadi ikon penting yang mengingatkan pada jasa para pejuang kemerdekaan. Ada juga House of Sampoerna yang merupakan museum bersejarah dan tempat produksi rokok kretek secara tradisional yang masih aktif.\n\n" +
                        "Kehidupan kuliner di Surabaya sangat beragam, mulai dari Rawon, Rujak Cingur, hingga Lontong Balap. Masyarakat Surabaya dikenal ramah, lugas, dan terbuka terhadap pendatang, menjadikan kota ini nyaman untuk tinggal maupun berwisata.",
                R.drawable.surabaya));

        daftarKota.add(new Kota("Bandung",
                "Bandung adalah ibu kota Provinsi Jawa Barat yang terletak di dataran tinggi, sehingga memiliki udara yang sejuk dan menyegarkan. Julukan Kota Kembang melekat karena keindahan alam dan banyaknya taman-taman yang menghiasi kota. Selain itu, Bandung juga dikenal sebagai kota kreatif yang menjadi pusat mode, desain, dan inovasi teknologi.\n\n" +
                        "Sejarah Bandung juga cukup panjang. Pada masa penjajahan Belanda, Bandung dijuluki \"Paris van Java\" karena suasananya yang modern dan gaya hidup masyarakatnya yang kosmopolitan. Gedung Sate, dengan ciri khas tusuk sate di puncaknya, menjadi ikon arsitektur peninggalan kolonial yang kini digunakan sebagai kantor Gubernur Jawa Barat.\n\n" +
                        "Bandung juga menjadi saksi peristiwa besar dunia, yakni Konferensi Asia Afrika pada tahun 1955. Gedung Merdeka, tempat berlangsungnya konferensi, kini dijadikan museum yang banyak dikunjungi wisatawan dan pelajar. Peristiwa ini menandai peran penting Bandung dalam diplomasi internasional.\n\n" +
                        "Sebagai kota pelajar, Bandung memiliki banyak perguruan tinggi ternama seperti ITB dan Universitas Padjadjaran. Kawasan Dago, Lembang, dan Braga menjadi pusat keramaian yang menawarkan wisata kuliner, fashion, hingga alam pegunungan yang menakjubkan. Tak heran jika Bandung selalu ramai dikunjungi wisatawan, terutama dari Jakarta dan sekitarnya.",
                R.drawable.bandung));

        daftarKota.add(new Kota("Medan",
                "Medan adalah kota terbesar di Pulau Sumatra dan ibu kota dari Provinsi Sumatra Utara. Kota ini menjadi pusat ekonomi, perdagangan, dan pendidikan di kawasan barat Indonesia. Letaknya yang strategis dekat dengan Selat Malaka menjadikan Medan sebagai gerbang masuk penting bagi perdagangan internasional.\n\n" +
                        "Keunikan Medan terletak pada keberagaman etnis yang hidup berdampingan, seperti Batak, Melayu, Tionghoa, dan India. Keberagaman ini terlihat dari beragam bangunan ibadah, mulai dari masjid megah hingga kuil dan gereja tua yang berdiri berdampingan dengan damai. Salah satu bangunan ikonik adalah Masjid Raya Al Mashun yang memiliki arsitektur indah perpaduan Timur Tengah, India, dan Spanyol.\n\n" +
                        "Istana Maimun juga menjadi simbol kejayaan Kesultanan Deli yang pernah berjaya di masa lalu. Wisatawan dapat menikmati keindahan arsitektur istana sambil mengenakan pakaian adat Melayu untuk berfoto. Di samping wisata sejarah, Medan juga terkenal dengan kulinernya seperti Bika Ambon, Lontong Medan, dan Durian Ucok yang melegenda.\n\n" +
                        "Medan terus berkembang sebagai kota modern dengan infrastruktur yang semakin maju. Bandara Internasional Kualanamu menjadi salah satu yang terbaik di Indonesia, menghubungkan Medan dengan berbagai kota dalam dan luar negeri. Kehidupan di Medan menggambarkan perpaduan antara budaya lokal yang kuat dan dinamika kota metropolitan.",
                R.drawable.medan));

        daftarKota.add(new Kota("Semarang",
                "Semarang adalah ibu kota Provinsi Jawa Tengah yang terletak di pesisir utara Pulau Jawa. Kota ini memiliki sejarah panjang sejak masa kerajaan Mataram hingga masa kolonial Belanda. Sebagai kota pelabuhan, Semarang sejak dahulu menjadi pusat perdagangan penting yang menghubungkan Indonesia dengan dunia luar.\n\n" +
                        "Lawang Sewu adalah salah satu bangunan bersejarah terkenal di Semarang. Bangunan peninggalan Belanda ini memiliki arsitektur megah dan kisah misteri yang menarik wisatawan. Selain itu, ada Klenteng Sam Poo Kong yang menjadi bukti akulturasi budaya Tionghoa dan Jawa yang harmonis.\n\n" +
                        "Kawasan Kota Lama Semarang menyajikan suasana tempo dulu dengan deretan gedung-gedung kolonial yang masih terjaga. Di sana, pengunjung bisa menikmati kopi di kafe-kafe vintage sambil menikmati arsitektur kuno yang indah. Tak ketinggalan, kuliner khas seperti Lumpia Semarang dan Tahu Gimbal wajib dicoba saat berkunjung.\n\n" +
                        "Semarang juga terus berkembang dengan banyaknya pembangunan kawasan industri, perumahan modern, dan proyek infrastruktur seperti jalan tol dan pelabuhan. Meskipun berkembang pesat, kota ini tetap mempertahankan kearifan lokal dan nilai-nilai budaya Jawa Tengah yang kental dalam kehidupan masyarakatnya.",
                R.drawable.semarang));

        daftarKota.add(new Kota("Makassar",
                "Makassar adalah kota terbesar di Indonesia bagian timur dan ibu kota Provinsi Sulawesi Selatan. Dulu dikenal dengan nama Ujung Pandang, Makassar adalah kota yang kaya sejarah, terutama sebagai pusat Kerajaan Gowa-Tallo yang terkenal akan kekuatan maritimnya. Lokasinya yang strategis menjadikannya pelabuhan utama yang menghubungkan kawasan timur dan barat Indonesia.\n\n" +
                        "Pantai Losari adalah ikon kota Makassar, tempat di mana warga dan wisatawan menikmati senja sambil mencicipi kuliner khas seperti Pisang Epe. Tidak jauh dari sana, terdapat Benteng Rotterdam yang menjadi saksi sejarah kolonial Belanda dan kini difungsikan sebagai museum budaya Sulawesi Selatan.\n\n" +
                        "Kota ini juga dikenal dengan kulinernya yang kuat rasa dan kaya rempah. Hidangan seperti Coto Makassar, Konro, dan Pallubasa sangat digemari baik oleh masyarakat lokal maupun wisatawan. Suku Bugis-Makassar yang dominan di kota ini terkenal akan budaya pelaut dan nilai-nilai kehormatan yang kuat.\n\n" +
                        "Makassar juga berkembang sebagai kota modern dengan fasilitas pendidikan tinggi, pusat perbelanjaan, dan kawasan bisnis. Pelabuhan Soekarno-Hatta dan Bandara Internasional Sultan Hasanuddin menjadi jalur utama transportasi yang menghubungkan Makassar dengan daerah-daerah lain di Indonesia maupun mancanegara.",
                R.drawable.makasar));

        daftarKota.add(new Kota("Denpasar",
                "Denpasar adalah ibu kota Provinsi Bali dan menjadi pusat pemerintahan sekaligus kota yang berkembang pesat di pulau dewata. Kota ini menjadi jantung dari kehidupan masyarakat Bali yang kental dengan budaya Hindu dan adat istiadat yang masih terjaga hingga kini. Meski terkenal sebagai destinasi wisata internasional, Denpasar tetap memiliki identitas budaya yang kuat.\n\n" +
                        "Pura Jagatnatha dan Museum Bali adalah dua tempat penting yang mencerminkan spiritualitas dan sejarah panjang Pulau Bali. Di kota ini, upacara keagamaan seperti Galungan dan Kuningan rutin digelar, menghiasi jalan-jalan dengan penjor dan suasana sakral yang unik.\n\n" +
                        "Denpasar juga memiliki kawasan Sanur, salah satu kawasan wisata tertua di Bali yang menawarkan pantai tenang dan matahari terbit yang indah. Di sisi lain, Denpasar juga menjadi pusat ekonomi dan pendidikan dengan banyaknya kantor, sekolah, dan perguruan tinggi.\n\n" +
                        "Meskipun tidak seramai Kuta atau Ubud dalam hal wisata, Denpasar tetap memiliki daya tarik tersendiri dengan atmosfer yang lebih tenang namun tetap modern. Kehidupan masyarakat yang religius, tata kota yang tertata, serta keramahan penduduk lokal menjadikan Denpasar tempat yang nyaman untuk tinggal maupun berkunjung.",
                R.drawable.denpasar));

        daftarKota.add(new Kota("Yogyakarta",
                "Yogyakarta, atau sering disapa Jogja, adalah kota yang istimewa bukan hanya karena statusnya sebagai Daerah Istimewa, tetapi juga karena kekayaan budaya, sejarah, dan pendidikannya. Kota ini masih dipimpin oleh seorang Sultan yang juga menjabat sebagai Gubernur, mencerminkan perpaduan unik antara sistem monarki dan pemerintahan modern.\n\n" +
                        "Kota ini terkenal sebagai pusat budaya Jawa, dengan Keraton Yogyakarta sebagai jantung tradisinya. Upacara adat, tarian klasik, gamelan, dan batik tetap hidup di tengah kehidupan modern. Keraton dan Taman Sari menjadi saksi bisu kejayaan Mataram Islam yang sangat berpengaruh di masa lalu.\n\n" +
                        "Yogyakarta juga dijuluki sebagai Kota Pelajar karena banyaknya institusi pendidikan, termasuk Universitas Gadjah Mada yang menjadi salah satu perguruan tinggi terbaik di Indonesia. Ribuan mahasiswa dari seluruh Indonesia datang untuk menimba ilmu di kota ini, menjadikan suasana kota dinamis dan penuh semangat intelektual.\n\n" +
                        "Selain pendidikan dan budaya, Jogja juga menawarkan wisata alam dan sejarah yang memikat. Candi Prambanan yang megah dan situs Gunung Merapi adalah daya tarik utama. Sementara di kota, Malioboro menjadi pusat belanja dan oleh-oleh, dengan suasana malam yang khas dan ramah. Yogyakarta adalah tempat yang membentuk kenangan mendalam bagi siapa pun yang pernah menginjakkan kaki di sana.",
                R.drawable.yogyakarta));

        daftarKota.add(new Kota("Padang",
                "Padang adalah ibu kota Provinsi Sumatera Barat yang terletak di pesisir barat Pulau Sumatra. Kota ini terkenal dengan keindahan pantainya yang menghadap langsung ke Samudra Hindia, serta pegunungan Bukit Barisan yang membentang di sekitarnya. Perpaduan alam ini menjadikan Padang sebagai kota dengan panorama yang menakjubkan.\n\n" +
                        "Kebudayaan Minangkabau sangat kental di Padang. Rumah Gadang dengan atap bergonjong menjadi simbol khas, menggambarkan filosofi hidup masyarakat Minang yang matrilineal. Di kota ini, tradisi adat, seni tari, dan musik tradisional seperti saluang dan talempong masih hidup dan sering dipentaskan dalam acara budaya.\n\n" +
                        "Padang juga dikenal dengan kekayaan kulinernya yang mendunia. Rendang, masakan khas Minang, pernah dinobatkan sebagai makanan terenak di dunia. Restoran Padang yang menjamur di seluruh Indonesia berasal dari budaya makan khas masyarakat Padang, yaitu menyajikan berbagai lauk dalam piring kecil secara bersamaan.\n\n" +
                        "Selain itu, kota Padang memiliki potensi pariwisata yang luar biasa seperti Pantai Air Manis dengan legenda Malin Kundang, serta kawasan Bukit Tinggi dan Lembah Harau yang bisa dijangkau dari kota. Kota ini memadukan kekuatan budaya, sejarah, alam, dan semangat wirausaha yang menjadikannya salah satu kota penting di Sumatra.",
                R.drawable.padang));

        daftarKota.add(new Kota("Palembang",
                "Palembang adalah ibu kota Provinsi Sumatera Selatan dan dikenal sebagai salah satu kota tertua di Indonesia. Sejarah mencatat Palembang sebagai pusat Kerajaan Sriwijaya yang pernah berjaya di Asia Tenggara pada abad ke-7 hingga ke-13. Sungai Musi yang membelah kota menjadi saksi bisu kejayaan maritim kerajaan ini.\n\n" +
                        "Sungai Musi juga menjadi ikon kota modern Palembang, terutama dengan keberadaan Jembatan Ampera yang menjadi simbol kebanggaan masyarakat. Di malam hari, jembatan ini terlihat indah dengan pencahayaan warna-warni, menjadi daya tarik wisata tersendiri. Di sekitarnya, terdapat Benteng Kuto Besak dan dermaga wisata air.\n\n" +
                        "Palembang juga terkenal dengan kuliner khasnya, terutama pempek yang terbuat dari ikan dan sagu, disajikan dengan kuah cuko yang asam pedas. Selain pempek, makanan seperti tekwan, model, dan laksan menjadi hidangan wajib bagi wisatawan. Kota ini juga memiliki warisan budaya yang kuat dengan pengaruh Melayu dan Cina.\n\n" +
                        "Dalam perkembangannya, Palembang terus berbenah menjadi kota metropolitan modern. Kota ini pernah menjadi tuan rumah Asian Games 2018 bersama Jakarta, dan banyak infrastruktur dibangun seperti LRT dan stadion Gelora Sriwijaya. Palembang memadukan nilai sejarah, budaya, dan pembangunan modern secara harmonis.",
                R.drawable.palembang));

        daftarKota.add(new Kota("Malang",
                "Malang adalah kota di Provinsi Jawa Timur yang dikenal dengan udara sejuk dan pesona alamnya yang menawan. Kota ini berada di dataran tinggi dan dikelilingi oleh pegunungan, menjadikannya salah satu destinasi wisata favorit di Indonesia.\n\n" +
                        "Sejak zaman kolonial, Malang menjadi kota peristirahatan bangsa Belanda. Bangunan kolonial, jalan-jalan rindang, dan taman kota yang indah menambah nilai historis kota ini. Alun-alun Kota Malang dan Museum Brawijaya adalah tempat populer untuk wisata sejarah.\n\n" +
                        "Sebagai kota pelajar, Malang memiliki beberapa universitas ternama seperti Universitas Brawijaya dan Universitas Negeri Malang. Selain itu, Malang juga terkenal dengan kuliner bakso, rawon, dan makanan tradisional lainnya.\n\n" +
                        "Malang terus berkembang menjadi kota modern dengan fasilitas wisata keluarga seperti Jatim Park, Museum Angkut, dan Batu Night Spectacular. Malang memadukan nuansa budaya, pendidikan, dan alam yang menjadikannya kota yang nyaman untuk dikunjungi.",
                R.drawable.malang));

        daftarKota.add(new Kota("Banjarmasin",
                "Banjarmasin adalah ibu kota Provinsi Kalimantan Selatan yang terkenal dengan julukan Kota Seribu Sungai. Kota ini tumbuh di sekitar sungai-sungai besar seperti Sungai Barito dan Sungai Martapura, yang menjadi urat nadi kehidupan masyarakatnya.\n\n" +
                        "Tradisi pasar terapung di Banjarmasin menjadi daya tarik utama wisatawan. Di pagi hari, pedagang menjajakan hasil bumi, makanan, dan kebutuhan sehari-hari dari atas perahu, menciptakan pemandangan unik yang hanya bisa ditemukan di sini.\n\n" +
                        "Budaya Banjar yang kuat tercermin dalam kesenian seperti Madihin dan tari Radap Rahayu. Rumah adat Banjar dan masjid berarsitektur kayu seperti Masjid Sultan Suriansyah menjadi simbol kearifan lokal yang masih terjaga.\n\n" +
                        "Sebagai kota modern, Banjarmasin juga dilengkapi dengan berbagai fasilitas publik, pelabuhan, dan pusat perbelanjaan. Kota ini menjadi pusat perdagangan dan logistik penting di Kalimantan, sekaligus menjaga kekayaan budaya sungainya.",
                R.drawable.banjarmasin));

        daftarKota.add(new Kota("Pontianak",
                "Pontianak adalah ibu kota Provinsi Kalimantan Barat yang berada tepat di garis khatulistiwa. Kota ini memiliki Tugu Khatulistiwa sebagai simbol kebanggaan yang menarik wisatawan dari berbagai daerah.\n\n" +
                        "Pontianak merupakan kota multikultural yang dihuni oleh suku Melayu, Dayak, Tionghoa, dan lainnya. Keberagaman ini tercermin dalam arsitektur, tradisi, dan makanan khas seperti choi pan, pengkang, dan bubur pedas.\n\n" +
                        "Kota ini juga dikenal dengan Sungai Kapuas, sungai terpanjang di Indonesia, yang membelah kota menjadi dua bagian. Aktivitas masyarakat di sekitar sungai menambah warna kehidupan kota ini.\n\n" +
                        "Pemerintah daerah terus berinovasi dalam pembangunan infrastruktur dan fasilitas publik. Pontianak kini menjadi salah satu kota penting dalam jalur perdagangan Kalimantan Barat dengan pelabuhan besar dan bandara modern.",
                R.drawable.pontianak));

        daftarKota.add(new Kota("Manado",
                "Manado adalah ibu kota Provinsi Sulawesi Utara yang terkenal dengan keindahan alam bawah lautnya. Kota ini menjadi gerbang menuju Taman Laut Bunaken yang merupakan salah satu surga menyelam terbaik di dunia.\n\n" +
                        "Mayoritas penduduk Manado adalah etnis Minahasa yang dikenal ramah dan terbuka. Budaya lokal seperti tari Maengket dan rumah adat Wale tetap lestari di tengah perkembangan kota.\n\n" +
                        "Kota ini juga dikenal dengan keragaman kulinernya, dari tinutuan (bubur Manado) hingga makanan laut segar yang melimpah. Gereja-gereja tua dan patung Yesus Memberkati menjadi daya tarik religi dan budaya.\n\n" +
                        "Manado terus berkembang dengan infrastruktur yang mendukung pariwisata dan ekonomi. Bandara Sam Ratulangi, pelabuhan internasional, serta hotel-hotel modern menjadikan kota ini siap bersaing di tingkat global.",
                R.drawable.manado));

        daftarKota.add(new Kota("Balikpapan",
                "Balikpapan adalah kota di Provinsi Kalimantan Timur yang dikenal sebagai kota industri dan energi. Letaknya strategis di pesisir timur Kalimantan menjadikan kota ini sebagai pelabuhan utama dan pusat logistik nasional.\n\n" +
                        "Sejak era kolonial Belanda, Balikpapan telah menjadi kota penghasil minyak. Sampai kini, industri migas masih mendominasi ekonomi kota ini, dengan kehadiran perusahaan besar seperti Pertamina dan Chevron.\n\n" +
                        "Meskipun identik dengan industri, Balikpapan tetap menjaga kelestarian lingkungan. Pantai-pantai bersih, hutan lindung, dan konservasi beruang madu menjadi daya tarik wisata alamnya.\n\n" +
                        "Balikpapan juga dikenal sebagai kota yang tertib dan nyaman. Dengan bandara internasional dan infrastruktur modern, kota ini siap mendukung pengembangan Ibu Kota Negara (IKN) Nusantara di wilayah sekitarnya.",
                R.drawable.balikpapan));

        daftarKota.add(new Kota("Banda Aceh",
                "Banda Aceh adalah ibu kota Provinsi Aceh dan dikenal sebagai Serambi Mekah. Kota ini memiliki nilai sejarah, budaya, dan agama yang sangat kuat sebagai pusat penyebaran Islam pertama di Indonesia.\n\n" +
                        "Masjid Raya Baiturrahman menjadi simbol utama kota, dengan arsitektur megah dan sejarah panjang sejak abad ke-19. Masjid ini menjadi tempat berkumpul masyarakat dan simbol keteguhan saat tsunami melanda.\n\n" +
                        "Tsunami 2004 menjadi titik balik bagi Banda Aceh. Kota ini bangkit dengan semangat luar biasa, membangun kembali infrastruktur dan memperkuat kesadaran akan mitigasi bencana.\n\n" +
                        "Banda Aceh juga menawarkan wisata religi, sejarah, dan alam. Museum Tsunami, situs Kapal di Atas Rumah, dan pantai-pantai indah seperti Lampuuk menjadikan kota ini penuh cerita dan daya tarik.",
                R.drawable.bandaaceh));

        daftarKota.add(new Kota("Mataram",
                "Mataram adalah ibu kota Provinsi Nusa Tenggara Barat yang terletak di Pulau Lombok. Kota ini menjadi pusat pemerintahan, ekonomi, dan kebudayaan masyarakat Sasak.\n\n" +
                        "Mataram memiliki banyak tempat wisata menarik, seperti Taman Narmada dan Pura Meru yang menunjukkan perpaduan budaya Hindu dan Islam. Tradisi Sasak seperti tenun ikat dan musik Gendang Beleq juga menjadi warisan budaya yang dijaga.\n\n" +
                        "Kota ini juga menjadi gerbang menuju wisata alam Lombok, seperti Pantai Senggigi dan Gunung Rinjani. Pariwisata menjadi sektor penting yang didukung oleh infrastruktur modern dan keramahan masyarakatnya.\n\n" +
                        "Sebagai kota berkembang, Mataram terus membangun dalam sektor pendidikan, transportasi, dan pelayanan publik, menjadikannya kota yang strategis dan nyaman untuk ditinggali.",
                R.drawable.mataram));

        daftarKota.add(new Kota("Kupang",
                "Kupang adalah ibu kota Provinsi Nusa Tenggara Timur yang berada di Pulau Timor. Kota ini menjadi pusat administrasi, perdagangan, dan transportasi di wilayah timur Indonesia.\n\n" +
                        "Kota ini menyimpan jejak sejarah kolonial Portugis dan Belanda, yang masih terlihat pada benteng dan gereja tua. Kupang juga dikenal sebagai kota pelabuhan penting sejak zaman VOC.\n\n" +
                        "Masyarakat Kupang hidup dengan beragam budaya lokal seperti Suku Dawan, Helong, dan Rote. Musik sasando dan kain tenun ikat menjadi warisan budaya yang terus dikembangkan.\n\n" +
                        "Kupang memiliki potensi wisata bahari seperti Pantai Lasiana dan Pulau Semau. Pemerintah daerah aktif mendorong pariwisata dan pembangunan infrastruktur untuk mendorong pertumbuhan ekonomi.",
                R.drawable.kupang));

        daftarKota.add(new Kota("Jayapura",
                "Jayapura adalah ibu kota Provinsi Papua dan merupakan kota terbesar di ujung timur Indonesia. Letaknya yang menghadap Teluk Youtefa menjadikan kota ini memiliki pemandangan alam yang indah.\n\n" +
                        "Jayapura memiliki sejarah penting sebagai kota yang dulunya bernama Hollandia pada masa penjajahan Belanda. Kini, kota ini menjadi pusat administrasi, pendidikan, dan ekonomi di wilayah Papua.\n\n" +
                        "Budaya masyarakat Papua sangat kental di Jayapura. Tarian Yospan, ukiran kayu, dan lukisan kulit kayu merupakan bagian dari identitas budaya yang terus dilestarikan.\n\n" +
                        "Kota ini berkembang pesat dengan pembangunan infrastruktur, pelabuhan, dan Bandara Sentani yang menghubungkan Papua dengan daerah lain. Jayapura menjadi simbol kemajuan dan keragaman di tanah Papua.",
                R.drawable.jayapura));

        daftarKota.add(new Kota("Ternate",
                "Ternate adalah kota di Provinsi Maluku Utara yang dulunya merupakan pusat perdagangan rempah dunia. Kota ini dikenal dalam sejarah sebagai daerah penghasil cengkeh yang menjadi incaran bangsa Eropa.\n\n" +
                        "Sebagai bekas kerajaan Islam yang kuat, Ternate memiliki banyak peninggalan sejarah seperti Benteng Oranje, Kedaton Sultan, dan masjid tua. Keberadaan Kesultanan Ternate masih bertahan sebagai simbol budaya lokal.\n\n" +
                        "Letak geografis Ternate berada di kaki Gunung Gamalama, menjadikannya kota yang indah namun rawan aktivitas vulkanik. Meskipun begitu, masyarakat tetap hidup berdampingan dengan alam.\n\n" +
                        "Kini, Ternate menjadi kota yang bersih, tertib, dan ramah wisatawan. Potensi wisata sejarah dan alam menjadikan kota ini penting dalam promosi pariwisata kawasan timur Indonesia.",
                R.drawable.ternate));
        // Tampilkan kota pertama
        tampilkanKota(posisi);

        // Tombol Next
        btnNext.setOnClickListener(v -> {
            if (posisi < daftarKota.size() - 1) {
                posisi++;
                tampilkanKota(posisi);
            }
        });

        // Tombol Prev
        btnPrev.setOnClickListener(v -> {
            if (posisi > 0) {
                posisi--;
                tampilkanKota(posisi);
            }
        });

        // Tombol Kembali ke MainActivity
        btnKembali.setOnClickListener(v -> {
            Intent intent = new Intent(MateriActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void tampilkanKota(int index) {
        Kota kota = daftarKota.get(index);
        tvJudul.setText(kota.nama);
        tvDeskripsi.setText(kota.deskripsi);
        ivKota.setImageResource(kota.gambar);
    }

    // Model data kota
    public static class Kota {
        String nama;
        String deskripsi;
        int gambar;

        public Kota(String nama, String deskripsi, int gambar) {
            this.nama = nama;
            this.deskripsi = deskripsi;
            this.gambar = gambar;
        }
    }
}





