package UI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.KartIslemController;
import Controller.ListeleController;
import Model.Cart;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.JMenuItem;

public class StokKartListeFrame extends JInternalFrame {
	public JTable table;
	public JTextField arama;
	private Cart cart;
	public ArrayList<Cart> cartlar;
	public JButton Listele;
	public JScrollPane scrollPane;
	public JMenuItem excel;
	public JMenuItem btnreport;
	public JMenuItem btnmail;
	public JMenuItem btnstokkart;
	private StokKartiFrame stokKarti;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StokKartListeFrame frame = new StokKartListeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StokKartListeFrame() {
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("Liste");
		setBounds(100, 100, 895, 499);
		getContentPane().setLayout(null);
		
		
		
		table = new JTable();
		try {
			cartlar = new Cart("").getCart();
			setTableData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setVisible(false);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 731, 450);
		getContentPane().add(scrollPane);
		
		
		
		scrollPane.setViewportView(table);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);
		
		btnstokkart = new JMenuItem("Stok Kart");
		popupMenu.add(btnstokkart);
		
		btnreport = new JMenuItem("Stok Listele");
		popupMenu.add(btnreport);
		
		excel = new JMenuItem("Excel'e Aktar");
		popupMenu.add(excel);
		
		btnmail = new JMenuItem("Mail G\u00F6nder");
		popupMenu.add(btnmail);
		
		arama = new JTextField();
		
		arama.setBounds(751, 42, 96, 19);
		getContentPane().add(arama);
		arama.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ara");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNewLabel.setBounds(751, 10, 45, 33);
		getContentPane().add(lblNewLabel);
		
		Listele = new JButton("Listele");
		Listele.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		Listele.setBounds(757, 95, 90, 33);
		getContentPane().add(Listele);
		
		

	}
	public void setTableData() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] baslik = {"Stok Kodu","Stok Adı","Stok Tipi","Birimi","Barkodu","KDV Tipi","Açıklama","Tarih"};
		Object[][] veri = new Object[cartlar.size()][8];
		
		for(int i=0;i<cartlar.size();i++) {
			veri[i][0] = cartlar.get(i).getStokKodu();
			veri[i][1] = cartlar.get(i).getStokAdi();
			veri[i][2] = cartlar.get(i).getStokTipi();
			veri[i][3] = cartlar.get(i).getBirimi();
			veri[i][4] = cartlar.get(i).getBarkodu();
			veri[i][5] = cartlar.get(i).getKdvTipi();
			veri[i][6] = cartlar.get(i).getAciklama();
			veri[i][7] = cartlar.get(i).getOlusturmaTarihi();
		}
		
		table.setModel(new DefaultTableModel(veri,baslik));
		
	}
	public void addRow(Cart cart) {
		cartlar.add(cart);
		setTableData();
	}
	
	public void removeRow(Cart cart) {
		int secilen = table.getSelectedRow();
		cartlar.remove(secilen);
		setTableData();
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public void ShowReport() {
		
		try {
		
	        JasperReport jreport = (JasperReport)JRLoader.loadObject(new File("reporte.jasper"));
	        JRBeanCollectionDataSource jcs = new JRBeanCollectionDataSource(cartlar);
	        JasperPrint jprint = JasperFillManager.fillReport(jreport, null, jcs);

	        JasperViewer.viewReport(jprint, false);
		} catch (Exception e) {                           
			e.printStackTrace();
		}
        		
	}
	
	

	
	
	
	
	
	
	
}
