package UI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Model.Cart;
import Model.Kdvtipi;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class StokKartiFrame extends JInternalFrame {
	public JTextField stkkodu;
	public JTextField stkadi;
	public JTextField barkodu;
	public JButton sil;
	public JButton ekle;
	public JComboBox stktipi;
	public JComboBox birimi;
	public JComboBox kdvtipi;
	public JTextArea aciklama;
	public JFormattedTextField tarih;
	public JButton btnOnceki;
	public JButton btnSonraki;
	public JButton btnSon;
	public JButton btnIlk;
	private StokKartListeFrame list;
	
	public StokKartiFrame() throws ParseException {
		setTitle("Stok Kart\u0131");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 484, 493);
		getContentPane().setLayout(null);
		
		JLabel lblStokKodu = new JLabel("Stok Kodu");
		lblStokKodu.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblStokKodu.setBounds(97, 155, 96, 28);
		getContentPane().add(lblStokKodu);
		
		stkkodu = new JTextField();
		stkkodu.setColumns(10);
		stkkodu.setBounds(223, 159, 112, 27);
		getContentPane().add(stkkodu);
		
		JLabel lblStokAd = new JLabel("Stok Ad\u0131");
		lblStokAd.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblStokAd.setBounds(97, 195, 96, 28);
		getContentPane().add(lblStokAd);
		
		stkadi = new JTextField();
		stkadi.setColumns(10);
		stkadi.setBounds(223, 199, 112, 27);
		getContentPane().add(stkadi);
		
		JLabel lblStokTipi = new JLabel("Stok Tipi");
		lblStokTipi.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblStokTipi.setBounds(97, 228, 96, 28);
		getContentPane().add(lblStokTipi);
		
		stktipi = new JComboBox();
		stktipi.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		stktipi.setBounds(223, 235, 112, 21);
		getContentPane().add(stktipi);
		
		JLabel lblBirimi = new JLabel("Birimi");
		lblBirimi.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblBirimi.setBounds(97, 261, 96, 28);
		getContentPane().add(lblBirimi);
		
		birimi = new JComboBox();
		birimi.setModel(new DefaultComboBoxModel(new String[] {"a", "b", "c"}));
		birimi.setBounds(223, 265, 112, 21);
		getContentPane().add(birimi);
		
		JLabel lblBarkodu = new JLabel("Barkodu");
		lblBarkodu.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblBarkodu.setBounds(97, 293, 96, 28);
		getContentPane().add(lblBarkodu);
		
		barkodu = new JTextField();
		barkodu.setColumns(10);
		barkodu.setBounds(223, 297, 112, 27);
		getContentPane().add(barkodu);
		
		JLabel lblBarkodu_1 = new JLabel("KDV Tipi");
		lblBarkodu_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblBarkodu_1.setBounds(97, 325, 96, 28);
		getContentPane().add(lblBarkodu_1);
		
		Kdvtipi kdv = new Kdvtipi("");
		kdvtipi = new JComboBox(kdv.getByDeger().toArray());
		kdvtipi.setBounds(223, 332, 112, 21);
		getContentPane().add(kdvtipi);
		
		JLabel lblBarkodu_1_1 = new JLabel("A\u00E7\u0131klama");
		lblBarkodu_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblBarkodu_1_1.setBounds(97, 366, 96, 28);
		getContentPane().add(lblBarkodu_1_1);
		
		aciklama = new JTextArea();
		aciklama.setBounds(223, 366, 112, 39);
		getContentPane().add(aciklama);
		
		JLabel lblBarkodu_1_2 = new JLabel("Tarih");
		lblBarkodu_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblBarkodu_1_2.setBounds(97, 418, 96, 26);
		getContentPane().add(lblBarkodu_1_2);
		
		MaskFormatter mf = new MaskFormatter("####-##-##");
		tarih = new JFormattedTextField(mf);
		tarih.setBounds(218, 421, 112, 23);
		getContentPane().add(tarih);
		
		ekle = new JButton();
		ekle.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\download (1) (1) (1).jpg"));
		ekle.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		ekle.setBounds(197, 10, 57, 39);
		getContentPane().add(ekle);
		
		sil = new JButton();
		sil.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\sil (2).jpg"));
		sil.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		sil.setBounds(197, 69, 57, 39);
		getContentPane().add(sil);
		
		
		btnOnceki = new JButton();
		btnOnceki.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOnceki.setBounds(97, 10, 69, 29);
		getContentPane().add(btnOnceki);
		btnOnceki.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\geri.png"));
		
		btnSonraki = new JButton();
		btnSonraki.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\ileri.png"));
		btnSonraki.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSonraki.setBounds(276, 11, 81, 28);
		getContentPane().add(btnSonraki);
		
		
		btnSon = new JButton();
		btnSon.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\son.png"));
		btnSon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSon.setBounds(375, 11, 81, 28);
		getContentPane().add(btnSon);
		
		
		
		btnIlk = new JButton();
		btnIlk.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\ilk.png"));
		btnIlk.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIlk.setBounds(10, 10, 69, 28);
		getContentPane().add(btnIlk);
		

	}
	
	public Cart getData() {
		return new Cart(stkkodu.getText(),stkadi.getText(),stktipi.getSelectedItem().toString(),birimi.getSelectedItem().toString(),barkodu.getText(),kdvtipi.getSelectedItem().toString(),aciklama.getText(),tarih.getText());
	}
	
	public String getStokKodu() {
		return String.valueOf(stkkodu.getText());
	}
	
	public void setData(Cart cart) {
		if (cart == null) return;
		this.stkkodu.setText(cart.getStokKodu());
		this.stkadi.setText(cart.getStokAdi());
		this.stktipi.setSelectedItem(cart.getStokTipi());
		this.birimi.setSelectedItem(cart.getBirimi());
		this.barkodu.setText(cart.getBarkodu());
		this.kdvtipi.setSelectedItem(cart.getKdvTipi());
		this.aciklama.setText(cart.getAciklama());
		this.tarih.setText(cart.getOlusturmaTarihi());
	}
	
	public String kod() {
		return stkkodu.getText();
	}
	
	public void setRow(Cart cart) {
		if (cart == null) return;
		stkkodu.setText(cart.getStokKodu());
		stkadi.setText(cart.getStokAdi());
		stktipi.setSelectedItem(cart.getStokTipi());
		birimi.setSelectedItem(cart.getBirimi());
		barkodu.setText(cart.getBarkodu());
		kdvtipi.setSelectedItem(cart.getKdvTipi());
		aciklama.setText(cart.getAciklama());
		tarih.setText(cart.getOlusturmaTarihi());
		
	}
	
	
}
