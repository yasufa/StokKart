package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import Dao.ConnectionManagement;



public class Giris {

	private String kullaniciAdi;
	private String parola;
	
	//ConnectionManagement cartDAO = new ConnectionManagement();
	//Connection con = cartDAO.connDb();
	Connection con = ConnectionManagement.getConnectionManagement();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	public Giris(String kullaniciAdi, String parola) {
		super();
		this.kullaniciAdi = kullaniciAdi;
		this.parola = parola;
	}
	public Giris() {}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	
	
	public boolean insertKullanıcı() {
		String query = "INSERT INTO giris"+"(kullanici,parola) VALUES"+"(?,?)";
		boolean key = false;
		
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, kullaniciAdi);
			preparedStatement.setString(2, parola);
			preparedStatement.executeUpdate();
			key = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(key)
			return true;
		else
			return false;
		
		
	}
	
	
	
}
