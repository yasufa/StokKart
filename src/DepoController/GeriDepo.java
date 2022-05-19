package DepoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.DepoKart;
import UI.DepoKartFrame;

public class GeriDepo implements ActionListener{

	private DepoKartFrame depoKartUI;
	private DepoKart depoKart;
	
	public GeriDepo(DepoKartFrame depoKartUI) {
		this.depoKartUI = depoKartUI;
		depoKart = new DepoKart("");
	}
	
	public void geridepo() {
		depoKart.setDepoKodu(depoKartUI.depokodu.getText());
		depoKartUI.setData(depoKart.getOnceki());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		geridepo();
		
	}
	
	
	
}
