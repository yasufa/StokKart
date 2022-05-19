package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Cart;
import UI.CartFrame;
import UI.StokKartiFrame;

public class StokDeleteController implements ActionListener{
	private CartFrame cartUI;
	private StokKartiFrame stokKarti;
	
	public StokDeleteController(StokKartiFrame stokKarti){
		this.stokKarti = stokKarti;
	}
	
	public void stokDelete(String stokKodu) {
		Cart cart = new Cart(stokKodu);
		cart.deleteCart(stokKodu);
		//cartUI.removeRow(cart);
		JOptionPane.showMessageDialog(null, "Kart Silindi");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		stokDelete(stokKarti.getStokKodu());
		
	}

}
