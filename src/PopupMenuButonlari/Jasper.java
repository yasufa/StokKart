package PopupMenuButonlari;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.StokKartListeFrame;
import net.sf.jasperreports.engine.JRException;

public class Jasper implements ActionListener{

	private StokKartListeFrame list;
	
	public Jasper(StokKartListeFrame list) {
		this.list = list;
		
	}
	
	public void Listelee() {
		list.ShowReport();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Listelee();
		
	}
}
