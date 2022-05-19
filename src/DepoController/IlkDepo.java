package DepoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.DepoKart;
import UI.DepoKartFrame;

public class IlkDepo implements ActionListener{

	private DepoKartFrame depoKartUI;
	private DepoKart depoKart;
	
	public IlkDepo(DepoKartFrame depoKartUI) {
		this.depoKartUI = depoKartUI;
		depoKart = new DepoKart("");
	}
	public void ilkdepo() {
		depoKartUI.setData(depoKart.getIlk());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ilkdepo();
		
	}
}
