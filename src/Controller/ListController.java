package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import PopupMenuButonlari.ExcelAktar;
import PopupMenuButonlari.Jasper;
import PopupMenuButonlari.Mail;
import PopupMenuButonlari.StokKartPopup;
import UI.CartFrame;
import UI.StokKartListeFrame;
import UI.StokKartiFrame;

public class ListController implements ActionListener{

	private CartFrame cartUI;
	private StokKartListeFrame list;
	private ListeleController listeleController;
	private ExcelAktar excelAktar;
	private Jasper jasper;
	private Mail mail;
	private StokKartPopup stokKarttt;
	
	public ListController(CartFrame cartUI) {
		this.cartUI = cartUI;
	}
	
	public void Listee() {
		StokKartListeFrame list = new StokKartListeFrame();
		cartUI.desktopPane.add(list);
		list.show();
		
		listeleController = new ListeleController(list);
		list.Listele.addActionListener(listeleController);
		
		excelAktar = new ExcelAktar(list);
		list.excel.addActionListener(excelAktar);
		
		jasper = new Jasper(list);
		list.btnreport.addActionListener(jasper);
		
		mail = new Mail(list);
		list.btnmail.addActionListener(mail);
		
		stokKarttt = new StokKartPopup(list, cartUI);
		list.btnstokkart.addActionListener(stokKarttt);
		
		
		
		
		
		
		list.arama.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) list.table.getModel();
				String kelime = list.arama.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
				list.table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(kelime, 0));
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Listee();
		
	}
	
	

}
