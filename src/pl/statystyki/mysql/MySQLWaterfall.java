package pl.statystyki.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.md_5.bungee.config.Configuration;
import pl.statystyki.shared.config.ConfigWaterfall;

public class MySQLWaterfall {
	
	Configuration config = ConfigWaterfall.loadConfig();
	private String HOST = config.getString("host");
	private String DATABASE = config.getString("database");
	private String USER = config.getString("user");
	private String PASSWORD = config.getString("password");
	private Connection con;
	
	public MySQLWaterfall(String host, String database, String user, String password) {
		this.HOST = host;
		this.DATABASE = database;
		this.USER = user;
		this.PASSWORD = password;
		connect();
	}

	public void connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":3306/" + DATABASE + "?autoReconnect=true", USER, PASSWORD);
			System.out.println("[MySQL] Polaczono z baza MySQL.");
		} catch (SQLException e) {
			System.out.println("[MySQL] Polaczenie z baza MySQL nie powiodlo sie! Blad: " + e.getMessage());
		}
	}
	
	public void close() {
		try {
			if(con != null) {
				con.close();
				System.out.println("[MySQL] Rozlaczenie z baza MySQL zakonczylo sie pomyslnie!");
			}
		} catch (SQLException e) {
			System.out.println("[MySQL] Rozlaczanie z baza MySQL nie powiodlo sie! Blad: " + e.getMessage());
		}
	}
	
	public void update(String qry) {
		try {
			Statement st = con.createStatement();
			st.executeUpdate(qry);
			st.close();
		} catch (SQLException e) {
			connect();
			System.err.println(e);
		}
	}
	
	public ResultSet query(String qry) {
		ResultSet rs = null;
		
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(qry);
		} catch (SQLException e) {
			connect();
			System.err.println(e);
		}
		return rs;
	}
}