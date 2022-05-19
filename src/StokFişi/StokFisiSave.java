package StokFişi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.StokFisi;
import Model.StokFisiDetay;
import UI.StokFisiFrame;

public class StokFisiSave implements ActionListener{
	
	private StokFisiFrame stokFisiFrame;
	
	public StokFisiSave(StokFisiFrame stokFisiFrame) {
		this.stokFisiFrame = stokFisiFrame;
	}
	
	public void save(StokFisi stokFisi) {
		//stokFisi.insertFis();
		if(stokFisi.getByFisNo(stokFisi.getFisNo()) == null) {
			stokFisi.insertFis();
			JOptionPane.showMessageDialog(null, "Stok Fişi Eklendi");
		}
		else{
			stokFisi.updateStokFisi();
			
			
			if(stokFisiFrame.table.getValueAt(stokFisiFrame.table.getSelectedRow(), 0).toString() != null) {
				
				String kodu = stokFisiFrame.table.getValueAt(stokFisiFrame.table.getSelectedRow(), 0).toString();
				String miktarr = stokFisiFrame.table.getValueAt(stokFisiFrame.table.getSelectedRow(), 1).toString();
				String fiyatt = stokFisiFrame.table.getValueAt(stokFisiFrame.table.getSelectedRow(), 2).toString();		
				String paraa = stokFisiFrame.table.getValueAt(stokFisiFrame.table.getSelectedRow(), 3) != null ? stokFisiFrame.table.getValueAt(stokFisiFrame.table.getSelectedRow(), 3).toString() : 	"TL";
				
				StokFisiDetay detay = new StokFisiDetay(stokFisiFrame.fisno.getText(),kodu,miktarr,fiyatt,paraa);
				detay.insertDetay(detay);
				
				
			}

			JOptionPane.showMessageDialog(null, "Stok Fişi güncellendi");

	    }
	
	
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		save(stokFisiFrame.getData());
		
		
	}

}
