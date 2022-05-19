package PopupMenuButonlari;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Email.SendEmail;

import UI.StokKartListeFrame;

public class Mail implements ActionListener {

	private StokKartListeFrame list;
	
	public Mail(StokKartListeFrame list) {
		this.list = list;
		
	}
	
	public void mail() {
		SendEmail sendEmail = new SendEmail();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mail();
		
	}
}
