package com.javalec.ftpdownload;

public class FTPDownloadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FTPDownload ftpDown = new FTPDownload();
		
		boolean re = ftpDown.reciFTPServer("db.dosoft.co.kr", 2123, "ky1","1111", "E://","Music");
		
		if(re){
            System.out.println("FTPUpLoaderMain.java :: 다운로드 성공");
        }else{
            System.out.println("FTPUpLoaderMain.java :: 다운로드 실패");
        }
	}
}
