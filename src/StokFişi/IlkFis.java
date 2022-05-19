package StokFişi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.StokFisi;
import UI.StokFisiFrame;

public class IlkFis implements ActionListener{

	private StokFisiFrame stokFisiUI;
	private StokFisi stokFisi;
	
	public IlkFis(StokFisiFrame stokFisiUI) {
		this.stokFisiUI = stokFisiUI;
		stokFisi = new StokFisi("");
	}
	
	public void ilkFis() {
		stokFisiUI.setFisData(stokFisi.getIlk());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ilkFis();
		
	}
	
	
	
}
