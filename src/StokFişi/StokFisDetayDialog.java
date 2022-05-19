package StokFişi;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.Cart;
import TableModel.StokFisDetayTableModel;
import UI.StokKartListeFrame;
import UI.StokKartiFrame;

public class StokFisDetayDialog extends JDialog {
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
	public StokFisDetayTableModel model;
	
	
	
	public StokFisDetayDialog() {
		setBounds(100, 100, 900, 520);
		table = new JTable();
		try {
			cartlar = new Cart("").getCart();
			setTableData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setVisible(true);
		
		
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 731, 450);
		getContentPane().add(scrollPane);
		
		
		
		scrollPane.setViewportView(table);
		
		
		

		
//		Listele = new JButton("Listele");
//		Listele.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
//		Listele.setBounds(757, 95, 90, 33);
//		getContentPane().add(Listele);
		
		
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
	
	public String stokKoduu() {
		return table.getValueAt(table.getSelectedRow(), 0).toString();
	}


	
	
	
}
