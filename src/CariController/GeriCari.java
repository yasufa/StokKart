package CariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CariKart;
import UI.CariKartFrame;

public class GeriCari implements ActionListener{

	private CariKartFrame cariKartUI;
	private CariKart cariKart;
	
	public GeriCari(CariKartFrame cariKartUI) {
		this.cariKartUI = cariKartUI;
		cariKart = new CariKart("");
	}
	
	public void gericari() {
		cariKart.setCariKodu(cariKartUI.carikodu.getText());
		cariKartUI.setData(cariKart.getOnceki());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gericari();
		
	}
}
