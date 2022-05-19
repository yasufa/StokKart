package StokFişi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.StokFisi;
import UI.StokFisiFrame;

public class StokFisDeleteButon implements ActionListener{

	private StokFisiFrame stokFisiFrame;
	
	public StokFisDeleteButon(StokFisiFrame stokFisiFrame) {
		this.stokFisiFrame = stokFisiFrame;
	}
	public void fisisil() {
		StokFisi fis = new StokFisi();
		int rr =JOptionPane.showConfirmDialog(null, "Silmek istediğinize emin misiniz?","Dikkat!",JOptionPane.YES_NO_OPTION);
		if(rr ==1) {
			return;
		}
		fis.deleteFis(stokFisiFrame.kod());
		stokFisiFrame.fieldNull();	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fisisil();
		
	}
}
