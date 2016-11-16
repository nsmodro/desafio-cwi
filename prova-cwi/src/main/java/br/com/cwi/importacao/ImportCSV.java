package br.com.cwi.importacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ImportCSV {
	
	public Map<Calendar, Map<String, BigDecimal>>  listTaxas = new HashMap<Calendar, Map<String, BigDecimal>>();
	static final String path =  "src/resources/";
	
	public void run() {
		
		ArrayList<String> files = listFilesCSV(path);
		
		for (String file : files) {
			Map<String, BigDecimal> aux = new HashMap<String, BigDecimal>();
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			String linha;
			Calendar c = Calendar.getInstance();
			
			
			 while ((linha = br.readLine()) != null) {
		            String[] arrayString = linha.split(";");
		            
		            listTaxas.put(arrayString[3], new BigDecimal(arrayString[4].replace(",",".")));
		        }
		}
		
		
		
		BufferedReader br = null;
		
		
	    	    
	    try {

	        br = new BufferedReader(new FileReader(f1));
	        String linha;
	        
	        while ((linha = br.readLine()) != null) {
	            String[] arrayString = linha.split(";");
	            
	            listTaxas.put(arrayString[3], new BigDecimal(arrayString[4].replace(",",".")));
	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		
	}
	
	public ArrayList<String> listFilesCSV(String s) {
		ArrayList<String> listFiles = new ArrayList<String>();
		
		File folder = new File(s);
		File[] files = folder.listFiles();

		for (File file : files) {
			if (file.isFile()) {
				if (isCSVFile(file.getName())) {
					listFiles.add(file.getName());
				}
				file.getAbsolutePath();
				try {
					file.getCanonicalPath();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				file.getPath();
			}
		}
		
		return listFiles;
	}
	
	public boolean isCSVFile(String nameFile) {
		String[] aux = nameFile.split("\\.");
		if(aux[aux.length-1].equals("csv")) return true;
		return false;
	}

}
