package CariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CariKart;
import UI.CariKartFrame;

public class Ilkcari implements ActionListener {
	
	private CariKartFrame cariKartUI;
	private CariKart cariKart;
	
	
	public Ilkcari(CariKartFrame cariKartUI) {
		this.cariKartUI = cariKartUI;
		cariKart = new CariKart("");
	}
	
	public void ilkCarii() {
		cariKartUI.setData(cariKart.getIlk());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ilkCarii();
		
	}
	
	
}
