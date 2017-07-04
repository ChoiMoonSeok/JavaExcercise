package hashmap;

import java.util.HashMap;

public class HashMapPrac {
	
	public static void main(String args[]){
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("페르소나5", new Integer(93));
		map.put("니어오토마타", new Integer(88));
		map.put("호라이즌 제로던", new Integer(86));
		map.put("젤다의 전설", new Integer(97));
		map.put("라스트오브어스", new Integer(95));
		map.put("GTA5", new Integer(93));
		
		System.out.println(map);
		
		Integer num = map.get("니어오토마타");
		System.out.println("게임명 : 니어오토마타");
		System.out.println("metaScore : " + num);
	}
}
