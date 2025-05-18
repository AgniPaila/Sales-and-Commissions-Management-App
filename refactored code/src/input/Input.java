package input;

import java.io.File;

import data.Salesman;
import data.Receipt;

public abstract class Input {
	
	protected Salesman salesman;
	protected File inputFile;
	protected String inputFilePath;
	protected String name;
	protected String afm;
	protected int receiptID;
	protected String date;
	protected String kind;
	protected double sales;
	protected int items;
	protected String companyName;
	protected String companyCountry;
	protected String companyCity;
	protected String companyStreet;
	protected int companyStreetNumber;
	
	 
	public void loadAFile() {
		readFile();
	}

	public abstract void readFile();

	public Input() {
		salesman = new Salesman();
		kind  = new String("");
	}
	
	public void addSalesman() {
		salesman.setName(name);
		salesman.setAfm(afm);
	}
	
	public void addReceipt() {
		Receipt receipt;			
			if(kind.equals("Shirts")) {
				receipt = new Receipt("Shirt");
			}
			else if (kind.equals("Skirts")) {
				receipt = new Receipt("Skirt");
			}
			else if (kind.equals("Trousers")) {
				receipt = new Receipt("Trouser");
			}
			else {
				receipt = new Receipt("Coat");
			}
			
			receipt.setReceiptID(receiptID);			
			receipt.setDate(date);
			receipt.setSales(sales);
			receipt.setItems(items);
			receipt.getCompany().setName(companyName);
			receipt.getCompany().getCompanyAddress().setCountry(companyCountry);
			receipt.getCompany().getCompanyAddress().setCity(companyCity);
			receipt.getCompany().getCompanyAddress().setStreet(companyStreet);
			receipt.getCompany().getCompanyAddress().setStreetNumber(companyStreetNumber);
			salesman.getReceipts().add(receipt);
	}
	
	public Salesman getSalesman() {
		return salesman;
	}
}
