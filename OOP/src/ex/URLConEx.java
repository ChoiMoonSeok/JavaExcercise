package ex;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class URLConEx {
	
	public URLConEx(){
		String code = null;
		System.out.println("웹 주소를 입력 하세요.");
		Scanner scanner = new Scanner(System.in);
		String address = scanner.next();
		
		try{
			String result = null;
			URL url = new URL(address);
			URLConnection con = url.openConnection();
			BufferedReader webData = new BufferedReader(new InputStreamReader(con.getInputStream()));
			FileWriter fw = new FileWriter("C:\\JAVA PRoject\\OOP\\file.html", false);
			
			while((code = webData.readLine()) != null){
			result += code;
		}
			fw.close();
			int start = result.indexOf("<title>")+7;
			int end = result.indexOf("</title>");
			System.out.println(result.substring(start, end));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
