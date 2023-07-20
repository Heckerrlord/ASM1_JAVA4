package dao;


import Utils.MailUltils;
import jakarta.servlet.ServletContext;
import models.Users;

public class DAO_Email {

	private static final String EMAIL_WELCOME = "Welcome to Utube";
	private static final String EMAIL_FOGOT_PASS = "Utube - New password here!";
	private static final String EMAIL_VIDEO_SHARE = "Utube - Your friends has just send the video to you!!!";
	private static final String EMAIL_CHANGE = "Utube - Your password has changed!!!";
	
	public void sendMail(ServletContext context,Users recipient,String type) {
	       String host = "smtp.gmail.com";
	       String port = "587";
	       String user = "duyspph21810@fpt.edu.vn";
	       String pass = "bwdtjpcvhaustftl";

	       try {
			String content = null;
			String subject = null;
			
			switch (type) {
			case "welcome":
				System.out.println("Send mail ok");
				subject = EMAIL_WELCOME;
				content = "Dear " + recipient.getFullname() +"hope you have best time !!" +"\n Your account: "+"\n User name: "+recipient.getId()+"\n Password:"+recipient.getPassword();
				break;
			case "forgot":
				subject = EMAIL_FOGOT_PASS;
				content = "Dear " + recipient.getId() + ", your new password is here:" + recipient.getPassword();
				break;
			case "share":
				subject = EMAIL_VIDEO_SHARE;
				content =  recipient.getId() + "has just send the video for you!";
				break;
			case "changepass":
				subject = EMAIL_CHANGE;
				content =  "New password for: "+recipient.getId()+ " is :"+recipient.getPassword();
				break;
			default:
				subject = "duymoi.net Project";
				content = "This email is not exsist! Check it!!";
			}
			MailUltils.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
