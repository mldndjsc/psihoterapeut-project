package controller;

import app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import module.Psihoterapeut;
import view.ProfilPsihotarapeutaView;
import view.SignUpView;

public class ProfilPsihotarapeutaController implements EventHandler<ActionEvent> {
    private Psihoterapeut psihoterapeut;

    public ProfilPsihotarapeutaController(Psihoterapeut psihoterapeut) {
        this.psihoterapeut = psihoterapeut;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Scene sc = new Scene(new ProfilPsihotarapeutaView(psihoterapeut),800,600);
        App.st.setScene(sc);
        App.st.show();
    }


}
