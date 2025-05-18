package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import data.Salesman;

public class TXTReportGeneration extends ReportGeneration{

	public TXTReportGeneration(Salesman a){
		salesman = a;
	}
	
	public void saveFile(String fullPathName) {
        BufferedWriter bufferedWriter = null;
        try{
        	bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName)));
            
        	writeInReport(bufferedWriter, "Name: ", salesman.getName());
        	writeInReport(bufferedWriter, "AFM: ", salesman.getAfm());
        	writeInReport(bufferedWriter, "Total Sales: ", (float) salesman.calculateTotalSales());
        	writeInReport(bufferedWriter, "Trousers Sales: ", salesman.calculateSales("Trouser"));
        	writeInReport(bufferedWriter, "Skirts Sales: ", salesman.calculateSales("Skirt"));
        	writeInReport(bufferedWriter, "Shirts Sales: ", salesman.calculateSales("Shirt"));
        	writeInReport(bufferedWriter, "Coats Sales: ", salesman.calculateSales("Coat"));
        	writeInReport(bufferedWriter, "Commission: ", (float) salesman.calculateCommission());
            
        	bufferedWriter.close();
        }catch (IOException ex){
			JOptionPane.showMessageDialog(null,"Υπήρξε κάποιο πρόβλημα κατά την αποθήκευση του αρχείου");
        }
	}

	private void writeInReport(BufferedWriter bufferedWriter, String fieldName, String str) throws IOException {
		bufferedWriter.write(fieldName + str);
		bufferedWriter.newLine();
	}

	private void writeInReport(BufferedWriter bufferedWriter, String fieldName, Float sales) throws IOException {
		bufferedWriter.write(fieldName + sales);
		bufferedWriter.newLine();
	}

	public String getSuffix() {
		return ".txt";
	}
}
