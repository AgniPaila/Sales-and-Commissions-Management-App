package output;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import data.Salesman;

public class XMLReportGeneration extends ReportGeneration{

	public XMLReportGeneration(Salesman a){
			salesman = a;
	}
		
	public void saveFile(String fullPathName) {
        try {
        	 DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        	 DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        	 Document document = documentBuilder.newDocument();
        	 Element salesmanElem = document.createElement("Agent");
        	 document.appendChild(salesmanElem);
       	 
        	 writeInReport(document, salesmanElem, "Name", salesman.getName());
        	 writeInReport(document, salesmanElem, "AFM", salesman.getAfm());
        	 writeInReport(document, salesmanElem, "TotalSales", salesman.calculateTotalSales());
        	 writeInReport(document, salesmanElem, "TrouserSales", salesman.calculateSales("Trouser"));
        	 writeInReport(document, salesmanElem, "SkirtsSales", salesman.calculateSales("Skirt"));
        	 writeInReport(document, salesmanElem, "ShirtsSales", salesman.calculateSales("Shirt"));
        	 writeInReport(document, salesmanElem, "CoatsSales", salesman.calculateSales("Coat"));
        	 writeInReport(document, salesmanElem, "Commission", salesman.calculateCommission());
    	 
        	 TransformerFactory transformerFactory = TransformerFactory.newInstance();
        	 Transformer transformer = transformerFactory.newTransformer();
        	 transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        	 transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        	 DOMSource domSource = new DOMSource(document);
        	 StreamResult streamResult = new StreamResult(new File(fullPathName));
        	 transformer.transform(domSource, streamResult);
    		
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}

	private void writeInReport(Document document, Element salesmanElem, String fieldName, Float sales) {
		Element elem = document.createElement(fieldName);
		elem.appendChild(document.createTextNode(Float.toString(sales)));
		salesmanElem.appendChild(elem);
	}
	private void writeInReport(Document document, Element salesmanElem, String fieldName, Double sales) {
		Element elem = document.createElement(fieldName);
		elem.appendChild(document.createTextNode(Double.toString(sales)));
		salesmanElem.appendChild(elem);
	}
	private void writeInReport(Document document, Element salesmanElem, String fieldName, String name) {
		Element elem = document.createElement(fieldName);
		elem.appendChild(document.createTextNode(name));
		salesmanElem.appendChild(elem);
	}

	public String getSuffix() {
		return ".xml";
	}
}

