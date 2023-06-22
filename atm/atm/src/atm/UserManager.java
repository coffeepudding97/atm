package atm;

import java.util.ArrayList;

public class UserManager {
	

	private UserManager() {}
	
	private ArrayList<User> list;
	
	private static UserManager instance = new UserManager();
	
	public static UserManager getInstance() {
		return instance;
	}
	
	
	public void joinUser() {
		int userCode = generateRandomCode();
		String id = Atm.scanner.next();
		String password = Atm.scanner.next();
		String name = Atm.scanner.next();
		
		if(!duplId(id)) {
			User user = new User(userCode, name, id, password);
			this.list.add(user);
			System.out.println("회원가입 완료");
		} else {
			System.err.println("중복되는 아이디 입니다.");
		}
		
	}
	
	public ArrayList<User> getList() {
		return(ArrayList<User>) this.list.clone();
	}
	
	private boolean duplId(String id) {
		boolean dupl = false;
		for(User user : this .list) {
			if(user.getId().equals(id))
				dupl=true;
		}
		return dupl;
	}
	
	private int generateRandomCode() {
		int code = 0;
		
		while(true) {
			code = (int)(Math.random() * 9000)+1000;
			
			boolean dupl = false;
			for(User user : this.list) {
				if(user.getUserCode() == code)
					dupl = true;
			}
			if(!dupl)
				break;
			
		}
		
		return code;
	}
	
	public void leaveUser() {
		String id = Atm.scanner.next();
		if(duplId(id)) {
			
		}
	}
	
	
}
