package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import KdvButonlari.KdvDeleteController;
import KdvButonlari.KdvSaveController;
import UI.CartFrame;
import UI.KdvTipiFrame;

public class KdvTipiController implements ActionListener{

	private CartFrame cartUI;
	private KdvSaveController kdvSaveController;
	private KdvDeleteController kdvDeleteController;
	
	public KdvTipiController(CartFrame cartUI) {
		this.cartUI = cartUI;
	}
	
	public void kdvIslem() {
		KdvTipiFrame kdvTipiUI = new KdvTipiFrame();
		cartUI.desktopPane.add(kdvTipiUI);
		kdvTipiUI.show();
		
		kdvSaveController = new KdvSaveController(kdvTipiUI);
		kdvTipiUI.btnEkle.addActionListener(kdvSaveController);
		
		kdvDeleteController = new KdvDeleteController(kdvTipiUI);
		kdvTipiUI.btnSil.addActionListener(kdvDeleteController);
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		kdvIslem();
	}
	
	
}
