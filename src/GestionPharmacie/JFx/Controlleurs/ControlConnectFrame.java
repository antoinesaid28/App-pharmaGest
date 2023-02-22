package GestionPharmacie.JFx.Controlleurs;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;

import GestionPharmacie.ConnectionFactory;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControlConnectFrame implements Initializable {

    @FXML
    private AnchorPane connectPane;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private JFXButton validateBtn;

    String log, pswd;

    /**
     * @param event
     * @throws SQLException
     */
    @FXML
    void verif_Id(ActionEvent event) throws SQLException {

        log = login.getText();

        pswd = password.getText();

        Connection conn = ConnectionFactory.getConnection();
        String query = "SELECT * FROM Pharmacien WHERE mail =? and mot_de_passe =?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, log);
        pst.setString(2, pswd);
        ResultSet rst = pst.executeQuery();

        if (rst.next() == true) {

            System.out.println("Connexion okay");

            Notifications.create()
                    .title("INFORMATION")
                    .text("Connexion établie")
                    .threshold(3, Notifications.create().title("Collapsed Notification"))
                    .showWarning();

        } else {

            Notifications.create()
                    .darkStyle()
                    .title("Error")
                    .text("Connexion Echoué: Verifiez vos identifiants")
                    .showWarning();

        }
        // Bienvenu com = new Bienvenu();
        // com.setVisible(true);
        // dispose();
        // JOptionPane.showMessageDialog(btnNewButton, " connexion reussi avec succer");

        // } else {

        // System.out.println("Connexion Failled");
        // JOptionPane.showMessageDialog(btnNewButton, " Identifient ou Mot de passe
        // Invalid");

        // }

    }

    private void transitionToRegister() {

        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(connectPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                loadPrecentScene();

            }

            private void loadPrecentScene() {
                try {
                    Parent firstView;
                    firstView = FXMLLoader.load(getClass().getResource("../../RegisterFrame.fxml"));
                    // secondView = (StackPane)
                    // FXMLLoader.load(getClass().getResource("../../ConnectFrame.fxml"));

                    Scene newScene = new Scene(firstView);

                    Stage currentStage = (Stage) connectPane.getScene().getWindow();
                    currentStage.setScene(newScene);

                } catch (IOException e) {

                    e.printStackTrace();
                }
            }

        });

        fadeTransition.play();
    }

    @FXML
    void goToRegister(ActionEvent event) {
        connectPane.setOpacity(0);
        transitionToRegister();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}