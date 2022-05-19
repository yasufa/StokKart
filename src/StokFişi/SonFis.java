package StokFişi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.StokFisi;
import Model.StokFisiDetay;
import TableModel.StokFisDetayTableModel;
import UI.StokFisiFrame;

public class SonFis  implements ActionListener{

	private StokFisiFrame stokFisiUI;
	private StokFisi stokFisi;
	private StokFisDetayTableModel stokFisTableModel;
	private StokFisiDetay stokFisiDetay;
	
	
	public SonFis(StokFisiFrame stokFisiUI) {
		this.stokFisiUI = stokFisiUI;
		stokFisi = new StokFisi("");
	}
	
	public void sonfis() {
		stokFisiUI.setFisData(stokFisi.getSon());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sonfis();
		
	}
}
