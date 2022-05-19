package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import Dao.ConnectionManagement;

public class StokFisiDetay {

	private int id;
	private String stokFisiId;
	private String stokKodu;
	private String miktar;
	private String fiyat;
	private String paraBirimi;
	

	Connection con = ConnectionManagement.getConnectionManagement();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	public StokFisiDetay(int id, String stokFisiId, String stokKodu, String miktar, String fiyat, String paraBirimi) {
		super();
		this.id = id;
		this.stokFisiId = stokFisiId;
		this.stokKodu = stokKodu;
		this.miktar = miktar;
		this.fiyat = fiyat;
		this.paraBirimi = paraBirimi;
	}
	public StokFisiDetay( String stokFisiId, String stokKodu, String miktar, String fiyat, String paraBirimi) {
		super();
		
		this.stokFisiId = stokFisiId;
		this.stokKodu = stokKodu;
		this.miktar = miktar;
		this.fiyat = fiyat;
		this.paraBirimi = paraBirimi;
	}
	public StokFisiDetay() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public StokFisiDetay(String stokKodu) {
		this.stokKodu = stokKodu;
	}

	public String getStokFisiId() {
		return stokFisiId;
	}

	public void setStokFisiId(String stokFisiId) {
		this.stokFisiId = stokFisiId;
	}

	public String getStokKodu() {
		return stokKodu;
	}
	public void setStokKodu(String stokKodu) {
		this.stokKodu = stokKodu;
	}
	public String getMiktar() {
		return miktar;
	}
	public void setMiktar(String miktar) {
		this.miktar = miktar;
	}
	public String getFiyat() {
		return fiyat;
	}
	public void setFiyat(String fiyat) {
		this.fiyat = fiyat;
	}
	public String getParaBirimi() {
		return paraBirimi;
	}
	public void setParaBirimi(String paraBirimi) {
		this.paraBirimi = paraBirimi;
	}
	
	
	public List<StokFisiDetay> getDetayy(String stokFisiId){
		List<StokFisiDetay> detaylar = new ArrayList<>();
		StokFisiDetay obj;
		try {
			preparedStatement = this.con.prepareStatement("select  stok_fis_detay.id, stok_fis.fis_no,stok_fis_detay.stok_fisi_id,stok_fis_detay.stok_kodu,stok_fis_detay.miktar,stok_fis_detay.fiyat,stok_fis_detay.para_birimi from stok_fis left join stok_fis_detay  on stok_fis.fis_no = stok_fis_detay.stok_fisi_id where stok_fis_detay.stok_fisi_id=?");
			preparedStatement.setString(1, stokFisiId);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				obj = new StokFisiDetay(rs.getInt("stok_fis_detay.id"), rs.getString("stok_fisi_id"),rs.getString("stok_kodu"),rs.getString("miktar"),rs.getString("fiyat"),rs.getString("para_birimi"));
				detaylar.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detaylar;
	}
	
	public StokFisiDetay setStokFisi(String stokFisiId) {
		this.stokFisiId = stokFisiId;
		return this;
	}
	public StokFisiDetay getByFisId(String stokFisiId) {
		StokFisiDetay stokFisiDetay = null;
		try {
			preparedStatement = this.con.prepareStatement("select fisdetayy.id, fis.fis_no,fisdetayy.stok_fisi_id,fisdetayy.stok_kodu,fisdetayy.miktar,fisdetayy.fiyat,fisdetayy.para_birimi from fis left join fisdetayy  on fis.fis_no = fisdetayy.stok_fisi_id where fisdetayy.stok_fisi_id=?");
			preparedStatement.setString(1, stokFisiId);
			rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				stokFisiDetay = new StokFisiDetay(rs.getInt("fisdetayy.id"), rs.getString("stok_fisi_id"),rs.getString("stok_kodu"),rs.getString("miktar"),rs.getString("fiyat"),rs.getString("para_birimi"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stokFisiDetay;
	
	}
	
	public boolean updateDetay(String stokKodu,String miktar,String fiyat,String paraBirimi) {
		
		String query = "UPDATE stok_fis_detay SET  stok_kodu=?,miktar=?,fiyat=?,para_birimi=?  ";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, stokKodu);
			preparedStatement.setString(2, miktar);
			preparedStatement.setString(3, fiyat);
			preparedStatement.setString(4, paraBirimi);
			
			
			
			preparedStatement.executeUpdate();
			key = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(key)
			return true;
		else
			return false;
	}
	
	public boolean update() {
		
		String query = "UPDATE stok_fis_detay SET  stok_kodu=?,miktar=?,fiyat=?,para_birimi=? WHERE id = " + id;
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, stokKodu);
			preparedStatement.setString(2, miktar);
			preparedStatement.setString(3, fiyat);
			preparedStatement.setString(4, paraBirimi);
			
			preparedStatement.executeUpdate();
			key = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(key)
			return true;
		else
			return false;
	}
	
	
	public boolean insertDetay(StokFisiDetay stokFisiDetay) {
		String query = "INSERT INTO stok_fis_detay"+"(stok_fisi_id,stok_kodu,miktar, fiyat, para_birimi) VALUES"+ "(?,?,?,?,?)";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, stokFisiId);
			preparedStatement.setString(2, stokKodu);
			preparedStatement.setString(3, miktar);
			preparedStatement.setString(4, fiyat);
			preparedStatement.setString(5, paraBirimi);
			
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
	
	public boolean deleteDetay(StokFisiDetay detay) {
		String query = "DELETE FROM  stok_fis_detay WHERE stok_kodu = ?";
		boolean key = false;
		
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, stokKodu);
		
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
