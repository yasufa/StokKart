package StokFişi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.StokFisiFrame;

public class StokFisYenileButon implements ActionListener{

	private StokFisiFrame stokFisiFrame;
	
	public StokFisYenileButon(StokFisiFrame stokFisiFrame) {
		this.stokFisiFrame = stokFisiFrame;
	}
	public void yenile() {
		IleriFis ileriFis = new IleriFis(stokFisiFrame);
		ileriFis.ilerifis();
		GeriFis geriFis = new GeriFis(stokFisiFrame);
		geriFis.gerifis();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		yenile();
		
	}
}
