package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.StokKartListeFrame;

public class ListeleController implements ActionListener{

	private StokKartListeFrame list;
	
	public ListeleController(StokKartListeFrame list) {
		this.list = list;
	}
	
	public void Listele() {
		list.table.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Listele();
		
	}
	
	
	
	
}
