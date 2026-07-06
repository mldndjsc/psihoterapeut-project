package view;

import controller.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import module.Psihoterapeut;

public class PsihoterapeutView extends VBox {
    private Label psihoterapeutIme;
    private Button profilPsihotarapeuta;
    private Button pregledSeansi;
    private Button pregledKlijenta;
    private Psihoterapeut psihoterapeut;

    public PsihoterapeutView(Psihoterapeut psihoterapeut) {
        this.psihoterapeut = psihoterapeut;
        initElements();
        setElements();
        addController();

    }
    private void initElements(){
        profilPsihotarapeuta=new Button("Profil psihotarapeuta");
        pregledSeansi=new Button("Pregled seansi");
        pregledKlijenta=new Button("Pregled klijenta");
        psihoterapeutIme = new Label("Psihoterapeut" + psihoterapeut.getImePrezime());
    }

    private void setElements(){
        HBox hbox = new HBox();
        hbox.getChildren().add(psihoterapeutIme);
        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(pregledSeansi,pregledKlijenta,profilPsihotarapeuta);
        this.setPadding(new Insets(10));
        this.setSpacing(10);
        this.getChildren().addAll(hbox,hbox2);


    }
    private void addController(){

        pregledKlijenta.setOnAction(e -> {
            if (psihoterapeut != null) {
                new PregledKlijentaController(psihoterapeut).handle(e);
            } else {
                // Možeš prikazati upozorenje korisniku
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Upozorenje");
                alert.setHeaderText(null);
                alert.setContentText("Molimo selektujte psihoterapeuta iz tabele.");
                alert.showAndWait();
            }
        });
        pregledSeansi.setOnAction(e -> {
            if (psihoterapeut != null) {
                new PregledSeansiController(psihoterapeut).handle(e);
            } else {
                // Možeš prikazati upozorenje korisniku
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Upozorenje");
                alert.setHeaderText(null);
                alert.setContentText("Molimo selektujte psihoterapeuta iz tabele.");
                alert.showAndWait();
            }
        });
        profilPsihotarapeuta.setOnAction(e -> {
            if (psihoterapeut != null) {
                new ProfilPsihotarapeutaController(psihoterapeut).handle(e);
            } else {
                // Možeš prikazati upozorenje korisniku
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Upozorenje");
                alert.setHeaderText(null);
                alert.setContentText("Molimo selektujte psihoterapeuta iz tabele.");
                alert.showAndWait();
            }
        });
    }
}
