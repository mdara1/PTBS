/**
 * SER-515 Seller class to inherit person class
 * 

 */
public class Seller extends Person {
	Seller() {
		super(theProductMenu);
	}

	Seller(ProductMenu theProductMenu) {
		super(theProductMenu);
	}


	@Override
	public void showMenu() {
		System.out.println("showing menu selected by seller :");
		theProductMenu.showMenu();

	}

	@Override
	public ProductMenu CreateProductMenu(int nProductCategory) {
		if(nProductCategory == 1)
			return new MeatProductMenu();
		else {
			return new ProduceProductMenu();
		}
	}

}
