/*
 * 클래스설명 : 도서관리를위한 기능을 담고 있는 클래스
 * 작성자 : 최문석
 * 작성일지 : 2017-04-13 최초작성
 * 			 2017-04-22 listDataToRow 함수 완성(모든 함수 완성)
 *           2017-04-26 최종수정(주석및 네이밍)
 */
package bookmgnt;

/*
 * Managetment - 관리를 위한 기능이 구현되어있는 인터페이스
 */
public class BookManagement implements Management {

	// *rowData - 이 데이터는 기존 자료구조에 있는 데이터를 데이블로 옮기기 위한 배열이 아닌 파일에서 읽어와 추가적으로 추가될
	// 자료들에 대한 배열이다
	BookMember[] rowData;

	public BookManagement() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bookmgnt.Search#seachData(java.lang.String) 메서드 설명 : 사용자가 입력한 책의 제목을
	 * list내 에서 찾아 비교하여 idndex를 반환하는 메서드 파라미터 : scan - 사용자입력 책 제목 리턴 : int index
	 * - 검색하여 해당하는 정보가 들어있는 리스트 인덱스 반환
	 */
	@Override
	public int seachData(String scan) {
		// TODO Auto-generated method stub
		int index = 0;
		int listSize = BookMemberList.bookList.size();
		for (index = 0; index < listSize; index++) {
			String bookName = BookMemberList.bookList.get(index).getBookName();
			if (bookName.contains(scan))
				return index;
		}
		return index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bookmgnt.Management#getListData(java.util.ArrayList) 메서드 설명 : 엑셀파일을
	 * 읽어드려 리스트에 저장한 데이터를 다시 배열로 변환하는 메서드 리턴값 : BookMember[] rowData -파일에서 읽어온
	 * 임시데이터를
	 */
	@Override
	public BookMember[] getListData() {
		int listSize = ListFileReader.tempSaveList.size();// 파일의 데이터를 저장한
															// 임시자료구조의 크기
		rowData = new BookMember[listSize];// 테이블에 추가되는 행의 내용
		/*
		 * 리스트의 사이즈 만큼 데이터를 뽑아내 배열에 저장하여 반환한다.
		 */
		for (int index = 0; index < listSize; index++) {
			rowData[index] = new BookMember();// rowData초기화

			rowData[index].setMgntNumber(ListFileReader.tempSaveList.get(index).getMgntNumber());// 관리번호
			rowData[index].setBookName(ListFileReader.tempSaveList.get(index).getBookName());// 도서이름
			rowData[index].setBookWriter(ListFileReader.tempSaveList.get(index).getBookWriter());// 작가
			rowData[index].setPublisher(ListFileReader.tempSaveList.get(index).getPublisher());// 출판사
			rowData[index].setBookPrice(ListFileReader.tempSaveList.get(index).getBookPrice());// 도서가격
			rowData[index].setPurchaseYear(ListFileReader.tempSaveList.get(index).getPurchaseYear());// 구매년도
			rowData[index].setPurchaseReason(ListFileReader.tempSaveList.get(index).getPurchaseReason());// 구매이유
		}
		return rowData;
	}

	/*
	 * 메서드 설명 : 배열에 저장된 데이터를 데이블의 행으로 옮기는 작업 파라미터 : index - 배열의 저장된 데이터를 가져오기위한
	 * 파라미터 리턴값 : String[] row -테이블의 행을 이루는 부분
	 */
	public String[] listDataToRow(int index) {
		String row[] = new String[7];

		row[0] = rowData[index].getMgntNumber();
		row[1] = rowData[index].getBookName();
		row[2] = rowData[index].getBookWriter();
		row[3] = rowData[index].getPublisher();
		row[4] = Integer.toString(rowData[index].getBookPrice());
		row[5] = Integer.toString(rowData[index].getPurchaseYear());
		row[6] = rowData[index].getPurchaseReason();
		return row;
	}

}
