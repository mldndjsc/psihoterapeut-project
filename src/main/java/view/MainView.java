package view;



import com.sun.jdi.PrimitiveValue;
import controller.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import module.CentarZaObuku;
import module.Psihoterapeut;


import java.time.LocalDate;

public class MainView extends BorderPane {

   private TableView<Psihoterapeut> psihoterapeutTableView;
   private Button registracijaPsihoterapeuta;
   private  Button prijavaPsihoterapeuta;
   private Button pregledPsihoterapeuta;


    public MainView() {
        initElements();
        setElements();
        addController();
    }

    private void initElements(){
        psihoterapeutTableView = new TableView<>();
        TableColumn<Psihoterapeut,String> ime=new TableColumn<>("ime i prezime");
        TableColumn<Psihoterapeut,String> mail=new TableColumn<>("email");
        TableColumn<Psihoterapeut,String> telefon=new TableColumn<>("telefon");
        TableColumn<Psihoterapeut,String> struka=new TableColumn<>("struka");
        TableColumn<Psihoterapeut,Boolean> supervizor=new TableColumn<>("supervizor");
        TableColumn<Psihoterapeut, String> centarZaObuku=new TableColumn<>("centar za obuku");



        ime.setCellValueFactory(new PropertyValueFactory<>("imePrezime"));
        mail.setCellValueFactory(new PropertyValueFactory<>("email"));
        telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        struka.setCellValueFactory(new PropertyValueFactory<>("struka"));
        supervizor.setCellValueFactory(new PropertyValueFactory<>("supervizor"));
        centarZaObuku.setCellValueFactory(new PropertyValueFactory<>("centarZaObuku"));
        psihoterapeutTableView.getColumns().addAll(ime,mail,telefon,struka,supervizor,centarZaObuku);

        registracijaPsihoterapeuta = new Button("Sign up");
        prijavaPsihoterapeuta = new Button("Log in");
        pregledPsihoterapeuta = new Button("Pregled psihoterapeuta");

    }

    private void setElements(){
        VBox vBox = new VBox();
        VBox vBox2=new VBox();
        VBox vBox3=new VBox();
        VBox vBox4=new VBox();
        HBox hbox=new HBox();
        vBox2.getChildren().addAll(registracijaPsihoterapeuta,prijavaPsihoterapeuta);
        vBox3.getChildren().add(pregledPsihoterapeuta);

        vBox2.setPadding(new Insets(10));
        vBox3.setPadding(new Insets(10));
        vBox4.setPadding(new Insets(10));

        hbox.getChildren().addAll(vBox2,vBox3,vBox4);


        vBox.getChildren().addAll(psihoterapeutTableView,hbox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));
        this.setCenter(vBox);
        this.setPadding(new Insets(10));
    }
    private void addController(){
        pregledPsihoterapeuta.setOnAction(new PrikaziPsihotarapeutaController(psihoterapeutTableView));
        registracijaPsihoterapeuta.setOnAction(new SignUpController());
        prijavaPsihoterapeuta.setOnAction(new LogInSceneController());

    }
}
