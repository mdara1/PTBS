
public class Buyer extends Person {
	Buyer() {
		super(theProductMenu);
	}
	Buyer(ProductMenu theProductMenu) {
		super(theProductMenu);
	}
	@Override
	public ProductMenu CreateProductMenu(int nProductCategory) {
		if(nProductCategory == 1)
			return new MeatProductMenu();
		else return new ProduceProductMenu();
	}
	@Override
	public void showMenu() {
		System.out.println("Menu Selected by the Buyer :");
		theProductMenu.showMenu();
	}

}
