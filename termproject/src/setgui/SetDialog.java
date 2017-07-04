/*
 * 클래스설명 : 검색창을 설정하는 클래스
 * 작성자 : 최문석 
 * 작성일지 : 2017-04-17 최초작성
 * 			 2017-04-23 메서드구성및 화면배치
 * 		     2017-04-26 주석및 최종검토
 */
package setgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import bookmgnt.BookManagement;
import bookmgnt.BookMemberList;

//Dialog생성을 위하여 JDialog클래스를 상속받음
public class SetDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 검색 버튼 생성
	private JButton searChButton = new JButton("검색");
	// 검색을 위한 텍스트입력창 생성
	private JTextField searchText = new JTextField(10);

	/*
	 * 메서드 설명 :검색창을 생성하는 메서드 JTable table - 창을 띄울 위치
	 */
	public SetDialog(JTable table) {
		super();
		setTitle("도서검색");
		// 검색창이 나타날시 다른 프레임 클릭 금지
		setModal(true);
		// 레이아웃 설정안함
		getContentPane().setLayout(null);
		JLabel searchLabel = new JLabel("검색할 도서의 제목을 입력해주세요");
		// 라벨 위치 설정
		searchLabel.setBounds(24, 32, 324, 15);
		getContentPane().add(searchLabel);
		// 텍스트입력창 위치 설정
		searchText.setBounds(21, 53, 225, 21);
		getContentPane().add(searchText);
		// 검색버튼 위치 설정
		searChButton.setBounds(258, 52, 65, 23);
		/*
		 * 검색버튼을 누를시 액션을 지장 void actionPerformed - 검색버튼을 클릭시 작동하는 action으로 자료구조에
		 * 있는 데이터와 사용자입력을 비교하여 테이블 row선택
		 */
		searChButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookManagement bookMgnt = new BookManagement();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.clearSelection();
				int index = bookMgnt.seachData(searchText.getText());
				// 반환한 index가 자료구조사이즈와 같으면 if문 실행
				if (index == BookMemberList.bookList.size())
					JOptionPane.showMessageDialog(table, "찾으시는 도서의 정보가 존재하지 않습니다");
				// 테이블 행 선택
				table.changeSelection(index, 2, false, true);
				// 창을 닫음
				dispose();
			}
		});
		getContentPane().add(searChButton);
		setSize(400, 130);
	}

}
