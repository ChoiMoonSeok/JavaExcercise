/*
 * 클래스 설명 : 파일을 저장혹은 불러오기 위해 파일 입력창을 설정하는 클래스
 * 작성자 : 최문석
 * 작성일지 : 2017-04-17 최초작성
 * 	         2017-04-23 메서드및 화면배치 완료
 *           2017-04-26 최종검토및 주석 완료
 */
package setgui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * JFrame을 상속 받음
 * JFrame - 파일선택창이 나타나기위한 부모의 역활
 */
public class SetFileDialog extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f = new JFrame();// 파일생성창을 나타낼 프레임
	JFileChooser fileChooser = new JFileChooser();// fileChooser 객체 생성
	File tempFile = null;// 사용자가 선택할 파일
	String tempFileName = null;// 사용자가 선택한 파일의 이름
	// 디폴트 생성자 생성

	public SetFileDialog() {
	}

	/*
	 * 메서드 설명 : 파일 저장시 나타내는 파일 선택창 구성 파라미터 : String fileName - 사용자가 입력한 저장할 파일의
	 * 이름 return : String - 사용자가 저장한 파일의 위치를 리턴
	 */
	public String saveFile(String fileName) {

		fileChooser.setAcceptAllFileFilterUsed(false);// 모든파일필터사용끄기
		// 파일의 확장자및 파일의 타입 설정
		FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("MicrosoftOfficeExcel2007(*xlsx)", "xlsx");
		// 파일필터 chooser에 추가
		fileChooser.addChoosableFileFilter(fileFilter);
		/*
		 * 재귀시 사용하기 위해 선언 이미 존재하는 파일을 다시 같은 이름으로 저장시 사용
		 */
		if (fileName != "") {
			fileChooser.setSelectedFile(new File(fileName));
		}
		// filechooser의 저장 선택시
		if (fileChooser.showSaveDialog(f) == JFileChooser.APPROVE_OPTION) {
			// 사용자가 입력한 file이름 저장
			tempFileName = fileChooser.getSelectedFile().toString();
			// file이름에 확장자가 없을시 추가
			if (!tempFileName.endsWith(".xlsx") && !tempFileName.endsWith(".XlSX")) {
				tempFileName += ".xlsx";
			}
			// 파일 생성
			tempFile = new File(tempFileName);
			// 중복할 파일 존재시 선택창 출력
			if (tempFile.exists()) {
				int confirm = JOptionPane.showConfirmDialog(f, tempFile.getName() + "이(가) 이미 있습니다 바꾸시겠습니까?",
						"다른이름 저장확인", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.NO_OPTION) {
					saveFile(tempFileName);
				}
			}

		}
		return tempFile.getPath();

	}

	/*
	 * 메서드 설명 : 파일 저장시 나타내는 파일 선택창 구성 파라미터 : String fileName - 사용자가 입력한 불러오는 파일의
	 * 이름 return : String - 사용자가 불러오는 파일의 위치를 리턴
	 */
	public String loadFile(String fileName) {

		String filePath = null;// 파일위치
		fileChooser.setAcceptAllFileFilterUsed(false);// 모든확장자선택 사용금지

		// 파일확장자 설정
		FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("MicroSoftOfficeExcel2007(*xlsx)", "xlsx");
		// 파일확장자 선택가능하도록 추가
		fileChooser.addChoosableFileFilter(fileFilter);

		// 파일 선택시 파일패스를 가져오도록 설정
		if (fileChooser.showOpenDialog(f) == JFileChooser.APPROVE_OPTION) {
			filePath = fileChooser.getSelectedFile().getPath();
		}
		return filePath;
	}

	/*
	 * 메서드 설명 : 파일의 디렉토리를 가져오는 메서드 파라미터 : File tempFile -디렉토리를 가져올 파일 리턴 :
	 * String directory -파일의 디렉토리 반환
	 */
	public String getDirectory(File tempFile) {
		String directory = tempFile.getPath();
		return directory;
	}

}
