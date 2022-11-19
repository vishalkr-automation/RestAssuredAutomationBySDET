package dataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DemoClass {

	@Test
	public void f() throws IOException{
		/*String path=".\\TestData\\empdata.xlsx";
		int count=XLUtils.getRowCount(path, "Sheet1");
		System.out.println(count);
		File src=new File(".\\TestData\\empdata.xlsx");
		//String Filesrc =".\\TestData\\empdata.xlsx";		
		FileInputStream fi=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		
		XSSFSheet sheet=wb.getSheetAt(0);
		
		String data=sheet.getRow(0).getCell(0).getStringCellValue();
		
		System.out.println(data);*/
		String path=System.getProperty("user.dir")+".\\TestData\\empdata.xlsx";
		/*String data=XLUtils.getCellData(path, "Sheet1", 1, 2);
		System.out.println(data);*/
		
		
		int rowNum=XLUtils.getRowCount(path, "Sheet1");
		int ColNum=XLUtils.getCellCount(path, "Sheet1", rowNum);
		
		for(int i=1; i<=rowNum; i++){
			
			for(int j=0; j<ColNum; j++){
				String data1=XLUtils.getCellData(path, "Sheet1", i, j);
				System.out.println(data1);
			}
		}
		
		
		
	}
}
