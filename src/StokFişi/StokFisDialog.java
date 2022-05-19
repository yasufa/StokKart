package StokFişi;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Cart;
import Model.StokFisi;
import UI.StokFisiFrame;

public class StokFisDialog extends JDialog {

	public JTable table;
	public JScrollPane scrollPane;
	public List<StokFisi> fisler;
	public StokFisiFrame stokFisiFrame;
	
	
	public StokFisDialog(StokFisiFrame stokFisiFrame) {
		setBounds(100,100,900,520);
		
		
		table = new JTable();
		fisler = new StokFisi("").getStokFisi();
		
		setTableData();
		table.setVisible(true);
		
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			StokFisi fis = fisler.get(table.getSelectedRow());
			stokFisiFrame.setFisData(fis);	
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
	
	public void setTableData() {
		
		Object[] baslik = {"Fiş No", "Cari","Depo","Tarih"};
		Object[][]  veri = new Object[fisler.size()][4];
		
		for(int i =0;i<fisler.size();i++) {
			veri[i][0] = fisler.get(i).getFisNo();
			veri[i][1] = fisler.get(i).getCari();
			veri[i][2] = fisler.get(i).getDepo();
			veri[i][3] = fisler.get(i).getTarih();
		}
		table.setModel(new DefaultTableModel(veri,baslik));
		
	}
}
