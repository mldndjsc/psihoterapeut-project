package controller;

import app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import module.Klijent;
import util.JDBCUtils;
import view.PregledKlijentaView;
import view.PregledPlacanjaView;

public class PregledPlacanjaController implements EventHandler<ActionEvent> {
    private Klijent klijent;

    public PregledPlacanjaController(Klijent klijent) {
        this.klijent = klijent;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Scene sc = new Scene(new PregledPlacanjaView(JDBCUtils.getPlacanja(klijent.getKlijentId())),800,600);
        App.st.setScene(sc);
        App.st.show();
    }
}
