/*
 * 클래스 설명 : gui에 올라가는 테이블을 설정하는 클래스
 * 작성자 : 최문석
 * 작성일지 : 2017-04-13 최초작성
 *           2017-04-17 테이블형태설정
 *           2017-04-26 최종검토및 주석 완료
 */
package setgui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SetTableModel {

	public JTable bookList;// 테이블
	public DefaultTableModel bookListModel;// 테이블 모델
	public String colNames[] = { "관리번호", "도서이름", "작가", "출판사", "구매가격", "구매년도", "구매이유" };// 칼럼항목생성

	public SetTableModel() {
		bookListModel = new DefaultTableModel(colNames, 0);// 테이블모델 구성
		bookList = new JTable(bookListModel);// 테이블에 모델 추가
		bookList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);// 테이블셀선택
																					// 정책
		bookList.setEnabled(true);// 셀편집가능
		// 셀관리를 위한 객체 생성
		DefaultTableCellRenderer bookListCellRenderer = new DefaultTableCellRenderer();
		// 테이블가운데 정렬
		bookListCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		// 칼럼을 가져옴
		TableColumnModel tcmBookList = bookList.getColumnModel();
		// 반복문으로 테이블 전체의 가운데 정렬
		for (int i = 0; i < tcmBookList.getColumnCount(); i++)
			tcmBookList.getColumn(i).setCellRenderer(bookListCellRenderer);
	}

}
