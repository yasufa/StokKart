package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GirisButonu.GirisController;
import UI.GirisFramee;

public class GirisFrameController implements ActionListener {

	private GirisFramee girisUI;
	private GirisController girisController;

	public GirisFrameController() {
		girisUI = new GirisFramee();
		
		girisController = new GirisController(girisUI);
		girisUI.btngiris.addActionListener(girisController);
		
		girisUI.setVisible(true);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
