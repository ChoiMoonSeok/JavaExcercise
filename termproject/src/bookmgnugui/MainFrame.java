/*
 * 클래스 설명 : 사용자인터페이스를 구성하는 메인창을 나타내는 부분으로 각종액션과 버튼 테이블등이 추가되어지는
 * 이 프로그램의 주요 클래스이다.
 * 작성자 : 최문석
 * 작성일지 : 2017-04-13 최초작성
 * 			 2017-04-23 추가, 삭제 버튼 액션추가
 * 			 2017-04-24 파일불러오기버튼 액션 추가
 * 			 2017-04-25 파일저장하기 버튼 액션 추가
 * 	         2017-04-26 주석및 최종검토
 */
package bookmgnugui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import bookmgnt.BookManagement;
import bookmgnt.BookMember;
import bookmgnt.BookMemberList;
import bookmgnt.ListFileReader;
import bookmgnt.ListFileWriter;
import setgui.SetDialog;
import setgui.SetFileDialog;
import setgui.SetTableModel;

//extends JFrame - 프레임을 나타내기위해 상속을 받음
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5110055741858960912L;
	// 테이블을 담는 스크롤
	private JScrollPane bookListPane;
	// 관리번호 입력 텍스트
	private JTextField mgntText;
	// 도서이름 입력 텍스트
	private JTextField bookNameText;
	// 작가 입력 텍스트
	private JTextField writerText;
	// 출판사 입력 텍스트
	private JTextField publisherText;
	// 도서구매가격 텍스트
	private JTextField bookPriceText;
	// 구매이유입력 텍스트
	private JTextField purchaseReasonText;
	// 구매년도 입력 텍스트
	private JTextField purchaseYearText;
	// 리스트 사용을 위한 객체 생성
	private BookMemberList memberList = new BookMemberList();
	// 테이블의 설정이 담긴 객체 생성
	private SetTableModel tableModel = new SetTableModel();

	/*
	 * 메인프레임의 형태를 설정하는 부분
	 */
	public MainFrame() {
		/*
		 * 메인프레임 설정부분
		 */
		setSize(1200, 600);
		setTitle("BookS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * 버튼 판넬 설정부분
		 */
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.WEST);
		buttonPanel.setLayout(new GridLayout(0, 1, 0, 0));
		/*
		 * 엑셀파일 불러오기 버튼 설정 void actionPerformed - 이버튼이 눌렷을때 일어날 동작을 정의한 함수
		 * filechooser가 나타나도록 설정
		 */
		JButton readFileButton = new JButton("도서목록불러오기");
		readFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetFileDialog setFilelog = new SetFileDialog();// filechooser객체
				ListFileReader fileReader = new ListFileReader();// 파일리더 객체 생성
				BookManagement bookMgnt = new BookManagement();// 도서관리를 위한 객체 생성

				fileReader.xlxsToBookMemberList(setFilelog.loadFile(""));
				/*
				 * 파일에서 읽어들이 자료의 수만큼 테이블에 추가하는 반복문 index - 원소번호 ,
				 * bookMgnt.getListData().lenght - 리스트데이터 자료의 수
				 */
				for (int index = 0; index < bookMgnt.getListData().length; index++) {
					tableModel.bookListModel.addRow(bookMgnt.listDataToRow(index));
				}

			}
		});
		// 버튼 추가
		buttonPanel.add(readFileButton);
		/*
		 * 엑셀파일 저장하기 버튼 설정 void actionPerformed - 이버튼이 눌렷을때 일어날 동작을 정의한 함수
		 * filechooser가 나타나도록 설정
		 */
		JButton writeFileButton = new JButton("도서목록파일로저장하기");
		writeFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetFileDialog filelog = new SetFileDialog();
				ListFileWriter fileWriter = new ListFileWriter();
				fileWriter.writeToxlsxFile(filelog.saveFile(""));
			}
		});
		// 버튼추가
		buttonPanel.add(writeFileButton);
		/*
		 * 도서정보 검색하기 버튼 설정 void actionPerformed - 이버튼이 눌렷을때 일어날 동작을 정의한 함수
		 * filechooser가 나타나도록 설정
		 */
		JButton searchButton = new JButton("도서검색");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// dialog 호출
				SetDialog setDlog = new SetDialog(tableModel.bookList);
				setDlog.setLocationRelativeTo(tableModel.bookList);
				// 위치 설정
				setDlog.setLocation(550, 250);
				setDlog.setVisible(true);
			}
		});
		// 검색부분 추가
		buttonPanel.add(searchButton);

		// 도서항목추가및 삭제를 위해 만듬
		JPanel addListPanel = new JPanel();
		getContentPane().add(addListPanel, BorderLayout.SOUTH);
		/*
		 * 추가를 위한 텍스트 생성부분
		 */
		JLabel mgntLabel = new JLabel("관리번호");
		addListPanel.add(mgntLabel);

		mgntText = new JTextField();
		addListPanel.add(mgntText);
		// 입력창 길이 설정
		mgntText.setColumns(4);

		JLabel bookNameLabel = new JLabel("도서이름");
		addListPanel.add(bookNameLabel);
		bookNameText = new JTextField();
		addListPanel.add(bookNameText);
		// 입력창 길이 설정
		bookNameText.setColumns(10);

		JLabel writerLabel = new JLabel("작가");
		addListPanel.add(writerLabel);

		writerText = new JTextField();
		addListPanel.add(writerText);
		// 입력창 길이 설정
		writerText.setColumns(4);

		JLabel publisherLabel = new JLabel("출판사");
		addListPanel.add(publisherLabel);

		publisherText = new JTextField();
		addListPanel.add(publisherText);
		// 입력창 길이 설정
		publisherText.setColumns(4);

		JLabel bookPriceLabel = new JLabel("구매가격");
		addListPanel.add(bookPriceLabel);

		bookPriceText = new JTextField();
		addListPanel.add(bookPriceText);
		// 입력창 길이 설정
		bookPriceText.setColumns(4);

		JLabel purchaseYearLabel = new JLabel("구매년도");
		addListPanel.add(purchaseYearLabel);

		purchaseYearText = new JTextField();
		addListPanel.add(purchaseYearText);
		// 입력창 길이 설정
		purchaseYearText.setColumns(4);

		JLabel purchaseResonLabel = new JLabel("구매이유");
		addListPanel.add(purchaseResonLabel);

		purchaseReasonText = new JTextField();
		addListPanel.add(purchaseReasonText);
		// 입력창 길이 설정
		purchaseReasonText.setColumns(15);

		/*
		 * 테이블 생성부분
		 */
		bookListPane = new JScrollPane(tableModel.bookList);

		// 테이블 스크롤 정책
		bookListPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		bookListPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// 추가
		getContentPane().add(bookListPane);

		/*
		 * 도서정보 검색하기 버튼 설정 void actionPerformed - 이버튼이 눌렷을때 일어날 동작을 정의한 함수 도서정보가
		 * table에 추가되고 bookList자료구조에 추가되도록 구성
		 */
		JButton addButton = new JButton("도서추가");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rowData[] = new String[7];// 테이블에 행을 구성하는 배열 colum이 7개
													// 이므로 크기가 7이다
				if (e.getSource().equals(addButton))
					try {
						// 구매이유를 입력 했을때
						if (!purchaseReasonText.getText().equals("")) {
							rowData[0] = mgntText.getText();
							rowData[1] = bookNameText.getText();
							rowData[2] = writerText.getText();
							rowData[3] = publisherText.getText();
							rowData[4] = bookPriceText.getText();
							rowData[5] = purchaseYearText.getText();
							rowData[6] = purchaseReasonText.getText();
							tableModel.bookListModel.addRow(rowData);
							memberList.addBookList(mgntText.getText(), bookNameText.getText(), writerText.getText(),
									publisherText.getText(), Integer.parseInt(bookPriceText.getText()),
									Integer.parseInt(purchaseYearText.getText()), purchaseReasonText.getText());
							// memberList.tmpPrint();
						}

						// 구매이유를 입력하지 않고, 구매년도를 입력하였을때
						else if ((purchaseReasonText.getText().equals(""))
								&& (!purchaseYearText.getText().equals(""))) {
							rowData[0] = mgntText.getText();
							rowData[1] = bookNameText.getText();
							rowData[2] = writerText.getText();
							rowData[3] = publisherText.getText();
							rowData[4] = bookPriceText.getText();
							rowData[5] = purchaseYearText.getText();
							rowData[6] = purchaseReasonText.getText();
							tableModel.bookListModel.addRow(rowData);
							memberList.addBookList(mgntText.getText(), bookNameText.getText(), writerText.getText(),
									publisherText.getText(), Integer.parseInt(bookPriceText.getText()),
									Integer.parseInt(purchaseYearText.getText()));
							// memberList.tmpPrint();
						}
						// 도서의 정보를 입력하지 않았을 때
						else if (mgntText.getText().equals("") || bookNameText.getText().equals("")
								|| writerText.getText().equals("") || publisherText.getText().equals(""))
							JOptionPane.showMessageDialog(null, "도서의 정보를 입력해주세요");
						// 구매년도, 구매가격을 입력하지 않았을때
						else if ((purchaseYearText.getText().equals("")) || (bookPriceText.getText().equals(""))) {
							JOptionPane.showMessageDialog(null, "구매년도와 구매가격을 입력해주세요");
						} 
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "구매년도,구매가격은 숫자만 입력해주세요");
					} catch (Exception except) {
					}

			}
		});
		// 가운데 정렬
		addButton.setHorizontalAlignment(SwingConstants.CENTER);

		// 버튼추가
		addListPanel.add(addButton);

		/*
		 * 도서 정보삭제를 위한 버튼 void actionPerformed - 삭제 버튼을 눌렀을시에 동작할 액션이 정의된 함수로,
		 * 테이블과 자료구조에서 해당하는 정보가 삭제된다.
		 */
		JButton delButton = new JButton("도서삭제");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableModel.bookList.getSelectedRow();
				if (row == -1)
					return;
				tableModel.bookListModel = (DefaultTableModel) tableModel.bookList.getModel();
				tableModel.bookListModel.removeRow(row);
				memberList.removeBookList(row);

				// 이 함수는 디버깅및 발표시에만 사용 정식버전에 지울거임
				memberList.tmpPrint();
			}
		});

		// 삭제버튼 추가
		addListPanel.add(delButton);

	}

}
