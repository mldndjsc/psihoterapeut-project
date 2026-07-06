package controller;

import app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import view.SignUpView;

public class SignUpController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Scene sc = new Scene(new SignUpView(),800,600);
        App.st.setScene(sc);
        App.st.show();
    }
}
