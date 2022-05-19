package TableModel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import Model.ParaBirimi;
import Model.StokFisiDetay;
import StokFişi.StokFisDetayDialog;
import UI.StokFisiFrame;

public class StokFisDetayTableModel extends AbstractTableModel implements MouseListener,TableModelListener{

	private final String[] columnNames = { "Stok Kodu", "Miktar", "Fiyat", "Para Birimi" };

	public List<StokFisiDetay> detaylar;// = new ArrayList<>();
	Object[] cl = null;

	public StokFisDetayTableModel() {
		this.detaylar = new ArrayList<>();
	}

	public void setList(List<StokFisiDetay> detaylar) {
		this.detaylar = detaylar;
	}

	public void setInitState() {
		detaylar.clear();
	}
	@Override
	public int getColumnCount() {

		return columnNames.length;
	}

	@Override
	public int getRowCount() {

		return detaylar.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	protected StokFisiDetay getStokFisiDetayAt(int rowIndex) {
		return detaylar.get(rowIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		StokFisiDetay obj = detaylar.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return obj.getStokKodu();
		case 1:
			return obj.getMiktar();
		case 2:
			return obj.getFiyat();
		case 3:
			return obj.getParaBirimi();
		default:
			return null;
		}
		

	}

	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		//StokFisiDetay stokFisiDetay = getStokFisiDetayAt(rowIndex);
		StokFisiDetay stokFisiDetay = detaylar.get(rowIndex);
		switch (columnIndex) {
		case 0:
			stokFisiDetay.setStokKodu(value.toString());
			break;
		case 1:
			stokFisiDetay.setMiktar(value.toString());
			break;
		case 2:
			stokFisiDetay.setFiyat(value.toString());
			break;
		case 3:
			stokFisiDetay.setParaBirimi(value.toString()) ;
			break;

		}
		stokFisiDetay.update();
		


		fireTableRowsUpdated(rowIndex, columnIndex);

	}
	
	public void removeRow(int row) {
		detaylar.remove(row);
		fireTableRowsDeleted(row-1, detaylar.size()-1);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	public void addRow(StokFisiDetay rowData) {
		detaylar.add(rowData);
		fireTableRowsInserted(detaylar.size(), detaylar.size());
		
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
		int column = e.getColumn();
		TableModel model = (TableModel)e.getSource();
		String columnName = model.getColumnName(column);
		Object data = model.getValueAt(row, column);


	}	



	@Override
	public void mouseClicked(MouseEvent e) {
		JTable target = (JTable)e.getSource();
		if (target.getSelectedColumn() != 0) return;
			
		StokFisDetayDialog stokFisDetayDialog = new StokFisDetayDialog();
		stokFisDetayDialog.setVisible(true);

		stokFisDetayDialog.table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				setValueAt(stokFisDetayDialog.stokKoduu(),target.getSelectedRow() , 0);
			
				stokFisDetayDialog.setVisible(false);
				fireTableDataChanged();


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


	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {



	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}



}
