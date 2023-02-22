package GestionPharmacie.JFx.Controlleurs;

import GestionPharmacie.ConnectionFactory;
import com.gluonhq.charm.glisten.control.DropdownButton;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Notifications;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControlGestionStock implements Initializable {

    @FXML
    private Button ajou;

    @FXML
    private ComboBox categorie;

    @FXML
    private TableColumn<Stock, String> col_categ;

    @FXML
    private TableColumn<Stock, String> col_dateE;

    @FXML
    private TableColumn<Stock, String> col_dateF;

    @FXML
    private TableColumn<Stock, String> col_four;

    @FXML
    private TableColumn<Stock, Integer> col_id;

    @FXML
    private TableColumn<Stock, String> col_nom;

    @FXML
    private TableColumn<Stock, String> col_prix;

    @FXML
    private TableColumn<Stock, String> col_quant;

    @FXML
    private DatePicker date_e;

    @FXML
    private DatePicker date_f;

    @FXML
    private TextField fournisseur;

    @FXML
    private TextField id;

    @FXML
    private Button maj;

    @FXML
    private Button modif;

    @FXML
    private TextField nom;

    @FXML
    private TextField prix;

    @FXML
    private TextField quantite;

    @FXML
    private Button sup;

    @FXML
    private TableView<Stock> table;
    public ObservableList<Stock> selectlist = FXCollections.observableArrayList();

    /*
     *
     * Méthodes
     *
     */



    /**
     * Cette méthode configure le champ numérique pour l'utilisation de
     * l'application.
     *
     * ## Mise en œuvre / ## Implementation
     * Remplace les lettres saisies dans les champs `id` et `quantite` par
     * uniquement des chiffres, si une lettre est détectée. Un message d'erreur est
     * également présenté à l'utilisateur si une lettre est détectée.
     *
     * ## Exemple de code
     * Le code suivant est utilisé pour détecter et remplacer le texte par des
     * chiffres si une lettre est détectée.
     *
     */
    private void setupNbrFild() {
        // id.setText("0");
        id.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                Notifications.create().title("Erreur").text("Veuillez saisir des chiffres").showError();
                // showErrorMessage("Invalid input. Only numbers are allowed.");
                id.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        quantite.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                Notifications.create().title("Erreur").text("Veuillez saisir des chiffres").showError();
                // showErrorMessage("Invalid input. Only numbers are allowed.");
                quantite.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }



    @FXML
    void update(ActionEvent event) throws SQLException {
        updateDate();
        refrechUpdateData();

    }

    @FXML
    void deleteData(ActionEvent event) throws SQLException {
        deleteDataBase();
        refrechDeleteDataMedicament();

    }

    @FXML
    void testConnexion(ActionEvent event) throws SQLException {

        data();
        refrechDataMedicament();
    }

    public void data() throws SQLException {
        if (id.getText().isEmpty() || nom.getText().isEmpty() || categorie.getSelectionModel().getSelectedItem() == null
                || date_f.getValue() == null || date_e.getValue() == null || fournisseur.getText().isEmpty()
                || prix.getText().isEmpty() || quantite.getText().isEmpty()) {
            Notifications.create()
                    .title("ERREUR")
                    .text("Veuillez remplir tous les champs")
                    .showError();
            return;
        }

        Connection conn = ConnectionFactory.getConnection();
        try {
            String query = "INSERT INTO stock(idmedicament,nom,categorie,date_f,date_e,fournisseur,prix,quantite) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id.getText()));
            ps.setString(2, nom.getText());
            ps.setString(3, categorie.getSelectionModel().getSelectedItem().toString());
            ps.setString(4, date_f.getValue().toString());
            ps.setString(5, date_e.getValue().toString());
            ps.setString(6, fournisseur.getText());
            ps.setDouble(7, Double.parseDouble(prix.getText()));
            ps.setInt(8, Integer.parseInt(quantite.getText()));
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

        id.setText(null);
        nom.setText(null);
        // categorie.setSelectionModel(null);
        date_f.setValue(null);
        date_e.setValue(null);
        fournisseur.setText(null);
        prix.setText(null);
        quantite.setText(null);
    }


    public void dataMedicament() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        try {
            String query = "SELECT idmedicament,nom,categorie,date_f,date_e,fournisseur,prix,quantite FROM stock ";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                selectlist.add(new Stock(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8)));
            }
            conn.close();

        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    public void deleteDataBase() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        try {
            String query = "DELETE FROM stock WHERE idmedicament= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id.getText()));
            ps.executeUpdate();
            conn.close();
            Notifications.create()
                    .title("INFORMATION").text("Information suprimer").threshold(3, Notifications.create()
                            .title("Collapsed Notification"))
                    .showWarning();

        } catch (Exception e) {
            System.out.println("error" + e);
        }

        id.setText(null);
        nom.setText(null);
        // categorie.setSelectionModel(null);
        date_f.setValue(null);
        date_e.setValue(null);
        fournisseur.setText(null);
        prix.setText(null);
        quantite.setText(null);
    }

    public void updateDate() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        try {
            String query = "UPDATE stock SET nom=?, date_f=?,date_e=?,fournisseur=?,prix=?,quantite =? WHERE idmedicament = ?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, nom.getText());
            ps.setString(2, date_f.getValue().toString());
            ps.setString(3, date_e.getValue().toString());
            ps.setString(4, fournisseur.getText());
            ps.setDouble(5, Double.parseDouble(prix.getText()));
            ps.setInt(6, Integer.parseInt(quantite.getText()));
            ps.setInt(7, Integer.parseInt(id.getText()));
            ps.executeUpdate();
            conn.close();
            Notifications.create()
                    .title("INFORMATION").text("Information a bien ete mise a jour").threshold(3, Notifications.create()
                            .title("Collapsed Notification"))
                    .showWarning();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        id.setText(null);
        nom.setText(null);
        // categorie.setSelectionModel(null);
        date_f.setValue(null);
        date_e.setValue(null);
        fournisseur.setText(null);
        prix.setText(null);
        quantite.setText(null);
    }

    public void refrechDataMedicament() throws SQLException {
        selectlist.clear();

        dataMedicament();

    }

    public void refrechDeleteDataMedicament() throws SQLException {
        selectlist.clear();
        dataMedicament();

    }

    public void refrechUpdateData() throws SQLException {
        selectlist.clear();
        dataMedicament();

    }

    private void selectDataTable() {
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stock pl = table.getItems().get(table.getSelectionModel().getSelectedIndex());
                id.setText(pl.getCol_id().toString());
                nom.setText(pl.getCol_nom());
                // categorie.setSelectionModel(pl.getCol_categ().toString());
                date_f.setValue(LocalDate.parse(pl.getCol_dateF().toString()));
                date_e.setValue(LocalDate.parse(pl.getCol_dateE().toString()));
                fournisseur.setText(pl.getCol_four());
                prix.setText(pl.getCol_prix().toString());
                quantite.setText(pl.getCol_quant().toString());
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            dataMedicament();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        selectDataTable();
        setupNbrFild();

        ObservableList<String> list = FXCollections.observableArrayList("Médicaments génériques",
                "Médicaments homéopathiques", "Médicaments stupéfiants", "Médicaments dérivés du sang",
                "Contraceptifs");
        categorie.setItems(list);

        col_id.setCellValueFactory(new PropertyValueFactory<Stock, Integer>("col_id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Stock, String>("col_nom"));
        col_categ.setCellValueFactory(new PropertyValueFactory<Stock, String>("col_categ"));
        col_dateF.setCellValueFactory(new PropertyValueFactory<Stock, String>("col_dateF"));
        col_dateE.setCellValueFactory(new PropertyValueFactory<Stock, String>("col_dateE"));
        col_four.setCellValueFactory(new PropertyValueFactory<Stock, String>("col_four"));
        col_prix.setCellValueFactory(new PropertyValueFactory<Stock, String>("col_prix"));
        col_quant.setCellValueFactory(new PropertyValueFactory<Stock, String>("col_quant"));
        table.setItems(selectlist);

    }

}
