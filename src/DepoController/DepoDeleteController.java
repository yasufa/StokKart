package DepoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.DepoKart;
import UI.DepoKartFrame;

public class DepoDeleteController implements ActionListener{

	private DepoKartFrame depoKartUI;
	
	public DepoDeleteController(DepoKartFrame depoKartUI) {
		this.depoKartUI = depoKartUI;
	}
	
	public void deletedepo(String depoKodu) {
		DepoKart depoKart = new DepoKart(depoKodu);
		depoKart.deleteDepo(depoKodu);
		JOptionPane.showMessageDialog(null, "Depo Silindi.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		deletedepo(depoKartUI.getDepoKodu());
		
	}

}
