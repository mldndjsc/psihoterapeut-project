package controller;

import app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import module.Beleska;
import util.JDBCUtils;
import view.PregledBeleskeView;
import view.PregledSeansiView;

public class PregledBeleskeController implements EventHandler<ActionEvent> {
    private Beleska beleska;

    public PregledBeleskeController(Beleska beleska) {
        this.beleska = beleska;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Scene scene=new Scene(new PregledBeleskeView(beleska),800,600);
        App.st.setScene(scene);
        App.st.show();
    }
}
