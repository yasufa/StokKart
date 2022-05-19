package Controller;

import java.sql.Connection;

import javax.swing.UnsupportedLookAndFeelException;



import Dao.ConnectionManagement;

import Model.Cart;
import UI.CartFrame;
import UI.GirisFramee;

public class StokKartMainFrameController {
	
	private GirisFrameController girisFrameController;
	
	public static void main(String[] args) {

		
		Connection db = ConnectionManagement.getConnectionManagement();
		
		GirisFrameController aa = new GirisFrameController();
		
	
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    try {
						javax.swing.UIManager.setLookAndFeel(info.getClassName());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    break;
                }
      
		
		
		
		
		
		
            }

	}
}