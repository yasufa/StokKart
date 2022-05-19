package CariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.CariKart;
import UI.CariKartFrame;

public class CariSaveController implements ActionListener {

	private CariKartFrame cariKartUI;
	
	public CariSaveController(CariKartFrame cariKartUI) {
		this.cariKartUI = cariKartUI;
	}
	
	public void cariSave(CariKart cariKart) {
		
		if (cariKart.getByCariKodu(cariKart.getCariKodu()) == null) {
			cariKart.insertCari();
			JOptionPane.showMessageDialog(null, "Cari Eklendi.");
		}
		else {
			cariKart.updateCari();
			JOptionPane.showMessageDialog(null, "Cari Güncellendi");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cariSave(cariKartUI.getData());
		
	}
}
