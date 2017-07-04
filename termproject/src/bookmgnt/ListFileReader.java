/*
 * 클래스 설명 : 기존 도서목록으로 작성한 파일을 읽어드려 데이터로 저장하는 클래스
 * 작성자 : 최문석
 * 작성일지 : 2017-04-13 최초작성
 * 			 2017-04-24 함수구성및 알고리즘 완성
 * 			 2017-04-26 주석처리및 최종검토
 */
package bookmgnt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
 * org.apache.poi package - 이패키지는 apache기업에서 제공하는 라이브러리로
 * 엑셀을 비롯한 다양한 확장자를 가진 파일을 읽어들이가 파일로저장가능하도록 하는 클래스가 들어있다.
 */
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*
 * gui의 메인 프레임으로 dialogMessage를 띄우기위해 가져옴
 */
import bookmgnugui.MainFrame;

public class ListFileReader {
	/*
	 * tempSaveList - 파일데이터를 임시적으로 저장하는 자료구조이다 gui를 제외한 나머지 클래스에서 많이 사용되기 때문에
	 * static으로 선언해 메모리에 올림
	 */
	public static ArrayList<BookMember> tempSaveList = new ArrayList<BookMember>();
	public BookMember[] tempData;// 파일임시데이터 저장 배열
	/*
	 * 메서드설명 : 엑셀파일을 자료구조에 저장하는 메서드 파라미터 : filePath - 엑셀파일의 파일위치 return :
	 * ArrayList<BookMenber> - bookMember형 데이터 타입들을 저장하는 자료구조
	 */

	public ArrayList<BookMember> xlxsToBookMemberList(String filePath) {

		FileInputStream fis = null;
		XSSFWorkbook workbook = null;// xlsx형 파일 워크북 생성

		try {
			fis = new FileInputStream(filePath);// FileInputStream 생성
			workbook = new XSSFWorkbook(fis);// workBook객체 생성
			Sheet datatypeSheet = workbook.getSheetAt(0);// 워크시트 생성
			tempData = new BookMember[datatypeSheet.getPhysicalNumberOfRows()];
			for (Row row : datatypeSheet) {

				if (row.getRowNum() < 1)// 첫번째는 row의 데이터는 필요없으므로 패스 하기위하여 선언
					continue;
				int bookPrice = (int) row.getCell(4).getNumericCellValue();// 책의
																			// 가격을
																			// 가져옴
				int purchaseYear = (int) row.getCell(5).getNumericCellValue();// 구매년도를
																				// 가져옴
				tempData[row.getRowNum()] = new BookMember();// bookMember데이터를
																// 원소로 하는 배열생성
				tempData[row.getRowNum()].setMgntNumber(row.getCell(0).getStringCellValue());// 관리번호
				tempData[row.getRowNum()].setBookName(row.getCell(1).getStringCellValue());// 도서이름
				tempData[row.getRowNum()].setBookWriter(row.getCell(2).getStringCellValue());// 작가
				tempData[row.getRowNum()].setPublisher(row.getCell(3).getStringCellValue());// 출판사
				tempData[row.getRowNum()].setBookPrice(bookPrice);// 도서가격
				tempData[row.getRowNum()].setPurchaseYear(purchaseYear);// 구매년도
				tempData[row.getRowNum()].setPurchaseReason(row.getCell(6).getStringCellValue());// 구매이유
				tempSaveList.add(tempData[row.getRowNum()]);// 자료구조에 데이터 추가
			}
			BookMemberList.bookList.addAll(tempSaveList);// 기존 도서정보자료구조에 모든데이터
															// 추가

		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(new MainFrame(), "파일을 찾을 수  없습니다");
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(new MainFrame(), "파일을 출력할 수 없습니다");
		} finally {
			try {
				if (workbook != null)
					workbook.close();// 워크북 객체 리소스 리턴
				if (fis != null)
					fis.close();// 파일객체 리소스 리턴
			}

			catch (Exception e) {
				JOptionPane.showMessageDialog(new MainFrame(), "알 수 없는 에러 발생 다시 시도해 주세요");
			}
		}

		return tempSaveList;
	}

}
