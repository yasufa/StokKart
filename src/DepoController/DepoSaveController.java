package DepoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.DepoKart;
import UI.DepoKartFrame;

public class DepoSaveController implements ActionListener{

	private DepoKartFrame depoKartUI;
	
	public DepoSaveController(DepoKartFrame depoKartUI) {
		this.depoKartUI = depoKartUI;
	}
	
	public void depoSave(DepoKart depoKart) {
		if(depoKart.getByDepoKodu(depoKart.getDepoKodu()) == null) {
			depoKart.insertDepo();
			JOptionPane.showMessageDialog(null, "Depo Eklendi.");
		}
		else {
			depoKart.updateDepo();
			JOptionPane.showMessageDialog(null, "Depo Güncellendi.");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		depoSave(depoKartUI.getData());
		
	}
}
