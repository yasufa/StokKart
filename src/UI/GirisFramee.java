package UI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GirisFramee extends JFrame {

	private JPanel contentPane;
	public JTextField txtkullanici;
	public JPasswordField txtparola;
	public JButton btngiris;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisFramee frame = new GirisFramee();
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
	public GirisFramee() {
		setTitle("Stok Kart ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullanıcı Adı ");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNewLabel.setBounds(108, 135, 116, 26);
		contentPane.add(lblNewLabel);
		
		txtkullanici = new JTextField();
		txtkullanici.setBounds(259, 137, 116, 22);
		contentPane.add(txtkullanici);
		txtkullanici.setColumns(10);
		
		JLabel lblParola = new JLabel(" Parola");
		lblParola.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblParola.setBounds(108, 174, 116, 26);
		contentPane.add(lblParola);
		
		btngiris = new JButton("Giriş Yap");
		btngiris.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		btngiris.setBounds(259, 226, 116, 25);
		contentPane.add(btngiris);
		
		txtparola = new JPasswordField();
		txtparola.setBounds(259, 178, 116, 22);
		contentPane.add(txtparola);
	}
}
