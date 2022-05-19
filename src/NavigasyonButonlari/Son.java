package NavigasyonButonlari;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import Model.Cart;
import UI.StokKartiFrame;

public class Son implements ActionListener{

	private StokKartiFrame stokKarti;
	private Cart cart;
	
	public Son(StokKartiFrame stokKarti) {
		this.stokKarti = stokKarti;
		cart = new Cart("");
	}
	
	public void sonKayit() throws ParseException {
		
		//cart.setStokKodu(stokKarti.stkkodu.getText());
		stokKarti.setData(cart.getSon());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sonKayit();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
	}
}
