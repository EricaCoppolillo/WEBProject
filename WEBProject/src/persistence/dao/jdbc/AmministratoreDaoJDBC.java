package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Amministratore;
import persistence.DataSource;
import persistence.dao.AmministratoreDao;

public class AmministratoreDaoJDBC implements AmministratoreDao {

	private DataSource dataSource;
	private Connection connection;
	
	public AmministratoreDaoJDBC(DataSource dataS) {
		dataSource = dataS;
		connection = null;
	}
	
	@Override
	public Amministratore findAdmin(String id, String password) {
		Amministratore amministratore = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from \"Amministratore\" where id = ? and password = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				amministratore = new Amministratore(result.getString(1), result.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return amministratore;
	}

	@Override
	public ArrayList<Amministratore> findAll() {
		ArrayList<Amministratore> amministratori = new ArrayList<Amministratore>();
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from amministratore";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Amministratore admin = new Amministratore(result.getString(0), result.getString(1));
				amministratori.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return amministratori;
	}

}
