package output;

import java.io.File;

import data.Receipt;


public abstract class ReceiptAppender {

	protected File fileToAppend;
	
	public void appendAReceipt(Receipt receipt) {       
		setFileToAppend(fileToAppend);              
		appendFile(receipt);                        
	}
		
	public abstract void appendFile(Receipt receipt);

	public void setFileToAppend(File fileToAppend) {
		this.fileToAppend = fileToAppend;
		
	}

}

