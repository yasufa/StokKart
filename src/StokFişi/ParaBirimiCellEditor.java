package StokFişi;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import Model.ParaBirimi;

public class ParaBirimiCellEditor extends AbstractCellEditor implements TableCellEditor , ActionListener{

	private ParaBirimi paraBirimi;
	private List<ParaBirimi> listParaBirimi;
	public JComboBox<ParaBirimi> comboParaBirimi;
	
	public ParaBirimiCellEditor(List<ParaBirimi> listParaBirimi) {
		this.listParaBirimi = listParaBirimi;
	}
	
	@Override
	public Object getCellEditorValue() {
		return this.paraBirimi.getName();
	}

	

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if(value instanceof ParaBirimi) {
			this.paraBirimi = (ParaBirimi) value;
		}
		comboParaBirimi = new JComboBox<ParaBirimi>();
		
		for(ParaBirimi aParaBirimi : listParaBirimi) {
			comboParaBirimi.addItem(aParaBirimi);
			
		}
		comboParaBirimi.setSelectedItem(paraBirimi);
		comboParaBirimi.addActionListener(this);
		
		if(isSelected) {
			comboParaBirimi.setBackground(table.getSelectionBackground());
			
		}else {
			comboParaBirimi.setBackground(table.getSelectionForeground());
		}
		return comboParaBirimi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<ParaBirimi> comboParaBirimi = (JComboBox<ParaBirimi>) e.getSource();
		
		this.paraBirimi = (ParaBirimi) comboParaBirimi.getSelectedItem();
		
	}
}
