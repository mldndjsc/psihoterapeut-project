package controller;

import app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import module.Psihoterapeut;
import module.Seansa;
import util.JDBCUtils;
import view.PregledSeansiView;
import view.ProfilPsihotarapeutaView;

import java.util.List;

public class PregledSeansiController implements EventHandler<ActionEvent> {

    private Psihoterapeut psihoterapeut;

    public PregledSeansiController(Psihoterapeut psihoterapeut) {
        this.psihoterapeut = psihoterapeut;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        List<Seansa> seanse = JDBCUtils.selectSeanseWherePsihoterapeut(psihoterapeut.getImePrezime());
        Scene sc = new Scene(new PregledSeansiView(psihoterapeut,seanse),800,600);
        App.st.setScene(sc);
        App.st.show();
    }
}
