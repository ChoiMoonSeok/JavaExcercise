package network;

import java.net.InetAddress;
import java.util.Scanner;

public class InetAddressEx {
	
	Scanner scanner;
	public InetAddressEx(){
		System.out.println("호스트를 입력하세요");
		scanner = new Scanner(System.in);
		try{
			InetAddress inetAddress = InetAddress.getByName(scanner.next());
			
			System.out.println("Computer NAME : " + inetAddress.getHostName());
			System.out.println("Computer IP : " + inetAddress.getHostAddress());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
}
