package com.sam.mail;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Enumeration;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeUtility;
 


import com.sun.mail.imap.IMAPMessage;


/**
 * 
 * @author  1372940767@qq.com
 *
 */

public class EmailClient {

 private static final String IMAP = "imap";
 
/* 
 public void testRece() throws Exception{
  reviceQQEmail(System.getProperty("email"), System.getProperty("password"));
 }*/
	@SuppressWarnings("restriction")
	public void reviceQQEmail(String username, String password)
			throws Exception {
		String host = "imap.qq.com";
		String port = "993";

		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

		Properties props = System.getProperties();
		props.setProperty("mail.imap.socketFactory.class", SSL_FACTORY);
		// props.setProperty("mail.imap.socketFactory.fallback", "false");
		// props.setProperty("mail.imap.port", port);
		props.setProperty("mail.imap.socketFactory.port", port);

		props.setProperty("mail.store.protocol", "imap");
		props.setProperty("mail.imap.host", host);
		props.setProperty("mail.imap.port", port);
		props.setProperty("mail.imap.auth.login.disable", "true");
		Session session = Session.getDefaultInstance(props, null);
		session.setDebug(false);
		Store store = session.getStore("imap");
		store.connect(host, username, password);
		Folder inbox = null;
		try {

			inbox = store.getFolder("Inbox");
			inbox.open(Folder.READ_ONLY);
			FetchProfile profile = new FetchProfile();
			profile.add(FetchProfile.Item.ENVELOPE);
			Message[] messages = inbox.getMessages();
			inbox.fetch(messages, profile);
			System.out.println("收件箱的邮件数：" + messages.length);

			IMAPMessage msg;
			for (int i = 0; i < messages.length; i++) {
				msg = (IMAPMessage) messages[i];
 
				String from = decodeText(msg.getFrom()[0].toString());
				InternetAddress ia = new InternetAddress(from);
				System.out.println("FROM:" + ia.getPersonal() + '('
						+ ia.getAddress() + ')');
				System.out.println("TITLE:" + msg.getSubject());
				System.out.println("SIZE:" + msg.getSize());
				System.out.println("DATE:" + msg.getSentDate());
				Enumeration headers = msg.getAllHeaders();
				System.out
						.println("----------------------allHeaders-----------------------------");
				while (headers.hasMoreElements()) {
					Header header = (Header) headers.nextElement();
					System.out.println(header.getName() + " ======= "
							+ header.getValue());
				}
				parseMultipart((Multipart) msg.getContent());
			}

		} finally {
			try {
				inbox.close(false);
			} catch (Exception e) {
			}
			try {
				store.close();
			} catch (Exception e) {
			}
		}
	}
   protected String decodeText(String text) throws UnsupportedEncodingException {
  if (text == null)
   return null;
  if (text.startsWith("=?GB") || text.startsWith("=?gb"))
   text = MimeUtility.decodeText(text);
  else
   text = new String(text.getBytes("ISO8859_1"));
  return text;  }
 
 
    /**   
     * 对复杂邮件的解析  
     * @param multipart  
     * @throws MessagingException  
     * @throws IOException  
     */  
    public static void parseMultipart(Multipart multipart) throws MessagingException, IOException {   
        int count = multipart.getCount();   
        System.out.println("couont =  "+count);   
        for (int idx=0;idx<count;idx++) {   
            BodyPart bodyPart = multipart.getBodyPart(idx);   
            System.out.println(bodyPart.getContentType());   
            if (bodyPart.isMimeType("text/plain")) {   
                System.out.println("plain................."+bodyPart.getContent());   
            } else if(bodyPart.isMimeType("text/html")) {   
                System.out.println("html..................."+bodyPart.getContent());   
            } else if(bodyPart.isMimeType("multipart/*")) {   
                Multipart mpart = (Multipart)bodyPart.getContent();   
                parseMultipart(mpart);   
                   
            } else if (bodyPart.isMimeType("application/octet-stream")) {   
                String disposition = bodyPart.getDisposition();   
                System.out.println(disposition);   
                if (disposition.equalsIgnoreCase(BodyPart.ATTACHMENT)) {   
                    String fileName = bodyPart.getFileName();   
                    InputStream is = bodyPart.getInputStream();   
                    copy(is, new FileOutputStream("D:\\"+fileName));   
                }   
            }   
        }   
    }   
       
    /**   
     * 文件拷贝，在用户进行附件下载的时候，可以把附件的InputStream传给用户进行下载   
     * @param is   
     * @param os   
     * @throws IOException   
     */   
    public static void copy(InputStream is, OutputStream os) throws IOException {   
        byte[] bytes = new byte[1024];   
        int len = 0;   
        while ((len=is.read(bytes)) != -1 ) {   
            os.write(bytes, 0, len);   
        }   
        if (os != null)   
            os.close();   
        if (is != null)   
            is.close();   
    }
    public static void main(String args[]){
    	try {
			new EmailClient().reviceQQEmail("1573623031@qq.com", "<201314luoxi>");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
 