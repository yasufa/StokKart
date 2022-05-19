package NavigasyonButonlari;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import Model.Cart;
import UI.StokKartListeFrame;
import UI.StokKartiFrame;


public class Sonraki implements ActionListener{

	private StokKartiFrame stokKarti;
	private Cart cart;
	
	public Sonraki(StokKartiFrame stokKarti) {
		this.stokKarti = stokKarti;
		cart=new Cart("");
	}
	
	public void sonra() throws ParseException {
		
		
		cart.setStokKodu(stokKarti.stkkodu.getText());
		stokKarti.setData(cart.getSonraki());
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sonra();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
