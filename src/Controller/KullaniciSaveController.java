package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Giris;
import UI.KullaniciFrame;

public class KullaniciSaveController implements ActionListener{

	private KullaniciFrame kullaniciUI;
	private Giris giris;
	
	public KullaniciSaveController(KullaniciFrame kullaniciUI) {
		this.kullaniciUI = kullaniciUI;
	}
	
	public void kullaniciSave(Giris giris) {
		giris.insertKullanıcı();
		JOptionPane.showMessageDialog(null, "Başarıyla Eklendi");
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		kullaniciSave(kullaniciUI.getData());
		
	}
	
}
