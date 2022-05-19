package DepoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.DepoKart;
import UI.DepoKartFrame;

public class IleriDepo implements ActionListener{

	private DepoKartFrame depoKartUI;
	private DepoKart depoKart;
	
	public IleriDepo(DepoKartFrame depoKartUI) {
		this.depoKartUI = depoKartUI;
		depoKart = new DepoKart("");
	}
	
	public void ileridepo() {
		depoKart.setDepoKodu(depoKartUI.depokodu.getText());
		depoKartUI.setData(depoKart.getSonraki());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ileridepo();
		
	}
}
