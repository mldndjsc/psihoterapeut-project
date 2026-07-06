package module;

public class Placanje {
    private int id;
    private String svrha;
    private String nacinPlacanja;
    private int iznos;

    public Placanje(int id, String svrha, String nacinPlacanja, int iznos) {
        this.id = id;
        this.svrha = svrha;
        this.nacinPlacanja = nacinPlacanja;
        this.iznos = iznos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSvrha() {
        return svrha;
    }

    public void setSvrha(String svrha) {
        this.svrha = svrha;
    }

    public String getNacinPlacanja() {
        return nacinPlacanja;
    }

    public void setNacinPlacanja(String nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }

    @Override
    public String toString() {
        return "Placanje{" +
                "id=" + id +
                ", svrha='" + svrha + '\'' +
                ", nacinPlacanja='" + nacinPlacanja + '\'' +
                ", iznos=" + iznos +
                '}';
    }
}
