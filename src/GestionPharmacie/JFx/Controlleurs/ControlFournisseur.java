package GestionPharmacie.JFx.Controlleurs;



import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlFournisseur implements Initializable {

    @FXML
    private Label adresse;

    @FXML
    private Button ajou_f;

    @FXML
    private Label detail;

    @FXML
    private Label name;

    @FXML
    private TableView<fournisseur> table;

    @FXML
    private Label type;


public void setupTable(){

    TableColumn<fournisseur, String> id = new TableColumn<fournisseur, String>("ID Fournisseur");
    TableColumn<fournisseur, String> nomEntreprise = new TableColumn<fournisseur, String>("Nom de L'entreprise");
    TableColumn<fournisseur, String> adresse = new TableColumn<fournisseur, String>("Adresse");
    TableColumn<fournisseur, String> mail= new TableColumn<fournisseur, String>("Mail");
    TableColumn<fournisseur, String> telephone= new TableColumn<fournisseur, String>("Telephone");


    id.setCellValueFactory(new PropertyValueFactory<fournisseur, String>("col_id"));
    nomEntreprise.setCellValueFactory(new PropertyValueFactory<fournisseur, String>("col_nomEntreprise"));
    adresse.setCellValueFactory(new PropertyValueFactory<fournisseur, String>("col_adresse"));
    mail.setCellValueFactory(new PropertyValueFactory<fournisseur, String>("col_mail"));
    telephone.setCellValueFactory(new PropertyValueFactory<fournisseur, String>("col_telephone"));

    table.getColumns().setAll(id,nomEntreprise,adresse,mail,telephone);
}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setupTable();

    }
}