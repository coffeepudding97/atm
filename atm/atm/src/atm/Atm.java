package atm;

import java.util.Scanner;

public class Atm {
	
	private final int JOIN =1;
	private final int LEAVE =2;
	private final int LOGIN =3;
	private final int LOGOUT =4;
	private final int CREATE_ACC =5;
	private final int DELETE_ACC =6;
	private final int VIEW_BALANCE =7;
	private final int INPUT_MONEY =8;
	private final int OUT_MONEY =9;
	private final int MOVE_MONEY =10;
	private final int SAVE_FILE =11;
	private final int LOAD_FILE =12;
	private final int QUIT =13;
	
	public static final Scanner scanner = new Scanner(System.in);

	private String brandName;
	
	private UserManager userManager;
	private AccountManager accManager;
	private FileManager fileManager;
	
	public Atm(String brandName) {
		this.brandName =brandName;
		
		this.userManager = UserManager.getInstance();
		this.accManager = AccountManager.getInstance();
		this.fileManager = FileManager.getInstance();
	}
	
	private void printMenu() {
		System.out.printf("===%s Bank ---\n", this.brandName);
		System.out.println("1. 회원가입");
		System.out.println("2. 회원탈퇴");
		System.out.println("3. 로그인");
		System.out.println("4. 로그아웃");
		System.out.println("5. 계좌개설");
		System.out.println("6. 계좌철회");
		System.out.println("7. 계좌조회");
		System.out.println("8. 입금");
		System.out.println("9. 출금");
		System.out.println("10. 출금");
		System.out.println("11. 계좌이체");
		System.out.println("12. 파일저장");
		System.out.println("13. 파일불러오기");
	}
	

	public void run() {
		while(true) {
			printAlldata();
			printMenu();
			int select = inputNumber("메뉴");
			if(select == JOIN)
				userManager.joinUser();
//			else if(select==LEAVE)
//				userManager.leaveUser();
//			else if(select==LOGIN)
//				userManager.loginUser();
//			else if(select==LOGOUT)
//				userManager.logoutUser();
//			else if(select==CREATE_ACC)
//				accManager.createAcc();
//			else if(select==DELETE_ACC)
//				accManager.deleteAcc();
//			else if(select==VIEW_BALANCE)
//				accManager.viewBalance();
//			else if(select==INPUT_MONEY)
//				accManager.inputMoney();
//			else if(select==OUT_MONEY)
//				fileManager.outMoney();
//			else if(select==MOVE_MONEY)
//				fileManager.moveMoney();
//			else if(select==SAVE_FILE)
//				fileManager.saveFile();
//			else if(select==LOAD_FILE)
//				fileManager.loadFile();
			else if(select==QUIT)
				break;
		}
	}
	private int inputNumber(String msg) {
		System.out.print(msg + " : ");
		String input = this.scanner.next();

		int number = -1;
		try {
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;
	}
	
	private void printAlldata() {
		for(User user : userManager.getList())
			System.out.println(user);
	}
	

}
