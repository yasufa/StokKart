package StokFişi;

import java.awt.Component;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import Model.ParaBirimi;

public class ParaBirimiCellRenderer extends DefaultTableCellRenderer{
	private List<ParaBirimi> listParaBirimi;
	JComboBox<ParaBirimi> combobox;
	public ParaBirimiCellRenderer(List<ParaBirimi> listParaBirimi) {
		this.listParaBirimi = listParaBirimi;
		combobox = new JComboBox<ParaBirimi>();
		for(ParaBirimi aParaBirimi : listParaBirimi) {
			combobox.addItem(aParaBirimi);

		}
	}

	public Component getTableCellRendererComponent(JTable table,Object value,
			boolean isSelected,boolean hasFocus, int row, int column) {
		
		
			for (int zz = 0; zz < combobox.getItemCount(); zz++) {
				ParaBirimi paraBirimi = combobox.getItemAt(zz);
				
				if (paraBirimi != null && paraBirimi.getName().equals(value)) {
					combobox.setSelectedIndex(zz);
					break;
				}
			}

		if(isSelected) {
			setBackground(table.getSelectionBackground());
		}else {
			setBackground(table.getSelectionForeground());
		}

		return combobox;

	}
}
