package output;

import java.io.FileWriter;
import java.io.IOException;

import data.Receipt;

public class ReceiptAppenderInTXTFile extends ReceiptAppender{

	public void appendFile(Receipt receipt){
		System.out.println("Mpike sto TXT");
		System.out.println(fileToAppend.getAbsolutePath());

		try {
			FileWriter fileWriter = parseFileToAppend();		
			fileWriter.write("\n");
			writeInFile(receipt, fileWriter, "Receipt ID: ", String.valueOf(receipt.getReceiptID()));
			writeInFile(receipt, fileWriter, "Date: ", receipt.getDate());
			writeInFile(receipt, fileWriter, "Kind: ", receipt.getKind());
			writeInFile(receipt, fileWriter, "Sales: ", String.valueOf(receipt.getSales()));
			writeInFile(receipt, fileWriter, "Items: ", String.valueOf(receipt.getItems()));
			writeInFile(receipt, fileWriter, "Company: ", receipt.getCompany().getName());
			writeInFile(receipt, fileWriter, "Country: ", receipt.getCompany().getCompanyAddress().getCountry());
			writeInFile(receipt, fileWriter, "City: ", receipt.getCompany().getCompanyAddress().getCity());
			writeInFile(receipt, fileWriter, "Street: ", receipt.getCompany().getCompanyAddress().getStreet());
			writeInFile(receipt, fileWriter, "Number: ", String.valueOf(receipt.getCompany().getCompanyAddress().getStreetNumber()));

			fileWriter.close();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	private FileWriter parseFileToAppend() throws IOException {
		FileWriter fileWriter = new FileWriter(fileToAppend,true);
		return fileWriter;
	}

	private void writeInFile(Receipt receipt, FileWriter fileWriter, String field, String valueOfField) throws IOException {
		fileWriter.write(field);
		fileWriter.write(valueOfField);
		fileWriter.write("\n");
	}
	

}