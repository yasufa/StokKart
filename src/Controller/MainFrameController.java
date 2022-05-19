package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import CariController.CariKartController;
import DepoController.DepoKartController;
import Model.Cart;
import StokFişi.StokFisiController;
import UI.CartFrame;
import UI.StokKartListeFrame;
import UI.StokKartiFrame;

public class MainFrameController implements ActionListener {

	private CartFrame cartUI;
	private Cart cart;
	private StokKartiFrame stokKarti;
	public StokSaveController saveController;
	public StokDeleteController deleteController;
	public KartIslemController islemController;
	public ListController listController;
	public KdvTipiController kdvTipiController;
	public KullaniciController kullaniciController;
	public CariKartController cariController;
	public DepoKartController depoController;
	public StokFisiController fisController;
	
	public MainFrameController() {
		
		cartUI = new CartFrame();
		fisController = new StokFisiController(cartUI);
		depoController = new DepoKartController(cartUI);
		islemController = new KartIslemController(cartUI);
		listController = new ListController(cartUI);
		kdvTipiController = new KdvTipiController(cartUI);
		kullaniciController = new KullaniciController(cartUI);
		cariController = new CariKartController(cartUI);
		cartUI.btnkartIslem.addActionListener(islemController);
		cartUI.liste.addActionListener(listController);
		cartUI.kdvekle.addActionListener(kdvTipiController);
		cartUI.kllnıcıekle.addActionListener(kullaniciController);
		cartUI.carikart.addActionListener(cariController);
		cartUI.btndepo.addActionListener(depoController);
		cartUI.stokfis.addActionListener(fisController);
			
		
		cartUI.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	



	
		
	
	

	
	
	
}
