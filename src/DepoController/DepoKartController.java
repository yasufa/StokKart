package DepoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.CartFrame;
import UI.DepoKartFrame;

public class DepoKartController implements ActionListener{
	private CartFrame cartUI;
	

	
	public DepoKartController(CartFrame cartUI) {
		this.cartUI = cartUI;
	}
	
	public void DepoIslem() {
		DepoKartFrame depo = new DepoKartFrame();
		cartUI.desktopPane.add(depo);
		depo.show();
		
		DepoSaveController saveController = new DepoSaveController(depo);
		depo.ekle.addActionListener(saveController);
		DepoDeleteController deleteController = new DepoDeleteController(depo);
		depo.sil.addActionListener(deleteController);
		GeriDepo geridepo = new GeriDepo(depo);
		depo.geri.addActionListener(geridepo);
		IleriDepo ileriDepo =new IleriDepo(depo);
		depo.ileri.addActionListener(ileriDepo);
		IlkDepo ilkDepo = new IlkDepo(depo);
		depo.ilk.addActionListener(ilkDepo);
		SonDepo sonDepo = new SonDepo(depo);
		depo.son.addActionListener(sonDepo);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DepoIslem();
		
	}
}
