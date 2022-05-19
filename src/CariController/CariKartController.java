package CariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.CariKartFrame;
import UI.CartFrame;

public class CariKartController implements ActionListener {

	private CartFrame cartUI;
	
	
	
	public CariKartController(CartFrame cartUI) {
		this.cartUI = cartUI;
		
	}
	
	public void CariIslem() {
		CariKartFrame cari = new CariKartFrame();
		cartUI.desktopPane.add(cari);
		cari.show();
		
		Ilkcari ilkcari = new Ilkcari(cari);
		cari.ilk.addActionListener(ilkcari);
		Soncari soncari = new Soncari(cari);
		cari.son.addActionListener(soncari);
		GeriCari gericari = new GeriCari(cari);
		cari.geri.addActionListener(gericari);
		IleriCari ilericari = new IleriCari(cari);
		cari.ileri.addActionListener(ilericari);
		CariSaveController saveController = new CariSaveController(cari);
		cari.ekle.addActionListener(saveController);
		CariDeleteController deleteController = new CariDeleteController(cari);
		cari.sil.addActionListener(deleteController);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		CariIslem();
		
	}
	
}
