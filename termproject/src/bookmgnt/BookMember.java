/*
 * 클래스 설명 : 책관리를 위한 멤버들을 저장하고 관리하는 클래스
 * 작성자 : 최문석
 * 작성일지 : 2017-04-13 최초 작성
 */
package bookmgnt;

public class BookMember {

	private String bookName;// 도서이름
	private String bookWriter;// 작가
	private int bookPrice;// 책가격
	private String publisher;// 출판사
	private String mgntNumber;// 관리번호
	private String purchaseReason;// 구매목적
	private int purchaseYear;// 구매연도

	/*
	 * 디폴트 생성자
	 */
	public BookMember() {
	}

	/*
	 * 메서드 설명 : 관리번호, 도서이름, 작가, 출판사, 구매가격, 구매년도를 초기화시키는 생성자 파라미터 : mgntNumber -
	 * 관리번호, bookName - 도서이름, bookWriter - 작가, bookpublisher -출판사, bookPrice -
	 * 책가격 purchaseYear -구매년도
	 */
	// "관리번호","도서 이름","작가","출판사","구매 가격","구매년도"
	public BookMember(String mgntNumber, String bookName, String bookWriter, String bookpublisher, Integer bookPrice,
			int purchaseYear) {
		setMgntNumber(mgntNumber);
		setBookName(bookName);
		setBookWriter(bookWriter);
		setBookPrice(bookPrice);
		setPublisher(bookpublisher);
		setPurchaseYear(purchaseYear);
	}

	/*
	 * 메서드 설명 : 관리번호, 도서이름, 작가, 출판사, 구매가격, 구매년도, 구매이유를 초기화시키는 생성자 파라미터 :
	 * mgntNumber - 관리번호, bookName - 도서이름, bookWriter -작가 bookpublisher - 출판사,
	 * bookPrice - 책가격 , purchaseYear - 구매년도, purchaseReason - 구매이유
	 */
	public BookMember(String mgntNumber, String bookName, String bookWriter, String bookpublisher, Integer bookPrice,
			int purchaseYear, String purchaseReason) {
		this(mgntNumber, bookName, bookWriter, bookpublisher, bookPrice, purchaseYear);
		setPurchaseReason(purchaseReason);
	}

	/*
	 * get,set 메서드 설정
	 */
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getMgntNumber() {
		return mgntNumber;
	}

	public void setMgntNumber(String mgntNumber) {
		this.mgntNumber = mgntNumber;
	}

	public String getPurchaseReason() {
		return purchaseReason;
	}

	public void setPurchaseReason(String purchaseReason) {
		this.purchaseReason = purchaseReason;
	}

	public int getPurchaseYear() {
		return purchaseYear;
	}

	public void setPurchaseYear(int purchaseYear) {
		this.purchaseYear = purchaseYear;
	}

}
