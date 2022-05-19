package Model;

import java.sql.*;
import java.util.*;

import Dao.ConnectionManagement;



public class Cart {

	private String stokKodu;
	private String stokAdi;
	private String stokTipi;
	private String birimi;
	private String barkodu;
	private String kdvTipi;
	private String aciklama;
	private String olusturmaTarihi;
	
	//ConnectionManagement cartDAO = new ConnectionManagement();
	Connection con = ConnectionManagement.getConnectionManagement();
	//Connection con = cartDAO.connDb();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	public Cart(String stokKodu, String stokAdi, String stokTipi, String birimi, String barkodu, String kdvTipi,
			String aciklama, String olusturmaTarihi) {
		super();
		this.stokKodu = stokKodu;
		this.stokAdi = stokAdi;
		this.stokTipi = stokTipi;
		this.birimi = birimi;
		this.barkodu = barkodu;
		this.kdvTipi = kdvTipi;
		this.aciklama = aciklama;
		this.olusturmaTarihi = olusturmaTarihi;
	}
	public Cart(String stokKodu) {
		this.stokKodu = stokKodu;
	}
	public String getStokKodu() {
		return stokKodu;
	}
	public void setStokKodu(String stokKodu) {
		this.stokKodu = stokKodu;
	}
	public String getStokAdi() {
		return stokAdi;
	}
	public void setStokAdi(String stokAdi) {
		this.stokAdi = stokAdi;
	}
	public String getStokTipi() {
		return stokTipi;
	}
	public void setStokTipi(String stokTipi) {
		this.stokTipi = stokTipi;
	}
	public String getBirimi() {
		return birimi;
	}
	public void setBirimi(String birimi) {
		this.birimi = birimi;
	}
	public String getBarkodu() {
		return barkodu;
	}
	public void setBarkodu(String barkodu) {
		this.barkodu = barkodu;
	}
	public String getKdvTipi() {
		return kdvTipi;
	}
	public void setKdvTipi(String kdvTipi) {
		this.kdvTipi = kdvTipi;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public String getOlusturmaTarihi() {
		return olusturmaTarihi;
	}
	public void setOlusturmaTarihi(String olusturmaTarihi) {
		this.olusturmaTarihi = olusturmaTarihi;
	}
	
	public ArrayList<Cart> getCart() throws SQLException{
		ArrayList<Cart> cartlar = new ArrayList<>();
		Cart obj;
		try {
			st = this.con.createStatement();
			rs = st.executeQuery("SELECT * FROM stok " );
			while(rs.next()) {
				obj = new Cart(rs.getString("stok_kodu"),rs.getString("stok_adi"),rs.getString("stok_tipi"),rs.getString("birimi"),rs.getString("barkodu"),rs.getString("kdv_tipi"),rs.getString("aciklama"),rs.getString("olusturma_tarihi"));
				cartlar.add(obj);
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
			return cartlar;
		}
	
	
	public boolean insertCart() {
		String query = "INSERT INTO stok"+"(stok_kodu,stok_adi,stok_tipi,birimi,barkodu,kdv_tipi,aciklama,olusturma_tarihi) VALUES"+ "(?,?,?,?,?,?,?,?)";
		
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, stokKodu);
			preparedStatement.setString(2, stokAdi);
			preparedStatement.setString(3, stokTipi);
			preparedStatement.setString(4, birimi);
			preparedStatement.setString(5, barkodu);
			preparedStatement.setString(6, kdvTipi);
			preparedStatement.setString(7, aciklama);
			preparedStatement.setString(8, olusturmaTarihi);
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
	
	public boolean deleteCart(String stokKodu) {
		String query = "DELETE FROM stok WHERE stok_kodu = ?";
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
	
	public boolean updateCart() {
		String query = "UPDATE stok SET stok_adi=?,stok_tipi=?,birimi=?,barkodu=?,kdv_tipi=?,aciklama=?,olusturma_tarihi=? WHERE stok_kodu=?";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, stokAdi);
			preparedStatement.setString(2, stokTipi);
			preparedStatement.setString(3, birimi);
			preparedStatement.setString(4, barkodu);
			preparedStatement.setString(5, kdvTipi);
			preparedStatement.setString(6, aciklama);
			preparedStatement.setString(7, olusturmaTarihi);
			preparedStatement.setString(8, stokKodu);
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
	
	public Cart getByStokKodu(String stokKodu) {
		Cart cart = null;
		try {
			
			preparedStatement = this.con.prepareStatement("SELECT * FROM stok WHERE stok_kodu=?");
			preparedStatement.setString(1, stokKodu);
			rs = preparedStatement.executeQuery();
			
			if(rs.next())
				cart = new Cart(rs.getString("stok_kodu"),rs.getString("stok_adi"),rs.getString("stok_tipi"),rs.getString("birimi"),rs.getString("barkodu"),rs.getString("kdv_tipi"),rs.getString("aciklama"),rs.getString("olusturma_tarihi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cart;
		
				
	}
	
	public Cart getIlk() {
		Cart cart = null;
		try {
			preparedStatement=this.con.prepareStatement("SELECT * FROM stok WHERE stok_kodu= "
					+ "(SELECT MIN(stok_kodu) FROM stok ) ");
			rs = preparedStatement.executeQuery();
			System.out.println(preparedStatement);
			if(rs.next())
				cart = new Cart(rs.getString("stok_kodu"),rs.getString("stok_adi"),rs.getString("stok_tipi"),rs.getString("birimi"),rs.getString("barkodu"),rs.getString("kdv_tipi"),rs.getString("aciklama"),rs.getString("olusturma_tarihi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cart;
	}
	public Cart getSon() {
		Cart cart = null;
		try {
			preparedStatement=this.con.prepareStatement("SELECT * FROM stok WHERE stok_kodu= "
					+ "(SELECT MAX(stok_kodu) FROM stok ) ");
			
			rs = preparedStatement.executeQuery();
			
			if(rs.next())
				cart = new Cart(rs.getString("stok_kodu"),rs.getString("stok_adi"),rs.getString("stok_tipi"),rs.getString("birimi"),rs.getString("barkodu"),rs.getString("kdv_tipi"),rs.getString("aciklama"),rs.getString("olusturma_tarihi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cart;
	}
	
	public Cart getSonraki() {
		Cart cart = null;
		try {
			preparedStatement=this.con.prepareStatement("SELECT * FROM stok WHERE stok_kodu = "
					+ "(SELECT MIN(stok_kodu) FROM stok WHERE stok_kodu > ? )  ");
			preparedStatement.setString(1, stokKodu);
			rs = preparedStatement.executeQuery();
			
			if(rs.next())
				cart = new Cart(rs.getString("stok_kodu"),rs.getString("stok_adi"),rs.getString("stok_tipi"),rs.getString("birimi"),rs.getString("barkodu"),rs.getString("kdv_tipi"),rs.getString("aciklama"),rs.getString("olusturma_tarihi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cart;
	}
	public Cart getOnceki() {
		Cart cart = null;
		try {
			preparedStatement=this.con.prepareStatement("SELECT * FROM stok WHERE stok_kodu = "
					+ "(SELECT MAX(stok_kodu) FROM stok WHERE stok_kodu < ? )  ");
			preparedStatement.setString(1, stokKodu);
			rs = preparedStatement.executeQuery();
			
			if(rs.next())
				cart = new Cart(rs.getString("stok_kodu"),rs.getString("stok_adi"),rs.getString("stok_tipi"),rs.getString("birimi"),rs.getString("barkodu"),rs.getString("kdv_tipi"),rs.getString("aciklama"),rs.getString("olusturma_tarihi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cart;
	}
	
	
	
	
}
