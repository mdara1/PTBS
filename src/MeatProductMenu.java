import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * SER-515 MeatProductMenu responsible for bridge pattern and factory pattern
 * 

 */
public class MeatProductMenu extends ProductMenu {

	List<Product> meatProductList;

	public MeatProductMenu() {

		meatProductList = new ArrayList<>();
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
					meatProductList.add(newProduct);
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
		meatProductList.removeIf(product -> product.productCategory.equals("Produce"));

	}

	@Override
	public void ShowAddButtons() {
		System.out.println();

	}

	@Override
	public void ShowViewButtons() {
		System.out.println();

	}

	@Override
	public void ShowRadios() {
		System.out.println();

	}

	@Override
	public void showComboxes() {
		System.out.println();

	}

	@Override
	public void ShowLabels() {
		System.out.println();

	}

	public void showMenu() {
		System.out.println("Meat Product Menu ...\n Bridge Pattern for connection used ");
		for (int i = 0; i < meatProductList.size(); i++) {
			System.out.println(i+1 + " " + meatProductList.get(i).getProductName());
		}
	}
}
