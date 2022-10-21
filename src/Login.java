import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 * SER-515 Login class implementing the implementation for login using facade
 * class
 *
 */
public class Login {
	int userType;
	String buyerInfoPath = new File("src/resources/BuyerInfo.txt")
			.getAbsolutePath();
	String sellerInfoPath = new File("src/resources/SellerInfo.txt")
			.getAbsolutePath();

	Map<String, String> buyerInfoMap = getHashMapFromTextFile(buyerInfoPath);
	Map<String, String> sellerInfoMap = getHashMapFromTextFile(sellerInfoPath);

	Login() {
		userType = 0;
	}

	public int login() {

		System.out.println("Enter Username ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String username = scan.next();
		System.out.println("Enter Password ");
		String password = scan.next();
		userType = validation(username, password);
		return userType;
	}

	public static Map<String, String> getHashMapFromTextFile(String path){
		Map<String, String> mapFileContents = new HashMap<>();
		BufferedReader br = null;
		try{
			//create file object
			File file = new File(path);
			//create BufferedReader object from the File
			br = new BufferedReader(new FileReader(file));
			String line = null;
			//read file line by line
			while ((line = br.readLine()) != null){
				String[] parts = line.split(":");
				//first part is userID, second is password
				String name = parts[0].trim();
				String password = parts[1].trim();
				if( !name.equals("") && !password.equals("") )
					mapFileContents.put(name, password);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				}catch(Exception e){};
			}
		}
		return mapFileContents;
	}

	public int validation(String username, String password) {

		if(buyerInfoMap.containsKey(username) && password.equals(buyerInfoMap.get(username))){
			System.out.println("Welcome" + username);
			userType = 0;
		}
		else if (sellerInfoMap.containsKey(username) && password.equals(sellerInfoMap.get(username))){
			System.out.println("Welcome" + username);
			userType = 1;
		}
		else if ((username.equalsIgnoreCase("Student")) && (password.equalsIgnoreCase(password))) {
			System.out.println("Welcome Student ");
			userType = 0;
		}
		else{
			System.out.println("sorry , invalid credentials. Please start the program and try again");
			System.exit(-1);
		}

		return userType;

	}

}
