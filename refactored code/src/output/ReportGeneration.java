package output;

import data.Salesman;

public abstract class ReportGeneration {

	protected Salesman salesman;
	
	public void generateAReport(String fileName) {
		String fullPath = getFullPathName(fileName);
		saveFile(fullPath);                            
	}
	
	public abstract void saveFile(String fileName);
	
	public abstract String getSuffix();
	
	public String getFullPathName(String fileName) {
		return fileName + getSuffix();
	}
}
