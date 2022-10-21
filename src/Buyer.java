/**
 * SER-515 Buyer class inheriting from person class and implementing bridge
 * pattern
 * 

 */
public class Buyer extends Person {
	Buyer() {
		super(theProductMenu);
	}

	Buyer(ProductMenu theProductMenu) {
		super(theProductMenu);
	}

	@Override
	public void showMenu() {
		System.out.println("showing menu selected by buyer :");
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
