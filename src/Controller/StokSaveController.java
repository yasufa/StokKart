package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


import Model.Cart;
import UI.CartFrame;
import UI.StokKartListeFrame;
import UI.StokKartiFrame;

public class StokSaveController implements ActionListener {

	private CartFrame cartUI;
	private StokKartiFrame stokKarti;
	private StokKartListeFrame liste;
	
	public StokSaveController(StokKartiFrame stokKarti) {
		
		this.stokKarti = stokKarti;
	
	}
	
	public void stokSave(Cart cart) {
		if(cart.getByStokKodu(cart.getStokKodu()) == null) {
			cart.insertCart();
			JOptionPane.showMessageDialog(null, "Kart Eklendi");
		}
		else {
			cart.updateCart();
			JOptionPane.showMessageDialog(null, "Kart güncellendi");}

		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		stokSave(stokKarti.getData());
		
		
	}

	
}
