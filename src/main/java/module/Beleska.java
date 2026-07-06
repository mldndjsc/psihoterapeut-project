package module;

public class Beleska {
    private String tekst;
    private String izdato;

    public Beleska(String tekst, String izdato) {
        this.tekst = tekst;
        this.izdato = izdato;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getIzdato() {
        return izdato;
    }

    public void setIzdato(String izdato) {
        this.izdato = izdato;
    }
}
