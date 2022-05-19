package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Dao.ConnectionManagement;

public class StokFisi {
	private String id;
	private String fisNo;
	private String cari;
	private String depo;
	private String tarih;
	
	Connection con = ConnectionManagement.getConnectionManagement();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	public StokFisi(String id,String fisNo, String cari, String depo, String tarih) {
		super();
		this.id = id;
		this.fisNo = fisNo;
		this.cari = cari;
		this.depo = depo;
		this.tarih = tarih;
	}
	public StokFisi(String fisNo) {
		this.fisNo = fisNo;
	}
	
	public StokFisi() {}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFisNo() {
		return fisNo;
	}
	public void setFisNo(String fisNo) {
		this.fisNo = fisNo;
	}
	public String getCari() {
		return cari;
	}
	public void setCari(String cari) {
		this.cari = cari;
	}
	public String getDepo() {
		return depo;
	}
	public void setDepo(String depo) {
		this.depo = depo;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	
	public StokFisi getIlk() {
		StokFisi stokFisi = null;
		try {
			preparedStatement=this.con.prepareStatement("SELECT * FROM stok_fis WHERE fis_no= "
					+ "(SELECT MIN(fis_no) FROM stok_fis ) ");
			rs = preparedStatement.executeQuery();
			
			if(rs.next())
				stokFisi = new StokFisi(rs.getString("id"),rs.getString("fis_no"),rs.getString("cari"),rs.getString("depo"),rs.getString("tarih"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stokFisi;
	}
	
	public StokFisi getSon() {
		StokFisi stokFisi = null;
		try {
			preparedStatement=this.con.prepareStatement("SELECT * FROM stok_fis WHERE fis_no= "
					+ "(SELECT MAX(fis_no) FROM stok_fis ) ");
			rs = preparedStatement.executeQuery();
			
			if(rs.next())
				stokFisi = new StokFisi(rs.getString("id"),rs.getString("fis_no"),rs.getString("cari"),rs.getString("depo"),rs.getString("tarih"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stokFisi;
	}
	
	public StokFisi getSonraki() {
		StokFisi stokFisi = null;
		try {
			preparedStatement=this.con.prepareStatement("SELECT * FROM stok_fis WHERE fis_no = "
					+ "(SELECT MIN(fis_no) FROM stok_fis WHERE fis_no > ? )  ");
			preparedStatement.setString(1, fisNo);
			rs = preparedStatement.executeQuery();
			
			if(rs.next())
				stokFisi = new StokFisi(rs.getString("id"),rs.getString("fis_no"),rs.getString("cari"),rs.getString("depo"),rs.getString("tarih"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stokFisi;
	}
	
	public StokFisi getOnceki() {
		StokFisi stokFisi = null;
		try {
			preparedStatement=this.con.prepareStatement("SELECT * FROM stok_fis WHERE fis_no = "
					+ "(SELECT MAX(fis_no) FROM stok_fis WHERE fis_no < ? )  ");
			preparedStatement.setString(1, fisNo);
			rs = preparedStatement.executeQuery();
			
			if(rs.next())
				stokFisi = new StokFisi(rs.getString("id"),rs.getString("fis_no"),rs.getString("cari"),rs.getString("depo"),rs.getString("tarih"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stokFisi;
	}
	
	public List<StokFisi> getStokFisi(){
		List<StokFisi> fisler = new ArrayList<>();
		StokFisi obj;
		try {
			st = this.con.createStatement();
			rs = st.executeQuery("SELECT * FROM stok_fis");
			while(rs.next()) {
				obj = new StokFisi(rs.getString("id"),rs.getString("fis_no"),rs.getString("cari"),rs.getString("depo"),rs.getString("tarih"));
				fisler.add(obj);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fisler;
	}
	
	public boolean deleteFis(String fisNo) {
		String query = "DELETE FROM stok_fis WHERE fis_no=?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, fisNo);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(key)
			return true;
		else 
			return false;
		
	}
	
	public boolean insertFis() {
		String query="INSERT INTO stok_fis"+"(fis_no,cari,depo,tarih) VALUES"+"(?,?,?,?)";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, fisNo);
			preparedStatement.setString(2, cari);
			preparedStatement.setString(3, depo);
			preparedStatement.setString(4, tarih);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(key)
			return true;
		else
			return false;
	}
	
	public StokFisi getByFisNo(String fisNo) {
		StokFisi stokFisi = null;
		
		try {
			preparedStatement = this.con.prepareStatement("SELECT * FROM stok_fis WHERE fis_no=?");
			preparedStatement.setString(1, fisNo);
			rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				stokFisi = new StokFisi(rs.getString("id"),rs.getString("fis_no"),rs.getString("cari"),rs.getString("depo"),rs.getString("tarih"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stokFisi;
	}
	
	public boolean updateStokFisi() {
		String query = "UPDATE stok_fis SET cari=?,depo=?,tarih=? WHERE fis_no=?";
		boolean key = false;
		
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, cari);
			preparedStatement.setString(2, depo);
			preparedStatement.setString(3, tarih);
			preparedStatement.setString(4, fisNo);
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
