package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import module.Struka;
import util.JDBCUtils;

public class SignUpPsihoterapeutController implements EventHandler<ActionEvent> {
    private TextField imePrezime;
    private TextField email;
    private TextField telefon;
    private ComboBox<Struka> strukaComboBox;
    private CheckBox supervizor;
    private  ComboBox<String> centri;

    public SignUpPsihoterapeutController(TextField imePrezime, TextField email, TextField telefon, ComboBox<Struka> strukaComboBox, CheckBox supervizor, ComboBox<String> centri) {
        this.imePrezime = imePrezime;
        this.email = email;
        this.telefon = telefon;
        this.strukaComboBox = strukaComboBox;
        this.supervizor = supervizor;
        this.centri = centri;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int sup = 0;
        if(supervizor.isSelected())
            sup = 1;
        JDBCUtils.insertIntoPsihoterapeut(imePrezime.getText(),email.getText(),telefon.getText(), Struka.valueOf(strukaComboBox.getValue().toString()),sup,strukaComboBox.getValue().ordinal());
    }
}
