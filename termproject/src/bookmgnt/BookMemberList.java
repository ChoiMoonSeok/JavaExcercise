/*
 * 클래스설명 : 도서의 대한 정보를 자료구조로 구성하는 클래스
 * 작성자 : 최문석
 * 작성일지 : 2017-04-13 최초작성
 *           2017-04-17 최종검사및 주석처리
 *           2017-04-26 완성
 */
package bookmgnt;

import java.util.ArrayList;

public class BookMemberList {

	public static ArrayList<BookMember> bookList = new ArrayList<BookMember>();

	/*
	 * 메서드 설명 : 자료구조에 도서 정보를 추가하는 메서드 파라미터 : mgntNumber - 관리번호, bookName -도서 이름,
	 * bookWriter - 작가, bookPublisher - 출판사 , bookPrice - 책가격 , purchaseYear -
	 * 구매년도
	 */
	public void addBookList(String mgntNumber, String bookName, String bookWriter, String bookPublisher,
			Integer bookPrice, int purchaseYear) {

		bookList.add(new BookMember(mgntNumber, bookName, bookWriter, bookPublisher, bookPrice, purchaseYear));

	}

	/*
	 * 메서드 설명: addBookList Overloading 파라미터 : purchaseReason -구매목적
	 */
	public void addBookList(String mgntNumber, String bookName, String bookWriter, String bookPublisher,
			Integer bookPrice, int purchaseYear, String purchaseReason) {

		bookList.add(new BookMember(mgntNumber, bookName, bookWriter, bookPublisher, bookPrice, purchaseYear,
				purchaseReason));

	}

	/*
	 * 메서드 설명 : 도서목록에서 데이터를 삭제하는 메서드 파라미터 : index - 데이터 위치
	 */
	public void removeBookList(int index) {
		bookList.remove(index);
	}

	/*
	 * 메서드 설명 : 발표와 디버깅시 리스트의 수가 제대로 늘어나는가 확인하는 함수
	 */
	public void tmpPrint() {
		System.out.println(bookList.size());
	}
}
