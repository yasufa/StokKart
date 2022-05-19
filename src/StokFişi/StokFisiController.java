package StokFişi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.StokFisi;
import UI.CartFrame;
import UI.StokFisiFrame;
import UI.StokKartListeFrame;

public class StokFisiController implements ActionListener{

	private CartFrame cartUI;
	private StokKartListeFrame stokKartListeFrame;
	private StokFisi stokFisi;
	
	public StokFisiController(CartFrame cartUI) {
		this.cartUI = cartUI;
	}
	
	public void fisIslem() {
		StokFisiFrame fis = new StokFisiFrame();
		cartUI.desktopPane.add(fis);
		fis.show();
		
		IlkFis ilkFis=new IlkFis(fis);
		fis.ilk.addActionListener(ilkFis);
		SonFis sonFis = new SonFis(fis);
		fis.son.addActionListener(sonFis);
		IleriFis ileriFis = new IleriFis(fis);
		fis.ileri.addActionListener(ileriFis);
		GeriFis geriFis = new GeriFis(fis);
		fis.geri.addActionListener(geriFis);
		StokFisYenileButon yenile =new StokFisYenileButon(fis);
		fis.yenile.addActionListener(yenile);
		StokFisiDetayKeyListener satir = new StokFisiDetayKeyListener(fis,fis.stokFisTableModel);
		fis.table.addKeyListener(satir);
		
		StokFisDetayDelete sil = new StokFisDetayDelete(fis,fis.stokFisTableModel);
		fis.table.addKeyListener(sil);
		StokFisiBuyutec buyutec = new StokFisiBuyutec(fis);
		fis.buyutec.addActionListener(buyutec);
		StokFisiCariBuyutec stokFisiCariBuyutec = new StokFisiCariBuyutec(fis);
		fis.caribuyutec.addActionListener(stokFisiCariBuyutec);
		StokFisDeleteButon delete =new StokFisDeleteButon(fis);
		fis.fissil.addActionListener(delete);
		StokFisiSave save = new StokFisiSave(fis);
		fis.kaydet.addActionListener(save);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fisIslem();
		
	}
	
	public void setFis(StokFisi stokFisi) {
		this.stokFisi = stokFisi;
	}
}
