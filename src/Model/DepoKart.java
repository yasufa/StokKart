package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Dao.ConnectionManagement;

public class DepoKart {

	private String depoKodu;
	private String depoAdi;
	
	Connection con = ConnectionManagement.getConnectionManagement();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	public DepoKart(String depoKodu, String depoAdi) {
		super();
		this.depoKodu = depoKodu;
		this.depoAdi = depoAdi;
	}
	
	

	public DepoKart(String depoKodu) {
		this.depoKodu = depoKodu;
	}



	public String getDepoKodu() {
		return depoKodu;
	}

	public void setDepoKodu(String depoKodu) {
		this.depoKodu = depoKodu;
	}

	public String getDepoAdi() {
		return depoAdi;
	}

	public void setDepoAdi(String depoAdi) {
		this.depoAdi = depoAdi;
	}
	
	
	public boolean insertDepo() {
		String query = "INSERT INTO depo"+"(depo_kodu,depo_adi) VALUES"+"(?,?)";
		boolean key = false;
		try {
			st = con.createStatement();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, depoKodu);
			pstmt.setString(2, depoAdi);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(key)
			return true;
		else
			return false;
	}
	
	public boolean deleteDepo(String depoKodu) {
		String query = "DELETE FROM depo WHERE depo_kodu = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, depoKodu);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(key)
			return true;
		else
			return false;
	}
	
	public boolean updateDepo() {
		String query = "UPDATE depo SET depo_adi=? WHERE depo_kodu=?";
		boolean key = false;
		try {
			st = con.createStatement();
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, depoKodu);
			pstmt.setString(2, depoAdi);
		
			
			pstmt.executeUpdate();
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
	
	public DepoKart getByDepoKodu(String depoKodu) {
		DepoKart depoKart = null;
try {
			
			pstmt = this.con.prepareStatement("SELECT * FROM depo WHERE depo_kodu=?");
			pstmt.setString(1, depoKodu);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				depoKart = new DepoKart(rs.getString("depo_kodu"),rs.getString("depo_adi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depoKart;
	}
	
	public DepoKart getIlk( ) {
		DepoKart depoKart = null;
		try {
			pstmt=this.con.prepareStatement("SELECT * FROM depo WHERE depo_kodu= "
					+ "(SELECT MIN(depo_kodu) FROM depo ) ");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				depoKart = new DepoKart(rs.getString("depo_kodu"),rs.getString("depo_adi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depoKart;
	}
	
	public DepoKart getSon() {
		DepoKart depoKart = null;
		try {
			pstmt=this.con.prepareStatement("SELECT * FROM depo WHERE depo_kodu= "
					+ "(SELECT MAX(depo_kodu) FROM depo ) ");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				depoKart = new DepoKart(rs.getString("depo_kodu"),rs.getString("depo_adi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depoKart;
	}
	
	public DepoKart getSonraki() {
		DepoKart depoKart = null;
		try {
			pstmt=this.con.prepareStatement("SELECT * FROM depo WHERE depo_kodu = "
					+ "(SELECT MIN(depo_kodu) FROM depo WHERE depo_kodu > ? )  ");
			pstmt.setString(1, depoKodu);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				depoKart = new DepoKart(rs.getString("depo_kodu"),rs.getString("depo_adi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depoKart;
	}
	
	public DepoKart getOnceki() {
		DepoKart depoKart = null;
		try {
			pstmt=this.con.prepareStatement("SELECT * FROM depo WHERE depo_kodu = "
					+ "(SELECT MAX(depo_kodu) FROM depo WHERE depo_kodu < ? )  ");
			pstmt.setString(1, depoKodu);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				depoKart = new DepoKart(rs.getString("depo_kodu"),rs.getString("depo_adi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depoKart;
	}
	
	
}
