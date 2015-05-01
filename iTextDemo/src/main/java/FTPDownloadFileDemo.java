import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 * A program demonstrates how to upload files from local computer to a remote
 * FTP server using Apache Commons Net API.
 * @author www.codejava.net
 */
public class FTPDownloadFileDemo {

	public static void main(String[] args) {
		String server = "ftp.pku.edu.cn";
		int port = 21;
		String user = "anonymous";
		String pass = "1573623031@qq.com";

		FTPClient ftpClient = new FTPClient();
		try {

			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			FTPFile[] ftpFile = ftpClient.listDirectories();
			for (int i = 0; i < ftpFile.length; i++) {
				System.out.println(ftpFile[i].getName());
			 
			}
			 
		
		 

		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}