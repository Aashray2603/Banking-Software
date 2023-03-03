package banking;
import java.util.Scanner;

class Bank 
{

	public void run()
	{
		System.out.println("Welcome to the Bank!  What is your name? ");
		
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("Hello " + name + "! We are creating checking and savings accounts for you.");
		System.out.println("What is your address?");
		String address = sc.next();
		
	    Customer customer = new Customer(name, address);
        //create a checking account for customer
        BankAccount checkingAccount = new BankAccount("checking", customer);
	
		//create a savings account for customer
		 BankAccount savingsAccount = new BankAccount("savings", customer);
		
		//gets and prints the customer info associated with the checking account
		System.out.println();
		System.out.println("Customer info: ");
		System.out.println(checkingAccount.getCustomerInfo());
		
		//get and print account info for checking account
		System.out.println("Checking account: ");
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println("Savings account: ");
		System.out.println(savingsAccount.getAccountInfo());
		
		//deposits
		
		//into checking
		System.out.println(); //blank line
		System.out.println("Amount (decimal) to deposit into your checking account?");
		double amount = sc.nextDouble(); //get next token (double)
		checkingAccount.deposit(amount); //deposit into checking account
		
		//into savings
		System.out.println(); //blank line
		System.out.println("Amount (decimal) to deposit into your savings account?");
		amount = sc.nextDouble(); //get next token (double)
		savingsAccount.deposit(amount); //deposit into savings account
		
		//print new balances
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println(savingsAccount.getAccountInfo());
		
		//withdrawals
		
		//from checking
		System.out.println(); //blank line
		System.out.println("Amount (decimal) to withdraw from your checking account?");
		amount = sc.nextDouble(); //get next token (double)
		
		try {
			checkingAccount.withdraw(amount); //withdraw from checking
		} catch (Exception e) {
			//e.printStackTrace();
			//prints custom error message from withdraw method
			System.out.println(e.getMessage());
		} 
		
		//from savings
		System.out.println(); //blank line
		System.out.println("Amount (decimal) to withdraw from your savings account?");
		amount = sc.nextDouble(); //get next token (double)
		
		try {
			savingsAccount.withdraw(amount); //withdraw from savings
		} catch (Exception e) {
			//e.printStackTrace();
			//prints custom error message from withdraw method
			System.out.println(e.getMessage());
		} 
		
		//print new balances
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println(savingsAccount.getAccountInfo());
		
		sc.close();
		
	}

}

class Customer
{
	
	String name;
	String address;
	
	
	public Customer(String name, String address)
	{
        this.name = name;
        this.address = address;
    }

	public String getName()
	{
		return this.name;
	}
	
	public String getAddress()
	{
		return this.address;
	}
}

class BankAccount
{
	
	String accountType;
	double balance;
	Customer customer;

	public BankAccount(String accountType, Customer customer)
	{
		this.accountType = accountType;
		this.customer = customer;
	}

	public void deposit(double amount)
	{
		if (amount > 0)
			this.balance += amount;
		
	}
	
	public void withdraw(double amount) throws Exception
	{
		if (amount > this.balance) 
			System.out.println("Amount is greater than available balance.");

		this.balance -= amount;
	}
	
	public String getAccountInfo() 
	{
		return this.accountType + ": " + this.balance;
	}
	
	public String getCustomerInfo() 
	{
		return this.customer.getName() + " from " + this.customer.getAddress();
	}
}

public class Project
{
	public static void main(String[] args)
    {	
	Bank b1 = new Bank();  //creates new instance of Bank class
	b1.run();              //calls the run method in the bank class
	}
}
