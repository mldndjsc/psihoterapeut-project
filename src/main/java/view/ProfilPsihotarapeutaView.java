package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import module.Psihoterapeut;

public class ProfilPsihotarapeutaView extends BorderPane {
    private Psihoterapeut psihoterapeut;
    private Label imePrezime;
    private Label email;
    private Label telefon;
    private Label supervizor;
    private Label struka;

    public ProfilPsihotarapeutaView(Psihoterapeut psihoterapeut) {
        this.psihoterapeut=psihoterapeut;
        initElements();
        addElements();
    }

    public void initElements(){
        imePrezime=new Label("Ime i prezime:"+psihoterapeut.getImePrezime());
        email=new Label("Email:"+psihoterapeut.getEmail());
        telefon=new Label("Telefon:"+psihoterapeut.getTelefon());
        struka=new Label("Struka:"+psihoterapeut.getStruka());
        supervizor=new Label("Supervizor"+psihoterapeut.isSupervizor());
    }

    public void addElements(){
        VBox vBox=new VBox();
        vBox.getChildren().addAll(imePrezime,email,telefon,struka,supervizor);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20));
        this.setCenter(vBox);
    }
}
