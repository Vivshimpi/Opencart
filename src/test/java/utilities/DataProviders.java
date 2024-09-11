package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{

	@DataProvider(name="LoginData")
	public String[][] getAllData() throws IOException
	{
		String path =".\\testData\\CartTestData.xlsx";
		//taking Excel file from testData
		
		
		ExcelUtility xl = new ExcelUtility(path);
		//Creating an object for ExcelUtility
		
		int totalrows= xl.getRowCount("Sheet1");
		int totalcols = xl.getCellCount("Sheet1", 1);
		
		String logindata [][] = new String[totalrows][totalcols];
		//create for two dimension array which can
		
		for(int i=1; i<=totalrows; i++)//1 //read the data from xl storing in two dimensional array
		{
			for(int j=0; j<totalcols; j++)//0 // i is rows j is cols
			{
				logindata[i-1][j]= xl.getCellData("Sheet1", i, j); //1,0
			}
			}
		return logindata;//returning two dimension array
	}
}
