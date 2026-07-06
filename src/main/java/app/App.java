package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.JDBCUtils;
import view.MainView;

public class App extends Application {

    public static Stage st = new Stage();
    public static Stage loginStage = new Stage();
    @Override
    public void start(Stage stage) throws Exception {
        JDBCUtils.connect();
        Scene sc = new Scene(new MainView(),800,600);
        st.setTitle("Savetovaliste Novi Pocetak");
        st.setScene(sc);
        st.show();
    }
}
