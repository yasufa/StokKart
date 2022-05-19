package DepoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.DepoKart;
import UI.DepoKartFrame;

public class SonDepo implements ActionListener{

	private DepoKartFrame depoKartUI;
	private DepoKart depoKart;
	
	public SonDepo(DepoKartFrame depoKartUI) {
		this.depoKartUI = depoKartUI;
		depoKart = new DepoKart("");
	}
	
	public void sondepo() {
		depoKartUI.setData(depoKart.getSon());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sondepo();
		
	}
	
	
}
