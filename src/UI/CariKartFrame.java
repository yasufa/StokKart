package UI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Model.CariKart;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CariKartFrame extends JInternalFrame {
	public JTextField carikodu;
	public JTextField cariadi;
	public JTextField kisaadi;
	public JTextArea adresi;
	public JButton ilk;
	public JButton son;
	public JButton ileri;
	public JButton geri;
	public JButton ekle;
	public JButton sil;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CariKartFrame frame = new CariKartFrame();
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
	public CariKartFrame() {
		setTitle("Cari Kart");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 525, 498);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cari Kodu");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNewLabel.setBounds(67, 170, 95, 23);
		getContentPane().add(lblNewLabel);
		
		carikodu = new JTextField();
		carikodu.setBounds(212, 170, 116, 23);
		getContentPane().add(carikodu);
		carikodu.setColumns(10);
		
		JLabel lblCariAd = new JLabel("Cari Adı");
		lblCariAd.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblCariAd.setBounds(67, 206, 95, 23);
		getContentPane().add(lblCariAd);
		
		cariadi = new JTextField();
		cariadi.setColumns(10);
		cariadi.setBounds(212, 206, 116, 23);
		getContentPane().add(cariadi);
		
		JLabel lblKsaAd = new JLabel("Kısa Adı");
		lblKsaAd.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblKsaAd.setBounds(67, 242, 95, 23);
		getContentPane().add(lblKsaAd);
		
		kisaadi = new JTextField();
		kisaadi.setColumns(10);
		kisaadi.setBounds(212, 242, 116, 23);
		getContentPane().add(kisaadi);
		
		JLabel lblAdresi = new JLabel("Adresi");
		lblAdresi.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblAdresi.setBounds(67, 278, 95, 23);
		getContentPane().add(lblAdresi);
		
		adresi = new JTextArea();
		adresi.setBounds(212, 285, 116, 44);
		getContentPane().add(adresi);
		
		ilk = new JButton("");
		ilk.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\ilk.png"));
		ilk.setBounds(25, 26, 68, 30);
		getContentPane().add(ilk);
		
		geri = new JButton("");
		geri.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\geri.png"));
		geri.setBounds(115, 26, 68, 30);
		getContentPane().add(geri);
		
		ileri = new JButton("");
		ileri.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\ileri.png"));
		ileri.setBounds(301, 26, 68, 30);
		getContentPane().add(ileri);
		
		ekle = new JButton("");
		ekle.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\download (1) (1) (1).jpg"));
		ekle.setBounds(223, 26, 56, 44);
		getContentPane().add(ekle);
		
		son = new JButton("");
		son.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\son.png"));
		son.setBounds(406, 26, 68, 30);
		getContentPane().add(son);
		
		sil = new JButton("");
		sil.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\sil (2).jpg"));
		sil.setBounds(223, 92, 56, 39);
		getContentPane().add(sil);

	}
	public CariKart getData() {
		return new CariKart(carikodu.getText(),cariadi.getText(),kisaadi.getText(),adresi.getText());
	}
	
	public String getCariKodu() {
		return String.valueOf(carikodu.getText());
	}
	
	public void  setData(CariKart cariKart) {
		if(cariKart == null) return;
		this.carikodu.setText(cariKart.getCariKodu());
		this.cariadi.setText(cariKart.getCariAdi());
		this.kisaadi.setText(cariKart.getKisaAdi());
		this.adresi.setText(cariKart.getAdresi());
	}
	
	public String kodu() {
		return carikodu.getText();
	}
	
	
	
	
}
