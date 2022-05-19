package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.CartFrame;
import UI.KullaniciFrame;

public class KullaniciController implements ActionListener{
	
	private CartFrame cartUI;
	private KullaniciFrame kullaniciUI;
	private KullaniciSaveController saveController;
	
	
	public KullaniciController(CartFrame cartUI) {
		this.cartUI = cartUI;
	}
	
	public void ekle() {
		KullaniciFrame kullaniciUI = new KullaniciFrame();
		cartUI.desktopPane.add(kullaniciUI);
		kullaniciUI.show();
		
		saveController = new KullaniciSaveController(kullaniciUI);
		kullaniciUI.btnNewButton.addActionListener(saveController);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ekle();
		
	}

}
