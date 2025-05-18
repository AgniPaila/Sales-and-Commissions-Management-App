package output;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import data.Receipt;

public class ReceiptAppenderInXMLFile  extends ReceiptAppender{

	public void appendFile(Receipt receipt){

		try{
		
			Document doc = parseFileToAppend();
		
			Node salesman = doc.getFirstChild();

			Element receiptElem = doc.createElement("Receipt");
			salesman.appendChild(receiptElem);		
			
			writeInFile(receipt, doc, receiptElem, "ReceiptID", doc.createTextNode(String.valueOf(receipt.getReceiptID())));
			writeInFile(receipt, doc, receiptElem, "Date", doc.createTextNode(receipt.getDate()));
			writeInFile(receipt, doc, receiptElem, "Kind",  doc.createTextNode(receipt.getKind()));
			writeInFile(receipt, doc, receiptElem, "Sales", doc.createTextNode(String.valueOf(receipt.getSales())));
			writeInFile(receipt, doc, receiptElem, "Items", doc.createTextNode(String.valueOf(receipt.getItems())));
			writeInFile(receipt, doc, receiptElem, "Company", doc.createTextNode(receipt.getCompany().getName()));
			writeInFile(receipt, doc, receiptElem, "Country", doc.createTextNode(receipt.getCompany().getCompanyAddress().getCountry()));
			writeInFile(receipt, doc, receiptElem, "City", doc.createTextNode(receipt.getCompany().getCompanyAddress().getCity()));
			writeInFile(receipt, doc, receiptElem, "Street", doc.createTextNode(receipt.getCompany().getCompanyAddress().getStreet()));
			writeInFile(receipt, doc, receiptElem, "Number", doc.createTextNode(String.valueOf(receipt.getCompany().getCompanyAddress().getStreetNumber())));
	    
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	   	 	transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(fileToAppend);
			transformer.transform(source, result);

		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	private Document parseFileToAppend() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(fileToAppend);
		return doc;
	}
	private void writeInFile(Receipt receipt, Document doc, Element receiptElem, String field, Node valueOfField) throws IOException {
		Element numberElem = doc.createElement(field);
		numberElem.appendChild(valueOfField);
		receiptElem.appendChild(numberElem);
	}
	

}
