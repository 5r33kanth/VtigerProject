
package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtilities {

	String propertyFilePath = "C:\\Testing\\Vtiger\\src\\test\\resources\\datas\\vtigerdata.properties";
	String excelFilePath = "C:\\Testing\\Vtiger\\src\\test\\resources\\datas\\dataBook.xlsx";
	
	
	//Set data

	public void setDataIntoPropertyFile(String key, String value) {

		try {

			// specify the path by creating object for FIS
			FileInputStream fis = new FileInputStream(propertyFilePath);

			// create object for properties class
			Properties p = new Properties();

			// load file into property file
			p.load(fis);

			// set data
			p.setProperty(key, value);

			// create object for FOS
			FileOutputStream fout = new FileOutputStream(propertyFilePath);

			// store data
			p.store(fout, "Data Stored Successfully");
			
			System.out.println("Data Stored Successfully");
			

		} catch (Exception e) {
			System.out.println("Unable to set data");
		}
	}
	
	//Get data

	public String getDataFromPropertyFile(String property) {
		
		String value="";
		try {
			//specify the path
			FileInputStream fis = new FileInputStream(propertyFilePath);
			
			//create object for properties
			Properties p = new Properties();
			
			//load the file to object
			p.load(fis);
			
			//get the property
			value = p.getProperty(property);
			
		} catch (Exception e) {
			System.out.println("Unable to get data");
		}
		return value;

	}
	
	//Remove data

	public void removeDataFromPropertyFile(String property) {
		
		try {
			//specify the path
			FileInputStream fis = new FileInputStream(propertyFilePath);
			
			//create object for properties class
			Properties p = new Properties();
			
			//load the file
			p.load(fis);
			
			//remove property
			p.remove(property);
			
			//create object for fout
			FileOutputStream fout = new FileOutputStream(propertyFilePath);
			
			//store the value
			p.store(fout, "Data removed successfully");
			
			//print success message 
			System.out.println("Data removed successfully");
			
			
			
		} catch (Exception e) {
			System.out.println("Unable to remove data from prperty file");
		}

	}

	public void setDataInoExcel(String sheet, int row, int cell, String value) {
		
		try {
			
			//specify the path
			FileInputStream fis = new FileInputStream(excelFilePath);
			
			//create workbook
			Workbook wb = WorkbookFactory.create(fis);
			
			//get sheet, create row, create cell, create cell value
			wb.getSheet(sheet).createRow(row).createCell(cell).setCellValue(value);
			
			//create object for fos
			FileOutputStream fout = new FileOutputStream(excelFilePath);
			
			//write inside file
			wb.write(fout);
			
		} catch (Exception e) {
			System.out.println("Unable to set data int excel");
		}

	}

	public String getDataFromExcel(String sheet, int row, int cell) {
		
		String value ="";
		
		try {
			
			//specify the path
			FileInputStream fis = new FileInputStream(excelFilePath);
			
			//create workbook factory
			Workbook wb = WorkbookFactory.create(fis);
			
			//get sheet, create row, create cell, get cell value
			value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			
		} catch (Exception e) {
			System.out.println("Unable to get data from excel");
		}
		
		//return the value
		return value;

	}

	public void setDataIntoDatabase(String query) {
		
		try {
			//fetch jdbc url, jdbc un, jdbc pwd from property file
			String jdbcurl = getDataFromPropertyFile("jdbcurl");
			String jdbcun = getDataFromPropertyFile("jdbcun");
			String jdbcpwd = getDataFromPropertyFile("jdbcpwd");
			
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
			Connection conn = DriverManager.getConnection(jdbcurl, jdbcun, jdbcpwd);
			
			//create statement and execute
			conn.createStatement().execute(query);
			
			//print success message
			System.out.println("query executed successfully");
			
			
			
		} catch (Exception e) {
			System.out.println("unable to execute the query");
		}

	}
	
	

	public ArrayList<Object[]> getDataFromDatabase(String query) {
		
		
		ArrayList<Object[]> al = new ArrayList<Object[]>();              //String--->Object
		
		try {
			//fetch jdbc url, jdbc un, jdbc pwd from property file
			
			String jdbcurl = getDataFromPropertyFile("jdbcurl");
			String jdbcun = getDataFromPropertyFile("jdbcun");
			String jdbcpwd = getDataFromPropertyFile("jdbcpwd");
			
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
			Connection conn = DriverManager.getConnection(jdbcurl, jdbcun, jdbcpwd);
			
			//create statement and execute
			 ResultSet rs = conn.createStatement().executeQuery(query);
			
			while(rs.next()) {
				
				int columnCount = rs.getMetaData().getColumnCount();
				String[] rowdata = new String[columnCount];
				
				for(int i=1; i<=columnCount; i++) {
					rowdata[i-1]=rs.getString(i);
				}
				al.add(rowdata);
			}
			
			
		} catch (Exception e) {
			System.out.println("Unable to get data");
		}
		return al;

	}

}
