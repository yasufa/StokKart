package StokFişi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.StokFisi;
import UI.StokFisiFrame;

public class StokFisiBuyutec implements ActionListener{

	private StokFisiFrame stokFisiFrame;
	
	public StokFisiBuyutec(StokFisiFrame stokFisiFrame) {
		this.stokFisiFrame = stokFisiFrame;
	}
	
	public void  buyutec() {
		StokFisDialog stokFisDialog = new StokFisDialog(stokFisiFrame);
		stokFisDialog.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		buyutec();
		
	}
	
	
}
