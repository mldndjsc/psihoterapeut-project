package util;

import module.*;

import javax.xml.transform.Result;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {

    public static Connection connection = null;

    public static void connect() {
        Properties properties = new Properties();
        properties.put("user", "root");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/novi_pocetak_mladendjosicsi91-24_matejlalicsi113-24", properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private JDBCUtils() {

    }

    public static List<Psihoterapeut> selectPsihotarapeute(){
        List<Psihoterapeut> listaPsiha=new ArrayList<>();
        String query = "SELECT * from `psihoterapeut`";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                String imeiPrezime=resultSet.getString(2);
                String email=resultSet.getString(3);
                String telefon=resultSet.getString(4);
                String struka=resultSet.getString(5);
                String supervizor=resultSet.getString(6);
                boolean superViz=false;
                if(supervizor==null){
                    superViz=false;
                } else if (supervizor.equalsIgnoreCase("1")) {
                    superViz=true;
                }
                String centarZaObuku=resultSet.getString(7);
                Psihoterapeut psihoterapeut=new Psihoterapeut(imeiPrezime,email,telefon,struka,superViz,centarZaObuku);
                listaPsiha.add(psihoterapeut);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPsiha;
    }
    public static List<String> selectCentreZaObuku(){
        List<String> listaCentara=new ArrayList<>();
        String query = "SELECT * from `centar_za_obuku`";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                String id=resultSet.getString(1);
                String naziv=resultSet.getString(2);
                String rez = id + naziv;
                listaCentara.add(rez);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCentara;
    }
    public static void insertIntoPsihoterapeut(String nameSurname, String email, String telefon, Struka struka,int supervizor,int centarZaObuku){

        String query = "INSERT INTO `psihoterapeut` (Ime_prezime, email, telefon, struka, supervizor,Centar_za_obuku) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            preparedStatement.setString(1,nameSurname);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,telefon);
            preparedStatement.setString(4,struka.toString());
            if(supervizor == 1){
                preparedStatement.setInt(5,supervizor);
            }
            preparedStatement.setInt(6,centarZaObuku);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Psihoterapeut doesContainPsihoterapeut(String email) {
        String query = "SELECT * FROM `psihoterapeut` WHERE email = ? LIMIT 1";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {

                    String ime = resultSet.getString(2);
                    String telefon = resultSet.getString(4);
                    String struka = resultSet.getString(5);
                    int supervizor = resultSet.getInt(6);
                    String centarZaObuku = resultSet.getString(7);
                    boolean sup = false;
                    if(supervizor == 1){
                        sup = true;
                    }


                    return new Psihoterapeut(ime,email,telefon,struka,sup,centarZaObuku);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
    }

    public static List<Seansa> selectSeanseWherePsihoterapeut(String psihoterapeutName){
        List<Seansa> seanse = new ArrayList<>();
        String query = "SELECT * FROM seansa " +
                "JOIN psihoterapeut ON seansa.Psihoterapeut_id = psihoterapeut.psihoterapeut_id " +
                "WHERE psihoterapeut.ime_prezime = ?";


        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, psihoterapeutName);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                String vreme = resultSet.getString(2);
                String dan = resultSet.getString(3);
                int trajanje = resultSet.getInt(4);
                String datumPromeneCene = resultSet.getString(5);
                String klijentIme = resultSet.getString(8);

                Seansa seansa = new Seansa(id,vreme, dan, trajanje, datumPromeneCene, klijentIme);
                seanse.add(seansa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return seanse;
    }

    public static Beleska getBeleskaZaSeansu(int seansaId) {
        String query = "SELECT * FROM beleske " +
                "JOIN seansa ON beleske.seansa_id = seansa.seansa_id " +
                "WHERE seansa.seansa_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, seansaId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String tekst = resultSet.getString(2);
                    String izdato=resultSet.getString(3);

                    return new Beleska(tekst,izdato);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static List<Klijent> getKlijente(String psihoterapeutName){
        List<Klijent> klijenti = new ArrayList<>();
        String query = "SELECT * FROM klijent k JOIN seansa s ON k.klijent_id = s.Klijent_id JOIN psihoterapeut p ON s.Psihoterapeut_id = p.psihoterapeut_id WHERE p.Ime_prezime = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, psihoterapeutName);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                String ime = resultSet.getString(2);
                String prezime = resultSet.getString(3);
                String telefon = resultSet.getString(4);
                String email = resultSet.getString(5);
                String pol = resultSet.getString(6);
                String datum=resultSet.getString(7);
                String bioNaSeansi=resultSet.getString(8);
                int bio=1;
                if(bioNaSeansi==null){
                    bio=0;
                }

                Klijent klijent = new Klijent(id,ime,prezime,telefon,pol,email,datum,bio);
                klijenti.add(klijent);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return klijenti;
    }

    public static List<Placanje> getPlacanja(int klijent_id){
        List<Placanje> placanja = new ArrayList<>();
        String query = "SELECT * FROM placanje WHERE Klijent_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, klijent_id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                String svrha=resultSet.getString(2);
                String nacin=resultSet.getString(3);
                int iznos=resultSet.getInt(4);

                Placanje placanje = new Placanje(id,svrha,nacin,iznos);
                placanja.add(placanje);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return placanja;
    }



}
