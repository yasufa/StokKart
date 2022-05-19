package StokFişi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.StokFisiFrame;

public class StokFisiCariBuyutec implements ActionListener{

	private StokFisiFrame stokFisiFrame;
	
	public StokFisiCariBuyutec(StokFisiFrame stokFisiFrame) {
		this.stokFisiFrame = stokFisiFrame;
	}
	
	public void buyutec() {
		StokFisCariDialog stokFisCariDialog = new StokFisCariDialog(stokFisiFrame);
		stokFisCariDialog.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		buyutec();
		
	}
}
