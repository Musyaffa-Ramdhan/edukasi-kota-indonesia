package app.example.projekkota;

public class CiriKhasKota {
    private String namaKota;
    private String makananKhas;
    private String pakaianAdat;
    private String senjataTradisional;
    private String rumahAdat;
    private String alatMusik;
    private String kesenianDaerah;
    private String bahasaDaerah;
    private String ikonKota;

    public CiriKhasKota(String namaKota, String makananKhas, String pakaianAdat,
                        String senjataTradisional, String rumahAdat, String alatMusik,
                        String kesenianDaerah, String bahasaDaerah, String ikonKota) {
        this.namaKota = namaKota;
        this.makananKhas = makananKhas;
        this.pakaianAdat = pakaianAdat;
        this.senjataTradisional = senjataTradisional;
        this.rumahAdat = rumahAdat;
        this.alatMusik = alatMusik;
        this.kesenianDaerah = kesenianDaerah;
        this.bahasaDaerah = bahasaDaerah;
        this.ikonKota = ikonKota;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public String getMakananKhas() {
        return makananKhas;
    }

    public String getPakaianAdat() {
        return pakaianAdat;
    }

    public String getSenjataTradisional() {
        return senjataTradisional;
    }

    public String getRumahAdat() {
        return rumahAdat;
    }

    public String getAlatMusik() {
        return alatMusik;
    }

    public String getKesenianDaerah() {
        return kesenianDaerah;
    }

    public String getBahasaDaerah() {
        return bahasaDaerah;
    }

    public String getIkonKota() {
        return ikonKota;
    }
}
