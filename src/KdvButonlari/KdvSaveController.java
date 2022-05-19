package KdvButonlari;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Kdvtipi;
import UI.KdvTipiFrame;

public class KdvSaveController implements ActionListener {

	private KdvTipiFrame kdvTipiUI;
	
	public KdvSaveController(KdvTipiFrame kdvTipiUI) {
		this.kdvTipiUI = kdvTipiUI;
	}
	
	public void kdvIslem(Kdvtipi kdvtipi) {
		kdvtipi.insertKdv();
		JOptionPane.showMessageDialog(null, "KDV Tipi Eklendi.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		kdvIslem(kdvTipiUI.getData());
		
	}
	
}
