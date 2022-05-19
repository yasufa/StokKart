package StokFişi;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.CariKart;
import Model.StokFisi;
import UI.StokFisiFrame;

public class StokFisCariDialog extends JDialog {

	public JTable table;
	public JScrollPane scrollPane;
	public List<CariKart> cariler;
	public StokFisiFrame stokFisiFrame;
	
	public StokFisCariDialog(StokFisiFrame stokFisiFrame) {
		setBounds(100,100,900,520);
		
		table = new JTable();
		cariler = new CariKart("").getCari();
		SetTableData();
		table.setVisible(true);
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CariKart cariKart = cariler.get(table.getSelectedRow());
				
				stokFisiFrame.setCari(cariKart);
				
				dispose();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 731, 450);
		getContentPane().add(scrollPane);
		
		
		
		scrollPane.setViewportView(table);
	}
	
	public void SetTableData() {
		Object[] baslik = {"Cari Kodu","Cari Adı","Kısa Adı","Adres"};
		Object[][] veri = new Object[cariler.size()][4];
		
		for(int i =0;i<cariler.size();i++) {
			veri[i][0] = cariler.get(i).getCariKodu();
			veri[i][1] = cariler.get(i).getCariAdi();
			veri[i][2] = cariler.get(i).getKisaAdi();
			veri[i][3] = cariler.get(i).getAdresi();
		}
		table.setModel(new DefaultTableModel(veri, baslik));
	}
	
	
	
}
