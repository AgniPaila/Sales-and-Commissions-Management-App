package input;

import java.io.File;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLInput extends Input {

	public XMLInput(File receiptFileXML ){
		inputFile = receiptFileXML;
	}
	
    public void readFile() {
        try {
        	DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        	DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        	Document doc = docBuilder.parse(inputFile);
        	 
        	doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName("Agent");
			
        	name = readFieldFromFile(nodeLst, "Name");
        	afm = readFieldFromFile(nodeLst, "AFM");
        	addSalesman();
        	NodeList receiptsNodeList = ((Element) nodeLst.item(0)).getElementsByTagName("Receipt");
			
            int size = receiptsNodeList.getLength();
            for(int i=0; i<size; i++){
            	receiptID = Integer.parseInt(readFieldFromFile(receiptsNodeList, "ReceiptID"));
            	date = readFieldFromFile(receiptsNodeList, "Date");
            	kind = readFieldFromFile(receiptsNodeList, "Kind");
            	sales = Double.parseDouble(readFieldFromFile(receiptsNodeList, "Sales"));
				items = Integer.parseInt(readFieldFromFile(receiptsNodeList, "Items"));
				companyName = readFieldFromFile(receiptsNodeList, "Company");
				companyCountry = readFieldFromFile(receiptsNodeList, "Country");
				companyCity = readFieldFromFile(receiptsNodeList, "City");
				companyStreet = readFieldFromFile(receiptsNodeList, "Street");
				companyStreetNumber = Integer.parseInt( readFieldFromFile(receiptsNodeList, "Number"));
				addReceipt();
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog
			(null,"Προέκυψε κάποιο πρόβλημα κατά το διάβασμα του αρχείου");
		} 
    }
	private String readFieldFromFile(NodeList nodeLst, String field) {
		return ((Element) nodeLst.item(0)).getElementsByTagName(field).item(0).getChildNodes().item(0).getNodeValue().trim();
	}
    
}

