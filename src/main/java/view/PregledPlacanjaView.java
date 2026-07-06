package view;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import module.Klijent;
import module.Placanje;

import java.util.List;

public class PregledPlacanjaView extends BorderPane {
    private List<Placanje> placanja;
    private TableView<Placanje> placanjeTableView;
    public PregledPlacanjaView(List<Placanje> placanja) {
        this.placanja=placanja;
        initElements();
        addElements();
    }
    public void initElements(){
        placanjeTableView=new TableView<>();
        TableColumn<Placanje,String> svrhaPlacanjaKol=new TableColumn<>("svrha");
        TableColumn<Placanje,String> nacinPlacanjaKol=new TableColumn<>("nacinPlacanja");
        TableColumn<Placanje,Integer> iznosKol=new TableColumn<>("iznos");

        svrhaPlacanjaKol.setCellValueFactory(new PropertyValueFactory<>("svrha"));
        nacinPlacanjaKol.setCellValueFactory(new PropertyValueFactory<>("nacinPlacanja"));
        iznosKol.setCellValueFactory(new PropertyValueFactory<>("iznos"));
        placanjeTableView.getColumns().addAll(svrhaPlacanjaKol,nacinPlacanjaKol,iznosKol);
        placanjeTableView.getItems().addAll(placanja);

    }

    public void addElements(){
        this.setTop(placanjeTableView);

    }
}
