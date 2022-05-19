package UI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Model.DepoKart;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class DepoKartFrame extends JInternalFrame {
	public JTextField depokodu;
	public JTextField depoadi;
	public JButton ekle;
	public JButton sil;
	public JButton ilk;
	public JButton son;
	public JButton ileri;
	public JButton geri;

	public DepoKartFrame() {
		setTitle("Depo Karı");
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 472, 316);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Depo Kodu");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNewLabel.setBounds(83, 144, 101, 22);
		getContentPane().add(lblNewLabel);
		
		depokodu = new JTextField();
		depokodu.setBounds(221, 146, 116, 22);
		getContentPane().add(depokodu);
		depokodu.setColumns(10);
		
		JLabel lblDepoAd = new JLabel("Depo Adı");
		lblDepoAd.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblDepoAd.setBounds(83, 181, 101, 22);
		getContentPane().add(lblDepoAd);
		
		depoadi = new JTextField();
		depoadi.setColumns(10);
		depoadi.setBounds(221, 183, 116, 22);
		getContentPane().add(depoadi);
		
		ilk = new JButton("");
		ilk.setBackground(Color.WHITE);
		ilk.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\ilk.png"));
		ilk.setBounds(12, 23, 69, 31);
		getContentPane().add(ilk);
		
		geri = new JButton("");
		geri.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\geri.png"));
		geri.setBounds(100, 23, 69, 31);
		getContentPane().add(geri);
		
		son = new JButton("");
		son.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\son.png"));
		son.setBounds(375, 23, 69, 31);
		getContentPane().add(son);
		
		ileri = new JButton("");
		ileri.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\ileri.png"));
		ileri.setBounds(291, 23, 69, 31);
		getContentPane().add(ileri);
		
		ekle = new JButton("");
		ekle.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\download (1) (1) (1).jpg"));
		ekle.setBounds(199, 10, 57, 44);
		getContentPane().add(ekle);
		
		sil = new JButton("");
		sil.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\sil (2).jpg"));
		sil.setBounds(199, 67, 57, 44);
		getContentPane().add(sil);

	}
	
	public DepoKart getData() {
		return new DepoKart(depokodu.getText(),depoadi.getText());
	}
	
	public String getDepoKodu() {
		return String.valueOf(depokodu.getText());
	}
	
	public void setData(DepoKart depoKart) {
		if(depoKart == null) return;
		this.depokodu.setText(depoKart.getDepoKodu());
		this.depoadi.setText(depoKart.getDepoAdi());
	}
	public String kod() {
		return depokodu.getText();
	}
}
