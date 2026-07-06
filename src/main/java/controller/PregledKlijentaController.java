package controller;

import app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import module.Klijent;
import module.Psihoterapeut;
import util.JDBCUtils;
import view.PregledKlijentaView;
import view.ProfilPsihotarapeutaView;

import java.util.List;

public class PregledKlijentaController implements EventHandler<ActionEvent> {
    private Psihoterapeut psihoterapeut;
    public PregledKlijentaController(Psihoterapeut psihoterapeut) {
        this.psihoterapeut=psihoterapeut;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Scene sc = new Scene(new PregledKlijentaView(JDBCUtils.getKlijente(psihoterapeut.getImePrezime())),800,600);
        App.st.setScene(sc);
        App.st.show();
    }
}
