package GestionPharmacie.JFx.Controlleurs;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Stock {

    private IntegerProperty col_id = new SimpleIntegerProperty();
    private StringProperty col_nom = new SimpleStringProperty();

    private StringProperty col_categ = new SimpleStringProperty();

    private StringProperty col_dateF = new SimpleStringProperty();
    private StringProperty col_dateE = new SimpleStringProperty();

    private StringProperty col_four = new SimpleStringProperty();

    private DoubleProperty col_prix = new SimpleDoubleProperty();
    private DoubleProperty col_mont_cmd = new SimpleDoubleProperty();

    private IntegerProperty col_quant = new SimpleIntegerProperty();
    private IntegerProperty col_quant_max = new SimpleIntegerProperty();
    private IntegerProperty col_quant_min = new SimpleIntegerProperty();
    private IntegerProperty col_quant_a_cmd = new SimpleIntegerProperty();

    private final ObjectProperty<StateCMD> stateCMD = new SimpleObjectProperty<>();
    private ObjectProperty<Timestamp> col_countdown_date = new SimpleObjectProperty<>();

    /*
     * Constructeur Stock
     */

    public Stock(Integer col_id, String col_nom, String col_categ, String col_dateF, String col_dateE, String col_four,
                 Double col_prix, int col_quant) {
        setCol_id(col_id);
        setCol_nom(col_nom);
        setCol_categ(col_categ);
        setCol_dateF(col_dateF);
        setCol_dateE(col_dateE);
        setCol_four(col_four);
        setCol_prix(col_prix);
        setCol_quant(col_quant);

    }

    /*
     * Constructeur Stock / Commande
     */
    public Stock(Integer col_id, String col_nom, Integer col_quant,
                 Integer col_quant_min, Integer col_quant_max, Double col_prix,
                 String col_four, Integer col_quant_a_cmd, Double col_mont_cmd, StateCMD stateCMD,
                 Timestamp col_countdown_date) {

        setCol_id(col_id);
        setCol_nom(col_nom);
        setCol_quant(col_quant);
        setCol_quant_min(col_quant_min);
        setCol_quant_max(col_quant_max);
        setCol_prix(col_prix);
        this.col_four = new SimpleStringProperty(col_four); // ceci == setcol_four(col_four);
        setCol_quant_a_cmd(col_quant_a_cmd);
        setCol_mont_cmd(col_mont_cmd);
        setStateCMD(stateCMD);
        setCol_countdown_date(col_countdown_date);

    }

    /*
     * ****
     * **********************************************************
     *
     * * Enum *
     *
     * **********************************************************
     * ****
     */

    public enum StateCMD {
        Livrer("Commande: Livrer"),
        Valider("Commande: Valider"),
        En_Cours("Commande: En_Cours"),
        En_Attente("Commande: En_Attente"),
        Annuler("Commande: Annuler");

        public String etatCommande;

        private StateCMD(String etatCommande) {
            this.etatCommande = etatCommande;
        }

        private static final String[] etats = new String[] { "Livrer", "Valider", "En_Cours", "En_Attente", "Annuler" };

        public static String toString(StateCMD state) {
            return state.etatCommande;
        }

        public static StateCMD fromString(String etat) {
            etat = etat.replace("Commande: ", "");
            for (int i = 0; i < etats.length; i++) {
                if (etats[i].equals(etat)) {
                    return values()[i];
                }
            }
            throw new IllegalArgumentException("Invalid etat: " + etat);
        }

    }

    /*
     * ****
     * **********************************************************
     *
     * * Getters & Setters *
     *
     * **********************************************************
     * ****
     */

    /**********************************************
     * * état de la commande *
     ************************************************/

    public StateCMD getStateCMD() {
        return stateCMD.get();
    }

    public void setStateCMD(StateCMD stateCMD) {
        this.stateCMD.set(stateCMD);

    }

    public ObjectProperty<StateCMD> StateCMDProperty() {
        return stateCMD;
    }

    /**********************************************
     * * Date de passage de la commande / Compte à rebours *
     ************************************************/

    public Timestamp getCol_countdown_date() {
        return col_countdown_date.get();
    }

    public void setCol_countdown_date(Timestamp col_countdown_date) {
        this.col_countdown_date.set(col_countdown_date);
    }

    public ObjectProperty<Timestamp> col_countdown_dateProperty() {
        return col_countdown_date;
    }

    // public IntegerProperty col_countdown_date_Property() {
    // if (col_countdown_date == null)
    // col_countdown_date = new SimpleObjectProperty(this, "NULL");
    // return col_countdown_date;
    // }

    /**********************************************
     * * ID Médicament *
     ************************************************/

    public Integer getCol_id() {
        return col_id_Property().get();
    }

    public IntegerProperty col_idProperty() {
        return col_id_Property();
    }

    public void setCol_id(Integer col_id) {
        col_id_Property().set(col_id);
    }

    public IntegerProperty col_id_Property() {
        if (col_id == null)
            col_id = new SimpleIntegerProperty(this, "NULL");
        return col_id;
    }

    /*********************************************
     * * Nom Médocament *
     *************************************************/

    public String getCol_nom() {
        return col_nom_Property().get();
    }

    public StringProperty col_nomProperty() {
        return col_nom_Property();
    }

    public void setCol_nom(String col_nom) {
        col_nom_Property().set(col_nom);
    }

    public StringProperty col_nom_Property() {
        if (col_nom == null)
            col_nom = new SimpleStringProperty(this, "NULL");
        return col_nom;
    }

    /*********************************************
     * * catégorie du Médicament *
     *************************************************/

    public String getCol_categ() {
        return col_categ_Property().get();
    }

    public StringProperty col_categProperty() {
        return col_categ_Property();
    }

    public void setCol_categ(String col_categ) {
        col_categ_Property().set(col_categ);
    }

    public StringProperty col_categ_Property() {
        if (col_categ == null)
            col_categ = new SimpleStringProperty(this, "NULL");
        return col_categ;
    }

    /***********************************************
     * * date de fabrication *
     ***********************************************/

    public String getCol_dateF() {
        return col_dateF_Property().get();
    }

    public StringProperty col_dateFProperty() {
        return col_dateF_Property();
    }

    public void setCol_dateF(String col_dateF) {
        col_dateF_Property().set(col_dateF);
    }

    public StringProperty col_dateF_Property() {
        if (col_dateF == null)
            col_dateF = new SimpleStringProperty(this, "NULL");
        return col_dateF;
    }

    /*******************************************
     * * date d'éxpiration *
     ***************************************************/

    public String getCol_dateE() {
        return col_dateE_Property().get();
    }

    public StringProperty col_dateEProperty() {
        return col_dateE_Property();
    }

    public void setCol_dateE(String col_dateE) {
        col_dateE_Property().set(col_dateE);
    }

    public StringProperty col_dateE_Property() {
        if (col_dateE == null)
            col_dateE = new SimpleStringProperty(this, "NULL");
        return col_dateE;
    }

    /*********************************************
     * * fournisseur *
     *************************************************/

    public String getCol_four() {
        return col_four_Property().get();
    }

    public StringProperty col_fourProperty() {
        return col_four_Property();
    }

    public void setCol_four(String col_four) {
        col_four_Property().set(col_four);
    }

    public StringProperty col_four_Property() {
        if (col_four == null)
            col_four = new SimpleStringProperty(this, "NULL");
        return col_four;
    }

    /*****************************************
     * * prix *
     *****************************************/

    public Double getCol_prix() {
        return col_prix_Property().get();
    }

    public DoubleProperty col_prixProperty() {
        return col_prix_Property();
    }

    public void setCol_prix(Double col_prix) {
        col_prix_Property().set(col_prix);
    }

    public DoubleProperty col_prix_Property() {
        if (col_prix == null)
            col_prix = new SimpleDoubleProperty(this, "NULL");
        return col_prix;
    }

    /**********************************************
     * * montant de la commande *
     ************************************************/
    public void setCol_mont_cmd(Double integer) {
        col_mont_cmd_Property().set(integer);
    }

    public Double get_col_mont_cmdProperty() {
        return col_mont_cmd_Property().get();
    }

    public DoubleProperty col_mont_cmdProperty() {
        return col_mont_cmd_Property();
    }

    public DoubleProperty col_mont_cmd_Property() {
        if (col_mont_cmd == null)
            col_mont_cmd = new SimpleDoubleProperty(this, "NULL");
        return col_mont_cmd;
    }

    /*********************************************
     * * quantité en stock *
     *********************************************/

    public Integer getCol_quant() {
        return col_quant_Property().get();
    }

    public IntegerProperty col_quantProperty() {
        return col_quant_Property();
    }

    public void setCol_quant(Integer col_quant) {
        col_quant_Property().set(col_quant);
    }

    public IntegerProperty col_quant_Property() {
        if (col_quant == null)
            col_quant = new SimpleIntegerProperty(this, "NULL");
        return col_quant;
    }

    /*********************************************
     * * quantité max *
     *********************************************/

    public Integer getCol_quant_max() {
        return col_quant_max_Property().get();
    }

    public IntegerProperty col_quant_maxProperty() {
        return col_quant_max_Property();
    }

    public void setCol_quant_max(Integer col_quant_max) {
        col_quant_max_Property().set(col_quant_max);
    }

    public IntegerProperty col_quant_max_Property() {
        if (col_quant_max == null)
            col_quant_max = new SimpleIntegerProperty(this, "NULL");
        return col_quant_max;
    }

    /*********************************************
     * * quantité min *
     *********************************************/
    public Integer getCol_quant_min() {
        return col_quant_min_Property().get();
    }

    public IntegerProperty col_quant_minProperty() {
        return col_quant_min_Property();
    }

    public void setCol_quant_min(Integer col_quant_min) {
        col_quant_min_Property().set(col_quant_min);
    }

    public IntegerProperty col_quant_min_Property() {
        if (col_quant_min == null)
            col_quant_min = new SimpleIntegerProperty(this, "NULL");
        return col_quant_min;
    }

    /*******************************************
     * * quantité de la commande *
     ***************************************************/

    public void setCol_quant_a_cmd(Integer col_quant_a_cmd) {
        col_quant_a_cmd_Property().set(col_quant_a_cmd);
    }

    public Integer get_col_quant_a_cmdProperty() {
        return col_quant_a_cmd_Property().get();
    }

    public IntegerProperty col_quant_a_cmdProperty() {
        return col_quant_a_cmd_Property();
    }

    public IntegerProperty col_quant_a_cmd_Property() {
        if (col_quant_a_cmd == null)
            col_quant_a_cmd = new SimpleIntegerProperty(this, "NULL");
        return col_quant_a_cmd;
    }

}
