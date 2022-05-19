package UI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.Giris;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class KullaniciFrame extends JInternalFrame {
	public JTextField txtkullanici;
	public JPasswordField txtparola;
	public JButton btnNewButton;

	public KullaniciFrame() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Kullanıcı Ekle");
		setBounds(100, 100, 552, 388);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullanıcı Adı");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNewLabel.setBounds(133, 63, 99, 26);
		getContentPane().add(lblNewLabel);
		
		txtkullanici = new JTextField();
		txtkullanici.setBounds(261, 63, 116, 26);
		getContentPane().add(txtkullanici);
		txtkullanici.setColumns(10);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblParola.setBounds(133, 102, 99, 26);
		getContentPane().add(lblParola);
		
		txtparola = new JPasswordField();
		txtparola.setBounds(261, 102, 116, 24);
		getContentPane().add(txtparola);
		
		btnNewButton = new JButton("Ekle");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		btnNewButton.setBounds(261, 151, 116, 39);
		getContentPane().add(btnNewButton);

	}
	
	public Giris getData() {
		return new Giris(txtkullanici.getText(),txtparola.getText());
	}

}
