package module;

public class Psihoterapeut {

    private String imePrezime;
    private String email;
    private String telefon;
    private String struka;
    private boolean supervizor;
    private String centarZaObuku;

    public Psihoterapeut(String imePrezime, String email, String telefon, String struka, boolean supervizor, String centarZaObuku) {
        this.imePrezime = imePrezime;
        this.email = email;
        this.telefon = telefon;
        this.struka = struka;
        this.supervizor = supervizor;
        this.centarZaObuku = centarZaObuku;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getStruka() {
        return struka;
    }

    public void setStruka(String struka) {
        this.struka = struka;
    }

    public boolean isSupervizor() {
        return supervizor;
    }

    public void setSupervizor(boolean supervizor) {
        this.supervizor = supervizor;
    }

    public String getCentarZaObuku() {
        return centarZaObuku;
    }

    public void setCentarZaObuku(String centarZaObuku) {
        this.centarZaObuku = centarZaObuku;
    }

    @Override
    public String toString() {
        return "Psihoterapeut{" +
                "imePrezime='" + imePrezime + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", struka='" + struka + '\'' +
                ", supervizor=" + supervizor +
                ", centarZaObuku='" + centarZaObuku + '\'' +
                '}';
    }
}
