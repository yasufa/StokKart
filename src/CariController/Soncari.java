package CariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CariKart;
import UI.CariKartFrame;

public class Soncari implements ActionListener{

	private CariKartFrame cariKartUI;
	private CariKart cariKart;
	
	
	public Soncari(CariKartFrame cariKartUI) {
		this.cariKartUI = cariKartUI;
		cariKart = new CariKart("");
		
	}
	public void soncarii() {
		cariKartUI.setData(cariKart.getSon());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		soncarii();
		
		
	}
}
