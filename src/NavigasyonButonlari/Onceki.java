package NavigasyonButonlari;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Cart;
import UI.StokKartiFrame;

public class Onceki implements ActionListener{

		private StokKartiFrame stokKarti;
		private Cart cart;
	

	public Onceki(StokKartiFrame stokKarti) {
		this.stokKarti = stokKarti;
		cart = new Cart("");
		
	}
	
		public void Once() {
			
			cart.setStokKodu(stokKarti.stkkodu.getText());
			stokKarti.setData(cart.getOnceki());
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Once();
		}
		
	}
