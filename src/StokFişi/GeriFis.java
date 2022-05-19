package StokFişi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.StokFisi;
import UI.StokFisiFrame;

public class GeriFis implements ActionListener{

	private StokFisiFrame stokFisiUI;
	private StokFisi stokFisi;
	
	public GeriFis(StokFisiFrame stokFisiUI) {
		this.stokFisiUI = stokFisiUI;
		stokFisi = new StokFisi("");
	}
	
	public void gerifis() {
		stokFisi.setFisNo(stokFisiUI.fisno.getText());
		stokFisiUI.setFisData(stokFisi.getOnceki());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gerifis();
		
	}
}
