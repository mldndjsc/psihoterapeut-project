package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import module.Beleska;

public class PregledBeleskeView extends BorderPane {
    private TextArea lbbeleska;
    private Label opis;
    private Beleska beleska;

    public PregledBeleskeView(Beleska beleska) {
        this.beleska = beleska;
        initElements();
        addElements();
    }

    public void initElements() {
        opis = new Label("Beleška:");
        lbbeleska = new TextArea(beleska.getTekst());
    }

    public void addElements() {
        lbbeleska.setWrapText(true);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(opis, lbbeleska);
        vBox.setPadding(new Insets(10));
        this.setCenter(vBox);
    }
}