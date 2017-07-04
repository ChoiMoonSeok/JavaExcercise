/*
 * 클래스 설명 : Management시 필요한 메서드를 정의한 인터페이스
 */
package bookmgnt;

public interface Management extends Search {

	// 리스트 정보를 배열로 바꾸는 함수
	public BookMember[] getListData();

}
