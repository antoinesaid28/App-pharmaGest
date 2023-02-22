package GestionPharmacie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

// import GestionPharmacie.QueryStatement;
// import GestionPharmacie.Pharmacien;

public class DBUtil {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet = null;
	private static List<Pharmacien> pharmacienList = new ArrayList<Pharmacien>();

	public static void addPharmacien(Pharmacien pharmacien) throws SQLException {
		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(QueryStatement.ADD_PHARMACIEN_QUERY);

		/// String
		setPreparedStatementProperties(
				// pharmacien.idPharmacien.toString(),
				pharmacien.getNom(),
				pharmacien.getPrenom(),
				pharmacien.getFonction(),
				pharmacien.getAdresse(),
				pharmacien.getTelephone(),
				pharmacien.getMail(),
				pharmacien.getPassword());

		preparedStatement.executeUpdate();

		closeConnections();
	}

	public static void updatePharmacien(Pharmacien pharmacien) throws SQLException {
		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(QueryStatement.UPDATE_PHARMACIEN_QUERY);
		// pharmacien.toString()
		setPreparedStatementProperties(
				// pharmacien.idPharmacien.toString(),
				pharmacien.getNom(),
				pharmacien.getPrenom(),
				pharmacien.getFonction(),
				pharmacien.getAdresse(),
				pharmacien.getTelephone(),
				pharmacien.getMail(),
				pharmacien.getPassword());
		preparedStatement.executeUpdate();

		closeConnections();
	}

	public static void deletePharmacien(Pharmacien pharmacien) throws SQLException {
		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(QueryStatement.DELETE_PHARMACIEN_QUERY);

		setPreparedStatementProperties(pharmacien.idPharmacien.toString());
		preparedStatement.executeUpdate();

		closeConnections();
	}

	public static List<Pharmacien> getAllPharmacien() throws SQLException {
		connection = ConnectionFactory.getConnection();
		preparedStatement = connection.prepareStatement(QueryStatement.SELECT_ALL_PHARMACIEN_QUERY);

		resultSet = preparedStatement.executeQuery();

		pharmacienList.clear();

		while (resultSet.next()) {
			Pharmacien pharmacien = new Pharmacien();
			pharmacien.setNom(resultSet.getString(1));
			pharmacien.setPrenom(resultSet.getString(2));
			pharmacien.setFonction(resultSet.getString(3));
			pharmacien.setAdresse(resultSet.getString(4));
			pharmacien.setTelephone(resultSet.getString(5));
			pharmacien.setMail(resultSet.getString(6));
			pharmacien.setPassword(resultSet.getString(7));
			pharmacien.setIdPharmacien(resultSet.getInt(8));
			pharmacienList.add(pharmacien);
		}

		return pharmacienList;
	}

	private static void closeConnections() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

	// @param variable length array of strings as pharmacien properties
	private static void setPreparedStatementProperties(String... Args) throws SQLException {
		for (int i = 0; i < Args.length; i++) {
			preparedStatement.setString(i + 1, Args[i]);
		}
	}
}
