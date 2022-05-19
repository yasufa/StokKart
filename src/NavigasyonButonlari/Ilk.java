package NavigasyonButonlari;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import Model.Cart;
import UI.StokKartiFrame;

public class Ilk implements ActionListener{
	private StokKartiFrame stokKarti;
	private Cart cart;
	
	public Ilk(StokKartiFrame stokKarti) {
		this.stokKarti = stokKarti;
		cart = new Cart("");
	}
	
	public void ilkKayit() throws ParseException {
		//cart.setStokKodu(stokKarti.stkkodu.getText());
		stokKarti.setData(cart.getIlk());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			ilkKayit();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
