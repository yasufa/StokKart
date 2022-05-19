package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dao.ConnectionManagement;


public class Kdvtipi {

	private String kdvTipi;
	//ConnectionManagement cartDAO = new ConnectionManagement();
	//Connection con = cartDAO.connDb();
	Connection con = ConnectionManagement.getConnectionManagement();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	
	public String getKdvTipi() {
		return kdvTipi;
	}

	public void setKdvTipi(String kdvTipi) {
		this.kdvTipi = kdvTipi;
	}

	public Kdvtipi(String kdvTipi) {
		super();
		this.kdvTipi = kdvTipi;
	}
	
	public boolean insertKdv() {
		String query = "INSERT INTO kdvtipi"+"(deger) VALUES"+"(?)";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, kdvTipi);
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
	
	public boolean deleteKdv(String kdvTipi) {
		String query = "DELETE FROM kdvtipi WHERE deger = ?";
		boolean key = false;
		
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, kdvTipi);
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
	
	public Kdvtipi getByKdv(String kdvTipi) {
		Kdvtipi kdvtipi = null;
		try {
			preparedStatement = this.con.prepareStatement("SELECT deger FROM kdvtipi WHERE deger = ?");
			preparedStatement.setString(1, kdvTipi);
			rs = preparedStatement.executeQuery();
			
			if(rs.next())
				kdvtipi = new Kdvtipi(rs.getString("deger"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kdvtipi;
		
	}
	
	public ArrayList<Kdvtipi> getByDeger(){
		ArrayList<Kdvtipi> degerler = new ArrayList<Kdvtipi>();
		Kdvtipi obj;
		
		try {
			st = this.con.createStatement();
			rs = st.executeQuery("SELECT deger FROM kdvtipi ");
			while(rs.next()) {
				obj = new Kdvtipi(rs.getString("deger"));
				degerler.add(obj);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return degerler;
		
	
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return kdvTipi;
	}
	
	
	
	
	
	
	
	
}

