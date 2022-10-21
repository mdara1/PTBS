/**
 * SER-515
 * Person abstract class  

 */
public abstract class Person {
	protected static ProductMenu theProductMenu;

	public abstract void showMenu();

	public abstract ProductMenu CreateProductMenu(int nProductCategory);

	@SuppressWarnings("static-access")
	Person(ProductMenu theProductMenu) {
		this.theProductMenu = theProductMenu;
	}

	public void ShowAddButtons() {
		theProductMenu.ShowAddButtons();
	}

	public void shwViewButtons() {

		theProductMenu.ShowViewButtons();
	}

	public void showRadios() {
		theProductMenu.ShowRadios();
	}

	public void showCombos() {
		theProductMenu.showComboxes();
	}

	public void showLabels() {
		theProductMenu.ShowLabels();
	}
}
