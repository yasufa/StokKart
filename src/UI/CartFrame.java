package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.Cart;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;

public class CartFrame extends JFrame {

	private JPanel contentPane;
	private Cart cart;
	ArrayList<Cart> cartlar;
	public JMenuItem btnkartIslem;
	public JDesktopPane desktopPane;
	public JMenuItem liste;
	public JMenuItem kdvekle;
	public JMenuItem kllnıcıekle;
	public JMenuItem carikart;
	public JMenuItem btndepo;
	private JMenu mnNewMenu_4;
	public
	JMenuItem stokfis;
	
	
	public CartFrame() {
		setTitle("Stok Kart Y\u00F6netim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1151, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			cartlar = new Cart("").getCart();
			setTableData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1006, 32);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Stok Kart");
		menuBar.add(mnNewMenu);
		
		btnkartIslem = new JMenuItem("Stok Kart");
		
		mnNewMenu.add(btnkartIslem);
		
		liste = new JMenuItem("Liste");
		mnNewMenu.add(liste);
		
		kdvekle = new JMenuItem("KDV Tipi ");
		mnNewMenu.add(kdvekle);
		
		JMenu mnNewMenu_2 = new JMenu("Cari Kart");
		menuBar.add(mnNewMenu_2);
		
		carikart = new JMenuItem("Cari Kart");
		mnNewMenu_2.add(carikart);
		
		JMenu mnNewMenu_3 = new JMenu("Depo Kart");
		menuBar.add(mnNewMenu_3);
		
		btndepo = new JMenuItem("Depo Kart");
		mnNewMenu_3.add(btndepo);
		
		mnNewMenu_4 = new JMenu("Stok Fişi");
		menuBar.add(mnNewMenu_4);
		
		stokfis = new JMenuItem("Stok Fişi");
		mnNewMenu_4.add(stokfis);
		
		JMenu mnNewMenu_1 = new JMenu("Kullanıcı İşlemleri");
		menuBar.add(mnNewMenu_1);
		
		kllnıcıekle = new JMenuItem("Kullanıcı Ekle");
		mnNewMenu_1.add(kllnıcıekle);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(10, 42, 1111, 578);
		contentPane.add(desktopPane);
	}
	
//	public String getStokKodu() {
//		return String.valueOf(txtsil.getText());
//	}
//	
//	public Cart getData() {
//		return new Cart(txtstkkodu.getText(),txtstkadi.getText(),comstktipi.getSelectedItem().toString(),combirimi.getSelectedItem().toString(),txtbarkodu.getText(),comkdvtipi.getSelectedItem().toString(),textArea.getText(),txttarih.getText());
//	}
	
	
	public void setTableData() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] baslik = {"Stok Kodu","Stok Adi","Stok Tipi","Birimi","Barkodu","KDV Tipi","A��klama","Tarih"};
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
		
	}

	public void addRow(Cart cart) {
		cartlar.add(cart);
		setTableData();
	}
}
