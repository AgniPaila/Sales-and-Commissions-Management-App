package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import data.Salesman;

public class HTMLReportGeneration extends ReportGeneration{

	public HTMLReportGeneration(Salesman a){
		salesman = a;
	}
	
	public void saveFile(String fullPathName) {
        BufferedWriter bufferedWriter = null;
        try{
        	bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName)));
            
        	writeNameInReport(bufferedWriter);
            writeAFMInReport(bufferedWriter);
            writeTotalSalesInReport(bufferedWriter);
            writeTrouserSalesInReport(bufferedWriter);
            writeSkirtSalesInReport(bufferedWriter);
            writeShirtSalesInReport(bufferedWriter);
            writeCoatSalesInReport(bufferedWriter);
            writeCommissionInReport(bufferedWriter);
        	bufferedWriter.close();
        	
        }catch (IOException ex){
			JOptionPane.showMessageDialog(null,"Υπήρξε κάποιο πρόβλημα κατά την αποθήκευση του αρχείου");
        }
	}

	private void writeCommissionInReport(BufferedWriter bufferedWriter) throws IOException {
		bufferedWriter.write("<p>Commission: " + salesman.calculateCommission()+"</p></html>");
	}

	private void writeCoatSalesInReport(BufferedWriter bufferedWriter) throws IOException {
		bufferedWriter.write("<p>Coats Sales: " + salesman.calculateSales("Coat")+"</p>");
	}

	private void writeShirtSalesInReport(BufferedWriter bufferedWriter) throws IOException {
		bufferedWriter.write("<p>Shirts Sales: " + salesman.calculateSales("Shirt")+"</p>");
	}

	private void writeSkirtSalesInReport(BufferedWriter bufferedWriter) throws IOException {
		bufferedWriter.write("<p>Skirts Sales: " + salesman.calculateSales("Skirt")+"</p>");
	}

	private void writeTrouserSalesInReport(BufferedWriter bufferedWriter) throws IOException {
		bufferedWriter.write("<p>Trousers Sales: " + salesman.calculateSales("Trouser")+"</p>");
	}

	private void writeTotalSalesInReport(BufferedWriter bufferedWriter) throws IOException {
		bufferedWriter.write("<p>Total Sales: " + salesman.calculateTotalSales()+"</p>");
	}

	private void writeAFMInReport(BufferedWriter bufferedWriter) throws IOException {
		bufferedWriter.write("<h3>AFM: " + salesman.getAfm()+"</h3>");
	}

	private void writeNameInReport(BufferedWriter bufferedWriter) throws IOException {
		bufferedWriter.write("<html><h2>Name: " + salesman.getName()+ "</h2>"); 
	}
	
	public String getSuffix() {
		return ".html";
	}
}
