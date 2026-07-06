package controller;

import app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.JDBCUtils;
import view.MainView;
import view.PsihoterapeutView;
import view.SignUpView;

public class LogInPsihoterapeutController implements EventHandler<ActionEvent> {
    private TextField email;

    public LogInPsihoterapeutController(TextField email) {
        this.email = email;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(JDBCUtils.doesContainPsihoterapeut(email.getText()) != null){
            Scene sc = new Scene(new PsihoterapeutView(JDBCUtils.doesContainPsihoterapeut(email.getText())),800,600);
            App.loginStage.setScene(sc);
            App.loginStage.show();
            App.st.setScene(new Scene(new MainView(),800,600));
            App.st.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greška");
            alert.setHeaderText("Došlo je do greške");
            alert.setContentText("Uneti email nepostoji u nasoj bazi podataka morate se registrovati");
            alert.showAndWait();
        }
    }
}
