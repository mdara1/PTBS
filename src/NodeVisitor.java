/**
 * SER-515 
 * Node Visitor class for Visitor pattern

 */
public abstract class NodeVisitor {

	public abstract void visitFacade(Facade HF);

	public abstract Reminder visitTrading(Trading trading);

	public abstract Reminder visitProduct(ProductList product);

}
