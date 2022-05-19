package TableModel;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import Model.StokFisiDetay;

public class MyTableModelListener implements  TableModelListener{

	private JTable table;
	private StokFisiDetay stok;
	
	public MyTableModelListener(JTable table) {
		this.table = table;
		
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("TABLE MODEL LİSTENER");
		stok = new StokFisiDetay();
		switch (e.getType()) {
		case TableModelEvent.UPDATE:
				
				String selectStokKodu=table.getValueAt(table.getSelectedRow(), 0).toString();
				String selectmiktar=table.getValueAt(table.getSelectedRow(), 1).toString();
				String selectFiyat=table.getValueAt(table.getSelectedRow(), 2).toString();
				String selectPara=table.getValueAt(table.getSelectedRow(),3).toString();
				try {
					stok.updateDetay(selectStokKodu, selectmiktar, selectFiyat, selectPara);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
			
		}
		
	}

}
