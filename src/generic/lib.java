package generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class lib {

	//************Method to Read the Config Properties****************
	public static String getProperty(String path,String key)
	{
		String value="";
		try
		{
			Properties p=new Properties();
			FileInputStream fin=new FileInputStream(path);
			p.load(fin);
			value=p.getProperty(key);
		}
		catch(Exception e)
		{
			
		}
		return value;
	}
	//************This Method will Read the data from Excel**************
	public static String readData(String sheet, int row, int cell)
	{
		String s="";
		try
		{
		File f=new File("./data/DataSheet.xlsx");
		Workbook wb=WorkbookFactory.create(f);
		s=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		}
		catch(Exception e)
		{
			
		}
		return s;
	}
}
