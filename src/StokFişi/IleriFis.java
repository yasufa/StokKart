package StokFişi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.StokFisi;
import UI.StokFisiFrame;

public class IleriFis implements ActionListener{

	private StokFisiFrame stokFisiUI;
	private StokFisi stokFisi;
	
	public IleriFis(StokFisiFrame stokFisiUI) {
		this.stokFisiUI = stokFisiUI;
		stokFisi = new StokFisi("");
	}
	
	public void ilerifis() {
		stokFisi.setFisNo(stokFisiUI.fisno.getText());
		stokFisiUI.setFisData(stokFisi.getSonraki());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ilerifis();
		
	}
}
