package Excel;


import java.io.File;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import UI.StokKartListeFrame;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class ExcelOlustur {
	
	
	
	public void fillData(JTable table, File file) throws WriteException {
		WritableWorkbook stokKart;
		try {
			stokKart = Workbook.createWorkbook(file);
			WritableSheet kart = stokKart.createSheet("ilk kart", 0);
			StokKartListeFrame list = new StokKartListeFrame();
			TableModel model = list.table.getModel();
			
			for(int i = 0; i <model.getColumnCount(); i++) {
				Label column = new Label(i,0, model.getColumnName(i));
				kart.addCell(column);
			}
			int j = 0;
			for(int i = 0; i < model.getRowCount(); i++) {
				for(j = 0; j <model.getColumnCount(); j++) {
					Label row = new Label(j,i+1,model.getValueAt(i, j).toString());
					kart.addCell(row);
				}
			}
			
			stokKart.write();
			stokKart.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
