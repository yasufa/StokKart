package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Cart;
import NavigasyonButonlari.Ilk;
import NavigasyonButonlari.Onceki;
import NavigasyonButonlari.Son;
import NavigasyonButonlari.Sonraki;
import PopupMenuButonlari.StokKartPopup;
import UI.CartFrame;
import UI.StokKartListeFrame;
import UI.StokKartiFrame;

public class KartIslemController implements ActionListener{

	private CartFrame cartUI;
	private StokKartiFrame kayit;
	private Sonraki sonraki;
	private Son son;
	private Onceki onceki;
	public StokSaveController saveController;
	public StokDeleteController deleteController;
	private StokKartListeFrame list;
	private StokKartPopup stokKarttt;
	private Cart cart;
	
	public KartIslemController(CartFrame cartUI) {
		this.cartUI = cartUI;
		
	}
	
	public void KartIslem() throws ParseException {
		StokKartiFrame kayit = new StokKartiFrame();
		cartUI.desktopPane.add(kayit);
		kayit.show();
		kayit.setRow(cart);
		
		Onceki onceki = new Onceki(kayit);
		kayit.btnOnceki.addActionListener(onceki);
		Son son = new Son(kayit);
		kayit.btnSon.addActionListener(son);
		Ilk ilk = new Ilk(kayit);
		kayit.btnIlk.addActionListener(ilk);
		Sonraki sonraki = new Sonraki(kayit);
		kayit.btnSonraki.addActionListener(sonraki);
		saveController = new StokSaveController(kayit);
		kayit.ekle.addActionListener(saveController);
		deleteController= new StokDeleteController(kayit);
		kayit.sil.addActionListener(deleteController);
		
		
		
		
		
		
		
		
		
		
		
		
		kayit.stkkodu.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				Cart cart = new Cart("");
				kayit.setData(cart.getByStokKodu(kayit.kod()));
				
				
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			KartIslem();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void setCart(Cart cart) {
		this.cart =cart;
		}
	
	
	
	
	
}
