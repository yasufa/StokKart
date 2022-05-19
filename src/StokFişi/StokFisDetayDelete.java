package StokFişi;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Model.StokFisiDetay;
import TableModel.StokFisDetayTableModel;
import UI.StokFisiFrame;

public class StokFisDetayDelete implements KeyListener{
	
	private StokFisiFrame stokFisiFrame;
	private StokFisDetayTableModel model;
	
	public StokFisDetayDelete(StokFisiFrame stokFisiFrame,StokFisDetayTableModel model) {
		this.stokFisiFrame = stokFisiFrame;
		this.model = model;
	}
	
	public void remove() {
		StokFisiDetay stok = model.detaylar.get(stokFisiFrame.table.getSelectedRow());
		int row = stokFisiFrame.table.getSelectedRow();
		 int rr= 	JOptionPane.showConfirmDialog(null, "Silmek istediğinize emin misiniz?","Dikkat!",JOptionPane.YES_NO_OPTION);
		 if(rr==1) {
			 return;
		 }	
		model.removeRow(row);
		stok.deleteDetay(stok);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_DELETE) {
		  
		  
			remove();
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
