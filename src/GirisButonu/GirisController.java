package GirisButonu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Controller.MainFrameController;
import Dao.ConnectionManagement;


import UI.GirisFramee;


public class GirisController implements ActionListener{

	private GirisFramee girisUI;
	
	
	public GirisController(GirisFramee girisUI) {
		this.girisUI = girisUI;
		
	}
	
	public void giris() {
		if(girisUI.txtkullanici.getText().length() == 0 || girisUI.txtparola.getText().length() ==0) {
			JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurunuz");
		}
		else {
			Connection con = ConnectionManagement.getConnectionManagement();
			//Connection con = cartDAO.connDb();
			try {
				Statement st= con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM giris WHERE kullanici  ='" +girisUI.txtkullanici.getText().trim() + "'");
				if(rs.next()) {
					if(girisUI.txtkullanici.getText().equals(rs.getString("kullanici")) && girisUI.txtparola.getText().equals(rs.getString("parola"))) {
						MainFrameController cartFrameController = new MainFrameController();
						girisUI.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Kullanıcı Adı ve Parola'yı kontrol ediniz.");
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Kullanıcı Adı ve Parola'yı kontrol ediniz.");
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		giris();
//		MainFrameController cartFrameController = new MainFrameController();
//		girisUI.setVisible(false);	
	}
	
}
