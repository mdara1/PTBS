

public class Trading extends Reminder {

	public Reminder accept(NodeVisitor nodeVisitor) {
		System.out.println("Trading Reminder ...");
		return nodeVisitor.visitTrading(this);
	}

}
