package CariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CariKart;
import UI.CariKartFrame;

public class IleriCari implements ActionListener{

	private CariKartFrame cariKartUI;
	private CariKart cariKart;
	
	public IleriCari(CariKartFrame cariKartUI) {
		this.cariKartUI = cariKartUI;
		cariKart = new CariKart("");
	}
	
	public void ilericari() {
		cariKart.setCariKodu(cariKartUI.carikodu.getText());
		cariKartUI.setData(cariKart.getSonraki());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ilericari();
		
	}
}
