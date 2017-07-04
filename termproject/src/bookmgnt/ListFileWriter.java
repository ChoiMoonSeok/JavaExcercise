/*
 * 클래스 설명 : 도서목록으로 저장한 데이터를 파일로 내보내는 클래스
 * 작성자 : 최문석
 * 작성일지 : 2017-04-13 최초작성
 * 			 2017-04-24 함수구성및 로직 완성
 * 			 2017-04-26 주석및 최종점검
 */
package bookmgnt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/*
 * org.apache.poi package - 이패키지는 apache기업에서 제공하는 라이브러리로
 * 엑셀을 비롯한 다양한 확장자를 가진 파일을 읽어들이가 파일로저장가능하도록 하는 클래스가 들어있다.
 */
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * SetTableModel - 테이블의 칼럼이름을 가져오기위해 임포트
 * MainFrame -오류다이얼로그 메세지를 띄우기 위해 임포트
 */
import bookmgnugui.MainFrame;
import setgui.SetTableModel;

public class ListFileWriter {

	// 테이블 모델 객체 생성
	private SetTableModel tableModel = new SetTableModel();

	/*
	 * 메서드 설명 : 자료구조에 저장된 정보를 엑셀파일로 옮겨적는 함수 파라미터 : String filePath - 엑셀파일이 저장될
	 * 파일 위치
	 */
	public void writeToxlsxFile(String filePath) {
		// 워크북 생성
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 워크시트 생성
		XSSFSheet shett = workbook.createSheet();
		// 행 생성
		XSSFRow row = shett.createRow(0);
		// 쏄 생성
		XSSFCell cell;

		// 헤더 정보 구성
		cell = row.createCell(0);
		// 헤더 내용 :관리번호
		cell.setCellValue(tableModel.colNames[0]);

		cell = row.createCell(1);
		// 헤더 내용 : 도서이름
		cell.setCellValue(tableModel.colNames[1]);

		cell = row.createCell(2);
		// 헤더 내용: 작가
		cell.setCellValue(tableModel.colNames[2]);

		cell = row.createCell(3);
		// 헤더 내용: 출판사
		cell.setCellValue(tableModel.colNames[3]);

		cell = row.createCell(4);
		// 헤더 내용: 도서가격
		cell.setCellValue(tableModel.colNames[4]);

		cell = row.createCell(5);
		// 헤더 내용 : 구매년도
		cell.setCellValue(tableModel.colNames[5]);

		cell = row.createCell(6);
		// 헤더 내용 : 구매이유
		cell.setCellValue(tableModel.colNames[6]);

		// 리스트의 size만큼 row생성
		for (int rowIndex = 0; rowIndex < BookMemberList.bookList.size(); rowIndex++) {
			/*
			 * 행 생성 설명 : 행을 만들고 그 안의 내용은 위에 설정한 헤더에따라 파일에 쓰여지도록 설정
			 */
			row = shett.createRow(rowIndex + 1);

			cell = row.createCell(0);
			cell.setCellValue(BookMemberList.bookList.get(rowIndex).getMgntNumber());

			cell = row.createCell(1);
			cell.setCellValue(BookMemberList.bookList.get(rowIndex).getBookName());

			cell = row.createCell(2);
			cell.setCellValue(BookMemberList.bookList.get(rowIndex).getBookWriter());

			cell = row.createCell(3);
			cell.setCellValue(BookMemberList.bookList.get(rowIndex).getPublisher());

			cell = row.createCell(4);
			cell.setCellValue(BookMemberList.bookList.get(rowIndex).getBookPrice());

			cell = row.createCell(5);
			cell.setCellValue(BookMemberList.bookList.get(rowIndex).getPurchaseYear());

			cell = row.createCell(6);
			cell.setCellValue(BookMemberList.bookList.get(rowIndex).getPurchaseReason());

		}

		// 입력된 내용 xlsx파일로 쓰기
		File file = new File(filePath);
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);// 이진데이터를 문자데이터로
			workbook.write(fos);// 파일 write
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(new MainFrame(), "파일저장에 실패했습니다");
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(new MainFrame(), "내용저장에 실패했습니다");
		} finally {
			try {
				if (workbook != null)
					workbook.close();// 리소스 반환
				if (fos != null)
					fos.close();// 리소스 반환
			} catch (Exception e) {
				JOptionPane.showMessageDialog(new MainFrame(), "저장에 실패했습니다.");
			}
		}
	}
}
