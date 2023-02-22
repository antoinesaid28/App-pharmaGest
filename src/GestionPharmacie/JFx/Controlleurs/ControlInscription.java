package GestionPharmacie.JFx.Controlleurs;

import GestionPharmacie.ConnectionFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControlInscription implements Initializable {

    @FXML
    private TextField adresse;

    @FXML
    private DatePicker date_N;

    @FXML
    private ComboBox fonction;

    @FXML
    private ComboBox genre;

    @FXML
    private TextField id;

    @FXML
    private TextField mail;

    @FXML
    private TextField nom;

    @FXML
    private PasswordField password;

    @FXML
    private TextField prenom;

    @FXML
    private Button save;

    @FXML
    private Button supprimer;

    @FXML
    private TextField telephone;

    @FXML
    void save(ActionEvent event) throws SQLException {
        dataInscription();

    }

    @FXML
    void supprimer(ActionEvent event) {

    }

    public void dataInscription() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        try {
            String query = "INSERT INTO pharmacien(idpharmacien,nom,prenom,genre,fonction,telephone,mail,password,adresse,date_de_naissance) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id.getText()));
            ps.setString(2, nom.getText());
            ps.setString(3, prenom.getText());
            ps.setString(4, genre.getSelectionModel().getSelectedItem().toString());
            ps.setString(5, fonction.getSelectionModel().getSelectedItem().toString());
            ps.setString(6, telephone.getText());
            ps.setString(7, mail.getText());
            ps.setString(8, password.getText());
            ps.setString(9, adresse.getText());
            ps.setString(10, date_N.getValue().toString());
            ps.execute();
            System.out.println("reussi");
            Notifications.create()
                    .title("INFORMATION")
                    .text("Information ajouté")
                    .threshold(3, Notifications.create().title("Collapsed Notification"))
                    .showWarning();
        } catch (Exception e) {
            System.out.println("error" + e);
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("Médicaments génériques",
                "Médicaments homéopathiques", "Médicaments stupéfiants", "Médicaments dérivés du sang",
                "Contraceptifs");
        fonction.setItems(list);

        ObservableList<String> liste = FXCollections.observableArrayList("Homme",
                "Femme");
        genre.setItems(liste);
    }
}
