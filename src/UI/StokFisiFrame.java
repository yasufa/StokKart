package UI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.*;

import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Model.CariKart;
import Model.ParaBirimi;
import Model.StokFisi;
import Model.StokFisiDetay;
import StokFişi.ParaBirimiCellEditor;
import StokFişi.ParaBirimiCellRenderer;
import TableModel.MyTableModelListener;
import TableModel.StokFisDetayTableModel;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StokFisiFrame extends JInternalFrame  {
	public JTable table;
	public JTextField fisno;
	public JTextField cari;
	public JTextField depo;
	public List<StokFisiDetay> detaylar;
	public JFormattedTextField tarih;
	public JButton ilk;
	public JButton son;
	public JButton geri;
	public JButton ileri;
	public JButton yenile;
	public StokFisiDetay stokFisiDetay;
	public StokFisDetayTableModel stokFisTableModel;
	public List<ParaBirimi> listParaBirimi;
	public List<CariKart> cariler;
	public JButton buyutec;
	public JButton caribuyutec;
	public JButton fissil;
	public JButton kaydet;
	 
	
	
	public StokFisiFrame() {
		setResizable(true);
		stokFisTableModel = new StokFisDetayTableModel();
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Stok Fişi");
		setBounds(100, 100, 971, 510);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(12, 203, 931, 258);
		getContentPane().add(scrollPane);
		
		listParaBirimi = new ArrayList<>();
		listParaBirimi.add(new ParaBirimi("TL"));
		listParaBirimi.add(new ParaBirimi("USD"));
		listParaBirimi.add(new ParaBirimi("EURO"));
		
		table = new JTable();
		table.setModel(stokFisTableModel);
		
		table.addMouseListener(stokFisTableModel);
		
		TableColumnModel colmod = table.getColumnModel();
		TableColumn para = colmod.getColumn(3);
		para.setPreferredWidth(100);
		
		

		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Fiş No:");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNewLabel.setBounds(28, 79, 85, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCari = new JLabel("Cari:");
		lblCari.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblCari.setBounds(28, 109, 85, 22);
		getContentPane().add(lblCari);
		
		JLabel lblDepo = new JLabel("Depo:");
		lblDepo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblDepo.setBounds(28, 138, 85, 22);
		getContentPane().add(lblDepo);
		
		fisno = new JTextField();
		fisno.setBounds(125, 79, 116, 23);
		getContentPane().add(fisno);
		fisno.setColumns(10);
		
		cari = new JTextField();
		cari.setColumns(10);
		cari.setBounds(125, 111, 119, 22);
		getContentPane().add(cari);
		
		depo = new JTextField();
		depo.setColumns(10);
		depo.setBounds(125, 140, 116, 22);
		getContentPane().add(depo);
		
		tarih = new JFormattedTextField();
		tarih.setBounds(125, 168, 116, 22);
		getContentPane().add(tarih);
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblTarih.setBounds(28, 168, 85, 22);
		getContentPane().add(lblTarih);
		
		geri = new JButton("");
		geri.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\images\\geri.png"));
		geri.setBounds(73, 25, 33, 30);
		getContentPane().add(geri);
		
		ileri = new JButton("");
		ileri.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\images\\ileri.png"));
		ileri.setBounds(163, 25, 33, 30);
		getContentPane().add(ileri);
		
		son = new JButton("");
		son.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\images\\son.png"));
		son.setBounds(208, 25, 33, 30);
		getContentPane().add(son);
		
		ilk = new JButton("");
		ilk.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\images\\ilk.png"));
		ilk.setBounds(28, 25, 33, 30);
		getContentPane().add(ilk);
		
		yenile = new JButton("");
		yenile.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\images\\yenile.jpg"));
		yenile.setBounds(118, 25, 33, 30);
		getContentPane().add(yenile);
		
		buyutec = new JButton("");
		buyutec.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\images\\buyutec.png"));
		buyutec.setBounds(263, 79, 26, 25);
		getContentPane().add(buyutec);
		
		caribuyutec = new JButton("");
		caribuyutec.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\images\\buyutec.png"));
		caribuyutec.setBounds(263, 109, 26, 25);
		getContentPane().add(caribuyutec);
		
		fissil = new JButton("");
		fissil.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\images\\sill.jpg"));
		fissil.setBounds(253, 25, 33, 30);
		getContentPane().add(fissil);
		
		kaydet = new JButton("");
		kaydet.setIcon(new ImageIcon("C:\\Users\\yusuf\\OneDrive\\Masaüstü\\images\\save.png"));
		kaydet.setBounds(298, 25, 33, 30);
		getContentPane().add(kaydet);

	}

	
	
	public void setFisData(StokFisi stokFisi) {
		
		stokFisTableModel.fireTableDataChanged();
		if (stokFisi == null) return;
		this.fisno.setText(stokFisi.getFisNo());
		this.cari.setText(stokFisi.getCari());
		this.depo.setText(stokFisi.getDepo());
		this.tarih.setText(stokFisi.getTarih());
		
		StokFisiDetay stokFisiDetay = new StokFisiDetay();
		stokFisTableModel.setList(stokFisiDetay.getDetayy(stokFisi.getFisNo()));
		if(stokFisTableModel.getRowCount() == 0) {
			stokFisTableModel.addRow(stokFisiDetay);
			
		}
		
		table.setModel(stokFisTableModel);

		
		TableColumn column = table.getColumnModel().getColumn(3);
		column.setCellEditor(new ParaBirimiCellEditor(listParaBirimi));
		column.setCellRenderer(new ParaBirimiCellRenderer(listParaBirimi));	
	}
	public void insertt() {
		String fisNoo = table.getValueAt(table.getSelectedRow(), 0).toString();
		String carii = table.getValueAt(table.getSelectedRow(), 1).toString();
		String depoo = table.getValueAt(table.getSelectedRow(), 2).toString();
		String tarihh = table.getValueAt(table.getSelectedRow(), 3).toString();
		
		
		
	}
	
	
	
	public void fieldNull() {
		fisno.setText(null);
		cari.setText(null);
		depo.setText(null);
		tarih.setText(null);
	}
	
	public void setCari(CariKart cariKart) {
		this.cari.setText(cariKart.getCariKodu());
	}
	
	public String kod() {
		return fisno.getText();
	}
	
	public StokFisi getData() {
		return new StokFisi("",fisno.getText(),cari.getText(),depo.getText(),tarih.getText());
	}
	
	
}
