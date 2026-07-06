package view;

import controller.PregledBeleskeController;
import controller.ProfilPsihotarapeutaController;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import module.Psihoterapeut;
import module.Seansa;
import util.JDBCUtils;

import java.util.List;

public class PregledSeansiView extends BorderPane {
    private TableView<Seansa> seansaTableView;
    private Button pregledBeleske;
    private Psihoterapeut psihoterapeut;
    private List<Seansa> seanse;

    public PregledSeansiView(Psihoterapeut psihoterapeut, List<Seansa> seanse) {
        this.psihoterapeut = psihoterapeut;
        this.seanse = seanse;
        initElements();
        addElements();
        addController();
    }

    public void initElements(){
        pregledBeleske = new Button("Pregled seanse");
        seansaTableView=new TableView<>();
        TableColumn<Seansa,String> vremeCol=new TableColumn<>("vreme");
        TableColumn<Seansa,String> danCol=new TableColumn<>("dan");
        TableColumn<Seansa,Integer> trajanjeCol=new TableColumn<>("trajanje");
        TableColumn<Seansa,String> datumPromeneCeneCol=new TableColumn<>("datumPromeneCene");
        TableColumn<Seansa,String> klijentCol=new TableColumn<>("klijent");

        vremeCol.setCellValueFactory(new PropertyValueFactory<>("vreme"));
        danCol.setCellValueFactory(new PropertyValueFactory<>("dan"));
        trajanjeCol.setCellValueFactory(new PropertyValueFactory<>("trajanje"));
        datumPromeneCeneCol.setCellValueFactory(new PropertyValueFactory<>("datumPromeneCene"));
        klijentCol.setCellValueFactory(new PropertyValueFactory<>("klijent"));

        seansaTableView.getColumns().addAll(vremeCol,danCol,trajanjeCol,datumPromeneCeneCol,klijentCol);
        seansaTableView.getItems().addAll(seanse);
    }

    public void addElements(){
        VBox vBox=new VBox();
        vBox.getChildren().addAll(seansaTableView,pregledBeleske);
        vBox.setPadding(new Insets(20));
        this.setPadding(new Insets(20));
        this.setCenter(vBox);

    }

    public void addController(){
        pregledBeleske.setOnAction(e -> {
            Seansa selektovani =seansaTableView.getSelectionModel().getSelectedItem();
            if (selektovani != null) {
                new PregledBeleskeController(JDBCUtils.getBeleskaZaSeansu(selektovani.getIdSeanse())).handle(e);
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
