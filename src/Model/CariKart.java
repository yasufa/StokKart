package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionManagement;

public class CariKart {

	private String cariKodu;
	private String cariAdi;
	private String kisaAdi;
	private String adresi;

	Connection con = ConnectionManagement.getConnectionManagement();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	public CariKart(String cariKodu, String cariAdi, String kisaAdi, String adresi) {
		super();
		this.cariKodu = cariKodu;
		this.cariAdi = cariAdi;
		this.kisaAdi = kisaAdi;
		this.adresi = adresi;
	}
	public CariKart(String cariKodu) {
		this.cariKodu = cariKodu;
	}
	public String getCariKodu() {
		return cariKodu;
	}
	public void setCariKodu(String cariKodu) {
		this.cariKodu = cariKodu;
	}
	public String getCariAdi() {
		return cariAdi;
	}
	public void setCariAdi(String cariAdi) {
		this.cariAdi = cariAdi;
	}
	public String getKisaAdi() {
		return kisaAdi;
	}
	public void setKisaAdi(String kisaAdi) {
		this.kisaAdi = kisaAdi;
	}
	public String getAdresi() {
		return adresi;
	}
	public void setAdresi(String adresi) {
		this.adresi = adresi;
	}
	
	public List<CariKart> getCari(){
		List<CariKart> cariler = new ArrayList<>();
		CariKart obj;
		try {
			st = this.con.createStatement();
			rs = st.executeQuery("SELECT * FROM cari");
			while(rs.next()) {
				obj = new CariKart(rs.getString("cari_kodu"),rs.getString("cari_adi"),rs.getString("kisa_adi"),rs.getString("adresi"));
				cariler.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cariler;
	}
	
	
 	public boolean insertCari() {
		String query = "INSERT INTO cari"+"(cari_kodu,cari_adi,kisa_adi,adresi) VALUES"+"(?,?,?,?)";
		boolean key = false;
		try {
			st = con.createStatement();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cariKodu);
			pstmt.setString(2, cariAdi);
			pstmt.setString(3, kisaAdi);
			pstmt.setString(4, adresi);
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
	
	public boolean deleteCari(String cariKodu) {
		String query = "DELETE FROM cari WHERE cari_kodu = ?";
		boolean key = false;
		try {
			st = con.createStatement();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cariKodu);
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
	
	public boolean updateCari() {
		String query = "UPDATE cari SET cari_adi=?, kisa_adi = ?,adresi= ? WHERE cari_kodu=?";
		boolean key = false;
		try {
			st = con.createStatement();
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, cariAdi);
			pstmt.setString(2, kisaAdi);
			pstmt.setString(3, adresi);
			pstmt.setString(4, cariKodu);
			
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
	
	public CariKart getByCariKodu(String cariKodu) {
		CariKart cariKart = null;
		try {
			
			pstmt = this.con.prepareStatement("SELECT * FROM cari WHERE cari_kodu=?");
			pstmt.setString(1, cariKodu);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				cariKart = new CariKart(rs.getString("cari_kodu"),rs.getString("cari_adi"),rs.getString("kisa_adi"),rs.getString("adresi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cariKart;
	}
	
	public CariKart getIlk() {
		CariKart cariKart = null;
		try {
			pstmt=this.con.prepareStatement("SELECT * FROM cari WHERE cari_kodu= "
					+ "(SELECT MIN(cari_kodu) FROM cari ) ");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				cariKart = new CariKart(rs.getString("cari_kodu"),rs.getString("cari_adi"),rs.getString("kisa_adi"),rs.getString("adresi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cariKart;
	}
	
	public CariKart getSon() {
		CariKart cariKart = null;
		try {
			pstmt=this.con.prepareStatement("SELECT * FROM cari WHERE cari_kodu= "
					+ "(SELECT MAX(cari_kodu) FROM cari ) ");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				cariKart = new CariKart(rs.getString("cari_kodu"),rs.getString("cari_adi"),rs.getString("kisa_adi"),rs.getString("adresi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cariKart;
	}
	public CariKart getSonraki() {
		CariKart cariKart = null;
		try {
			pstmt=this.con.prepareStatement("SELECT * FROM cari WHERE cari_kodu = "
					+ "(SELECT MIN(cari_kodu) FROM cari WHERE cari_kodu > ? )  ");
			pstmt.setString(1, cariKodu);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				cariKart = new CariKart(rs.getString("cari_kodu"),rs.getString("cari_adi"),rs.getString("kisa_adi"),rs.getString("adresi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cariKart;
	}
	
	public CariKart getOnceki() {
		CariKart cariKart = null;
		try {
			pstmt=this.con.prepareStatement("SELECT * FROM cari WHERE cari_kodu = "
					+ "(SELECT MAX(cari_kodu) FROM cari WHERE cari_kodu < ? )  ");
			pstmt.setString(1, cariKodu);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				cariKart = new CariKart(rs.getString("cari_kodu"),rs.getString("cari_adi"),rs.getString("kisa_adi"),rs.getString("adresi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cariKart;
	}
}
