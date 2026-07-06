package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import module.Psihoterapeut;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

public class PrikaziPsihotarapeutaController implements EventHandler<ActionEvent> {
    private TableView<Psihoterapeut> tabela=new TableView<>();
    private List<Psihoterapeut> lista=new ArrayList<>();

    public PrikaziPsihotarapeutaController(TableView<Psihoterapeut> tabela) {
        this.tabela = tabela;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        lista=JDBCUtils.selectPsihotarapeute();

        tabela.setItems(FXCollections.observableList(lista));
    }
}
