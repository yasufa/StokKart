package CariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.CariKart;
import UI.CariKartFrame;

public class CariDeleteController implements ActionListener {

	private CariKartFrame cariKartUI;
	
	
	public CariDeleteController(CariKartFrame cariKartUI) {
		this.cariKartUI = cariKartUI;
		
	}
	
	public void deleteCarii(String cariKodu) {
		CariKart cariKart = new CariKart(cariKodu);
		cariKart.deleteCari(cariKodu);
		JOptionPane.showMessageDialog(null, "Cari Silindi");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		deleteCarii(cariKartUI.getCariKodu());
		
	}
	
	
}
