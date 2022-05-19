package KdvButonlari;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Kdvtipi;
import UI.KdvTipiFrame;

public class KdvDeleteController implements ActionListener{

	private KdvTipiFrame kdvTipiUI;
	
	public KdvDeleteController(KdvTipiFrame kdvTipiUI) {
		this.kdvTipiUI = kdvTipiUI;
	}
	
	public void kdvDelete(String kdvTipi) {
		Kdvtipi kdv = new Kdvtipi(kdvTipi);
		kdv.deleteKdv(kdvTipi);
		JOptionPane.showMessageDialog(null, "KDV Tipi Silindi");
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		kdvDelete(kdvTipiUI.getKdvTipi());
		
	}
	
	
	
}
