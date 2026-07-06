package module;

public class Seansa {
    private int idSeanse;
    private String vreme;
    private String dan;
    private int trajanje;
    private String datumPromeneCene;
    private String Klijent;

    public Seansa(int idSeanse,String vreme, String dan, int trajanje, String datumPromeneCene, String klijent) {
        this.idSeanse=idSeanse;
        this.vreme = vreme;
        this.dan = dan;
        this.trajanje = trajanje;
        this.datumPromeneCene = datumPromeneCene;
        Klijent = klijent;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public String getDan() {
        return dan;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public String getDatumPromeneCene() {
        return datumPromeneCene;
    }

    public void setDatumPromeneCene(String datumPromeneCene) {
        this.datumPromeneCene = datumPromeneCene;
    }

    public String getKlijent() {
        return Klijent;
    }

    public void setKlijent(String klijent) {
        Klijent = klijent;
    }

    public int getIdSeanse() {
        return idSeanse;
    }

    public void setIdSeanse(int idSeanse) {
        this.idSeanse = idSeanse;
    }

    @Override
    public String toString() {
        return "Seansa{" +
                "vreme='" + vreme + '\'' +
                ", dan='" + dan + '\'' +
                ", trajanje=" + trajanje +
                ", datumPromeneCene='" + datumPromeneCene + '\'' +
                ", Klijent='" + Klijent + '\'' +
                '}';
    }
}
