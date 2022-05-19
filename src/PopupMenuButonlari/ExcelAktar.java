package PopupMenuButonlari;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import Excel.ExcelOlustur;
import UI.StokKartListeFrame;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelAktar implements ActionListener{

	private StokKartListeFrame list;
	
	public ExcelAktar(StokKartListeFrame list) {
		this.list = list;
		
	}
	
	public void excelAktar() {
		
		try {
			ExcelOlustur excel = new ExcelOlustur();
			Desktop dt = Desktop.getDesktop();
			File file = new File("C:\\Users\\yusuf\\OneDrive\\Masa�st�\\tablo.xls");
			excel.fillData(list.table, file);
			
			try {
				dt.open(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		excelAktar();
		
	}
	
	
	
	
}
