package PopupMenuButonlari;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.KartIslemController;
import Controller.StokDeleteController;
import Model.Cart;
import UI.CartFrame;
import UI.StokKartListeFrame;
import UI.StokKartiFrame;

public class StokKartPopup implements ActionListener{
	
	private CartFrame cartUI;
	private StokKartListeFrame list;
	private KartIslemController aa;
	
	
	
	public StokKartPopup(StokKartListeFrame list, CartFrame cartUI) {
		this.list = list;
		this.cartUI = cartUI;
	}
	
	public void stokKartt() throws ParseException {
		
		
		Cart kart = list.cartlar.get(list.table.getSelectedRow());
		
		KartIslemController aa = new KartIslemController(cartUI);
		aa.setCart(kart);
		
		aa.KartIslem();
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			stokKartt();
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	

}
