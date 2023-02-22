package GestionPharmacie.JFx.Controlleurs;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class fournisseur {
    private StringProperty col_id = new SimpleStringProperty();

    private StringProperty col_nomEntreprise = new SimpleStringProperty();

    private StringProperty col_adresse = new SimpleStringProperty();
    private StringProperty col_mail = new SimpleStringProperty();

    private StringProperty col_telephone = new SimpleStringProperty();

    /***********************************************
     * * contstructor*
     ***********************************************/


    public fournisseur(String col_id, String col_nomEntreprise, String col_adresse, String col_mail, String col_telephone) {
        setCol_id(col_id);
        setCol_nomEntreprise(col_nomEntreprise);
        setCol_adresse(col_adresse);
        setCol_mail(col_mail);
        setCol_telephone(col_telephone);

    }


    /***********************************************
     * * id fournisseur *
     ***********************************************/
    public String getCol_id() {
        return col_id_Property().get();
    }

    public StringProperty col_idProperty() {
        return col_id_Property();
    }
    public void setCol_id(String col_id) {

        col_id_Property().set(col_id);
    }


    public StringProperty col_id_Property() {
        if (col_id == null)
            col_id = new SimpleStringProperty(this, "NULL");
        return col_id;
    }

    /***********************************************
     * * nom Entreprise *
     ***********************************************/

    public String getCol_nomEntreprise() {
        return col_nomEntreprise_Property().get();
    }

    public StringProperty col_nomEntrepriseProperty() {
        return col_nomEntreprise_Property();
    }

    public void setCol_nomEntreprise(String col_nomEntreprise) {

        col_id_Property().set(col_nomEntreprise);
    }

    public StringProperty col_nomEntreprise_Property() {
        if (col_nomEntreprise == null)
            col_nomEntreprise = new SimpleStringProperty(this, "NULL");
        return col_nomEntreprise;
    }

    /***********************************************
     * * adresse *
     ***********************************************/

    public String getCol_adresse() {
        return col_adresse_Property().get();
    }

    public StringProperty col_adresseProperty() {
        return col_adresse_Property();
    }
    public void setCol_adresse(String col_adresse) {

        col_adresse_Property().set(col_adresse);
    }
    public StringProperty col_adresse_Property() {
        if (col_adresse == null)
            col_adresse = new SimpleStringProperty(this, "NULL");
        return col_adresse;
    }
    /***********************************************
     * * mail *
     ***********************************************/

    public String getCol_mail() {
        return col_mail_Property().get();
    }

    public StringProperty col_mailProperty() {
        return col_mail_Property();
    }
    public void setCol_mail(String col_mail) {

        col_mail_Property().set(col_mail);
    }

    public StringProperty col_mail_Property() {
        if (col_mail == null)
            col_mail = new SimpleStringProperty(this, "NULL");
        return col_mail;
    }

    /***********************************************
     * * telephone *
     ***********************************************/

    public String getCol_telephone() {
        return col_telephone_Property().get();
    }

    public StringProperty col_telephoneProperty() {
        return col_telephone_Property();
    }

    public void setCol_telephone(String col_telephone) {

        col_telephone_Property().set(col_telephone);
    }

    public StringProperty col_telephone_Property() {
        if (col_telephone == null)
            col_telephone = new SimpleStringProperty(this, "NULL");
        return col_telephone;
    }


}
