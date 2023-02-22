package GestionPharmacie;

public class QueryStatement {

	public final static String ADD_PHARMACIEN_QUERY = "INSERT INTO pharmacien( nom,  prenom,  fonction,  adresse, telephone, mail,  mot_de_passe) VALUES(? ,? ,? ,? ,? ,? ,? )"; // idpharmacien

	public final static String UPDATE_PHARMACIEN_QUERY = "UPDATE pharmacien SET nom=?, prenom=?, fonction=?, adresse=?,telephone=?,mail=?, mot_de_passe=? where idPharmacien=?"; // idPharmacien=?,

	public final static String DELETE_PHARMACIEN_QUERY = "DELETE FROM pharmacien WHERE idPharmacien=?";

	public final static String SELECT_ALL_PHARMACIEN_QUERY = "SELECT * FROM pharmacien";

}
