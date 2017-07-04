/*
 * 프로그램 이름 : BookMgnt
 * 프로그램 정보 : 도서관리 프로그램
 * 개발자 : 최문석
 * 버전 : 0.1
 * 프로그램 설명 : 이프로그램은 도서 관리를위해 제작한 프로그램으로 엑셀로 저장한 도서 목록을 읽어드려서 관리하고 다시 엑셀파일로 저장할 수있다
 * 는 특징이 있다.
 */
package bookmgnugui;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame frame = new MainFrame();

		try {
			frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
