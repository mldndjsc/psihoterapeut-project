package controller;

import app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import view.LogInView;
import view.MainView;
import view.SignUpView;

public class LogInSceneController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Scene sc = new Scene(new LogInView(),800,600);
        Scene scena = new Scene(new MainView(),800,600);
        App.st.setScene(scena);
        App.st.show();
        App.loginStage.setScene(sc);
        App.loginStage.show();
    }
}
