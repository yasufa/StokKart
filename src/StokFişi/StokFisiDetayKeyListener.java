package StokFişi;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import Model.ParaBirimi;
import Model.StokFisiDetay;
import TableModel.StokFisDetayTableModel;
import UI.StokFisiFrame;

public class StokFisiDetayKeyListener implements KeyListener{

	
	private StokFisiFrame stokFisiUI;
	
	private StokFisDetayTableModel model;
	
	
	
	public StokFisiDetayKeyListener(StokFisiFrame stokFisiUI,StokFisDetayTableModel model) {
		this.stokFisiUI = stokFisiUI;
		this.model = model;
	}
	
	
	public void keyListener() {

		
		StokFisiDetay stok = new StokFisiDetay();
		stok.setStokFisiId(stokFisiUI.fisno.getText());
		
		model.addRow(stok);
		
		stokFisiUI.table.setModel(model);
		
		
		
		//stok.insertDetay(stok);
		
        
		
		
	}

	

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_DOWN ) {
			keyListener();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
