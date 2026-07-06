package view;

import controller.SignUpPsihoterapeutController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import module.Struka;
import util.JDBCUtils;

import java.util.List;

public class SignUpView extends BorderPane {

    private Label imePrezime;
    private TextField imeiPrezime;
    private Label mejl;

    private TextField email;
    private Label teleffon;
    private TextField telefon;
    private Label strukaa;
    private ComboBox<Struka> struka;
    private Label sVizor;
    private CheckBox supervizor;
    private Label centriZaObukuu;
    private ComboBox<String> centriZaObuku;
    private Button signUp;

    public SignUpView() {
        initElements();
        setElements();
        addControllers();
    }

    private void addControllers() {
        signUp.setOnAction(new SignUpPsihoterapeutController(imeiPrezime,email,telefon,struka,supervizor,centriZaObuku));
    }

    private void setElements() {
        GridPane gp = new GridPane();
        gp.add(imePrezime,0,0);
        gp.add(imeiPrezime,1,0);
        gp.add(mejl,0,1);
        gp.add(email,1,1);
        gp.add(teleffon,0,2);
        gp.add(telefon,1,2);
        gp.add(strukaa,0,3);
        gp.add(struka,1,3);
        gp.add(sVizor,0,4);
        gp.add(supervizor,1,4);
        gp.add(centriZaObukuu,0,5);
        gp.add(centriZaObuku,1,5);
        gp.setVgap(10);
        gp.setHgap(10);
        this.setBottom(signUp);
        this.setPadding(new Insets(15));
        this.setCenter(gp);
    }

    private void initElements() {
        imeiPrezime = new TextField();
        imePrezime = new Label("Unesite Ime i Prezime");
        mejl = new Label("Unesite Mejl");
        telefon = new TextField();
        email = new TextField();
        teleffon = new Label("Unesite telefon");
        strukaa = new Label("Izaberite struku");
        struka = new ComboBox<>(FXCollections.observableArrayList(List.of(Struka.pedagogija,Struka.psihologija,Struka.psihoterapija)));
        sVizor = new Label("Da li ste supervizor");
        supervizor = new CheckBox();
        centriZaObukuu = new Label("Izaberite centar za obuku");
        centriZaObuku = new ComboBox<>(FXCollections.observableArrayList(JDBCUtils.selectCentreZaObuku()));
        signUp = new Button("Sign Up");
    }
}
