package input;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLInput extends Input {
	
	public HTMLInput(File receiptFileHTML ){
		inputFile = receiptFileHTML;
	}

	public void readFile(){
		
		try {
			Document document = Jsoup.parse(inputFile);
			
	        name = document.select("h2").text().substring(6);
	        afm = document.select("p:contains(AFM)").text().substring(5);
	        addSalesman();
	        
	        Elements receipts = document.select("div");
	        for (Element receipt : receipts) {
	            receiptID = Integer.parseInt(receipt.select("h4").text().substring(12));
	            date = receipt.select("p:contains(Date)").text().substring(6);
	            kind = receipt.select("p:contains(Kind)").text().substring(6);
	            sales = Double.parseDouble(receipt.select("p:contains(Sales)").text().substring(7));
	            items = Integer.parseInt(receipt.select("p:contains(Items)").text().substring(7));
	            companyName = receipt.select("p:contains(Company)").text().substring(9);
	            companyCountry = receipt.select("p:contains(Country)").text().substring(9);
	            companyCity = receipt.select("p:contains(City)").text().substring(6);
	            companyStreet = receipt.select("p:contains(Street)").text().substring(8);
	            companyStreetNumber = Integer.parseInt(receipt.select("p:contains(Number)").text().substring(8));
	            
	            addReceipt();
	        }
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog
			(null,"Προέκυψε κάποιο πρόβλημα κατά το διάβασμα του αρχείου");
		}
	}
}

