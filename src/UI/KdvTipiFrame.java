package UI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import Model.Kdvtipi;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class KdvTipiFrame extends JInternalFrame {
	private JTextField txtkdv;
	public JButton btnEkle;
	public JButton btnSil;

	public KdvTipiFrame() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("KDV Tipi");
		setBounds(100, 100, 450, 294);
		getContentPane().setLayout(null);
		
		txtkdv = new JTextField();
		txtkdv.setBounds(136, 39, 123, 24);
		getContentPane().add(txtkdv);
		txtkdv.setColumns(10);
		
		btnEkle = new JButton("Ekle");
		btnEkle.setBounds(136, 80, 121, 32);
		getContentPane().add(btnEkle);
		
		btnSil = new JButton("Sil");
		btnSil.setBounds(136, 122, 121, 32);
		getContentPane().add(btnSil);
		
		JLabel lblNewLabel = new JLabel("KDV Tipi Gir");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNewLabel.setBounds(30, 38, 96, 19);
		getContentPane().add(lblNewLabel);

	}
	
	public Kdvtipi getData() {
		return new Kdvtipi(txtkdv.getText());
	}
	
	public String getKdvTipi() {
		return String.valueOf(txtkdv.getText());
	}
}
