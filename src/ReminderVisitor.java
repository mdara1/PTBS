/**
 * SER-515 Reminder Visitor class responsible for implementing visitor pattern
 * 

 */
public class ReminderVisitor extends NodeVisitor {
	String m_Reminder;

	@Override
	public void visitFacade(Facade HF) {
		System.out.println("visiting Facade ....");

	}

	@Override
	public Reminder visitTrading(Trading trading) {
		System.out.println("visiting Trading ....");
		return trading;
	}

	@Override
	public Reminder visitProduct(ProductList productList) {
		System.out.println("visiting Product ....");
		return productList;

	}

}
