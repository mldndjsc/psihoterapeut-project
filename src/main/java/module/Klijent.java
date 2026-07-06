package module;

public class Klijent {
    private int klijentId;
    private String ime;
    private String prezime;
    private String telefon;
    private String pol;
    private String email;
    private String datum;
    private int bioNaSeansi;

    public Klijent(Integer klijentId,String ime, String prezime, String telefon, String pol, String email, String datum, int bioNaSeansi) {
        this.klijentId=klijentId;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.pol = pol;
        this.email = email;
        this.datum = datum;
        this.bioNaSeansi = bioNaSeansi;
    }

    public int getKlijentId() {
        return klijentId;
    }

    public void setKlijentId(int klijentId) {
        this.klijentId = klijentId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getBioNaSeansi() {
        return bioNaSeansi;
    }

    public void setBioNaSeansi(int bioNaSeansi) {
        this.bioNaSeansi = bioNaSeansi;
    }

    @Override
    public String toString() {
        return "Klijent{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", telefon='" + telefon + '\'' +
                ", pol='" + pol + '\'' +
                ", email='" + email + '\'' +
                ", datum='" + datum + '\'' +
                ", bioNaSeansi=" + bioNaSeansi +
                '}';
    }
}
