package view;

import controller.PregledKlijentaController;
import controller.PregledPlacanjaController;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import module.Klijent;
import module.Psihoterapeut;

import java.util.List;

public class PregledKlijentaView extends BorderPane {
    private TableView<Klijent> klijentiTableView;
    private List<Klijent> listaKlijenata;
    private Button pregledPlacanja;
    public PregledKlijentaView(List<Klijent> klijenti) {
        this.listaKlijenata=klijenti;
        initElements();
        addElements();
        addController();
    }
    void initElements(){
        klijentiTableView=new TableView<>();
        TableColumn<Klijent,String> imeKol=new TableColumn<>("ime");
        TableColumn<Klijent,String> prezimeKol=new TableColumn<>("prezime");
        TableColumn<Klijent,String> telefonKol=new TableColumn<>("telefon");
        TableColumn<Klijent,String> polKol=new TableColumn<>("pol");
        TableColumn<Klijent,Boolean> emailKol=new TableColumn<>("email");
        TableColumn<Klijent, String> datumKol=new TableColumn<>("datum");
        TableColumn<Klijent, Integer> bioNaSeansiKol =new TableColumn<>("bioNaSeansi");

        imeKol.setCellValueFactory(new PropertyValueFactory<>("ime"));
        prezimeKol.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        telefonKol.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        polKol.setCellValueFactory(new PropertyValueFactory<>("pol"));
        emailKol.setCellValueFactory(new PropertyValueFactory<>("email"));
        datumKol.setCellValueFactory(new PropertyValueFactory<>("datum"));
        bioNaSeansiKol.setCellValueFactory(new PropertyValueFactory<>("bioNaSeansi"));
        klijentiTableView.getColumns().addAll(imeKol,prezimeKol,telefonKol,polKol,emailKol,datumKol,bioNaSeansiKol);
        klijentiTableView.getItems().addAll(listaKlijenata);

        pregledPlacanja=new Button("Pregled Placanja");

    }
    void addElements(){
        this.setTop(klijentiTableView);
        this.setBottom(pregledPlacanja);

    }

    public void addController(){
        pregledPlacanja.setOnAction(e -> {
            Klijent selektovani = klijentiTableView.getSelectionModel().getSelectedItem();
            if (selektovani != null) {
                new PregledPlacanjaController(selektovani).handle(e);
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
