package com.javalec.ftpdownload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FTPDownload {

	public boolean reciFTPServer(String ip, int port, String id, String password, String localPath, String FTPDirectory) {

		boolean isSuccess = false;
		FTPClient ftp = null;
		int reply;
		try {
			ftp = new FTPClient();
			ftp.setControlEncoding("UTF-8");
			ftp.connect(ip, port);
			System.out.println("Connected to " + ip + "on" + ftp.getRemotePort());

			reply = ftp.getReplyCode();

			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				System.err.println("FTP server refused connection");
				System.exit(1);
			}

			if (!ftp.login(id, password)) {
				ftp.logout();
				throw new Exception("ftp 서버에 로그인 실패");
			}

			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			ftp.enterLocalPassiveMode();

			System.out.println(ftp.printWorkingDirectory());

			FTPFile[] ftpFiles = ftp.listFiles(FTPDirectory);
			if (ftpFiles != null) {
				for (int i = 0; i < ftpFiles.length; i++) {
					FTPFile file = ftpFiles[i];
					File get_file = new File(localPath + file);
					OutputStream outputStream = new FileOutputStream(get_file);
					isSuccess = ftp.retrieveFile(FTPDirectory + file, outputStream);
					outputStream.close();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ftp.disconnect();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return isSuccess;
	}
}
