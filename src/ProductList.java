import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * SER-515 Course List class to implement the iterator pattern 
 * 

 */
@SuppressWarnings("rawtypes")
public class ProductList extends Reminder {

	List<Product> theProductList = new ArrayList<>();

	ProductList() {

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
				}catch(Exception e){}
			}
		}
	}



	public Reminder accept(NodeVisitor nodeVisitor) {
		System.out.println("Product List Reminder ...");
		return nodeVisitor.visitProduct(this);
	}

}
