import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * SER-515 Facade class to take care of the facade pattern it calls the classes
 * for bridge pattern, factory pattern, visitor pattern, iterator pattern
 *
 */

public class Facade {
	int userType;
	int nProductCategory;
	List<Product> theProductList = new ArrayList<>();
	Person thePerson;

	public void startFacade() {
		System.out.println("Facade pattern started \n");
		createProductList(); // adding products to the map
		userType = login(new Login());
		System.out.println(
				"Please pick a number to choose from available Product Menus \n 1. MeatProduct Menu \n 2. ProduceProduct Menu ");
		Scanner scan = new Scanner(System.in);
		nProductCategory = scan.nextInt();
		// pattern implemented (Bridge implementation and Factory implementation)
		if (nProductCategory == 1 || nProductCategory == 2) {
			System.out.println("Factory pattern implemented");
			Product selectProduct = SelectProduct(nProductCategory, userType);
			System.out.println("\n Selected Product is:" + selectProduct.getProductName());
		} else {
			System.out.println("Wrong Selection");
			System.exit(-1);
		}

	}

	public int login(Login object) {
		return object.login();
	}

	public void addTrading() {
	}

	public void viewTrading( ) {
	}

	public void decideBidding ( ) {
	}

	public void discussBidding() {

	}

	public void submitBidding( ) {
	}

	public void remind() {
	}

	public void createUser(UserInfoItem userinfoitem) {
	}

	public void createProductList() {
		String productInfoPath = new File("src/resources/ProductInfo.txt")
				.getAbsolutePath();
		BufferedReader br = null;
		try{
			//create file object
			File file = new File(productInfoPath);
			//create BufferedReader object from the File
			br = new BufferedReader(new FileReader(file));
			String line = null;
			//read file line by line
			while ((line = br.readLine()) != null){
				String[] parts = line.split(":");
				//first part is productType , second is productName
				String productType = parts[0].trim();
				String productName = parts[1].trim();
				if(!productType.equals("") && !productName.equals(""))
				{
					Product newProduct = new Product();
					newProduct.setProductCategory(productType);
					newProduct.setProductName(productName);
					theProductList.add(newProduct);
				}

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
	}

	public void AttachProductToUser(ProductMenu pm) {
	}
	//factory method implementation
	public Product SelectProduct(int nProductCategory, int userType) {

		if(userType == 0){
			thePerson = new Buyer();

		}
		if(userType == 1){
			thePerson = new Seller();
		}
			ProductMenu productMenu = thePerson.CreateProductMenu(nProductCategory);
			productMenu.showMenu();

			Scanner scan = new Scanner(System.in);
			int option = scan.nextInt();
			if(nProductCategory == 1) {

				theProductList.removeIf(product -> product.productCategory.equals("Produce"));

			}
			else {
				theProductList.removeIf(product -> product.productCategory.equals("Meat"));
			}

			return theProductList.get(option - 1);
	}

	public void productOperation() {

	}

}
