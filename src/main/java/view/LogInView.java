package view;

import controller.LogInPsihoterapeutController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LogInView extends VBox {
    private TextField email;
    private PasswordField password;
    private Button logIn;

    public LogInView() {
        initElements();
        setElements();
        addController();
    }

    private void addController() {
        logIn.setOnAction(new LogInPsihoterapeutController(email));
    }

    private void setElements() {

        email.setPromptText("Unesite email");
        password.setPromptText("Unesite lozinku");
        this.getChildren().addAll(email,password,logIn);
        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
    }

    private void initElements() {
        email = new TextField();
        password = new PasswordField();
        logIn = new Button("Log In");

    }
}
