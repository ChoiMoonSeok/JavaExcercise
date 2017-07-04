package com.javalec.ftp;
import java.util.ArrayList;


public class FtpUploadMain {

	 public static void main(String[] args) {
	        
	        FtpUpload upLoader = new FtpUpload();
	        ArrayList<String> list = new ArrayList<String>();
	        
	        list.add("The Weight of the World.mp3");
	        
	        boolean re = upLoader.sendFtpServer("db.dosoft.co.kr", 2123, "ky1","1111", "Music","E://", list);
	        
	        if(re){
	            System.out.println("FTPUpLoaderMain.java :: 업로드 성공");
	        }else{
	            System.out.println("FTPUpLoaderMain.java :: 업로드 실패");
	        }
	    }
}
