package scenario1_LoginModule;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReadData {
	@Test
	public void ecxeldataread() throws IOException {
		File fl = new File("./" + "\\DataSet\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(fl);

		// workbook-->sheet-->row-->cell-->data
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// no of rows
		int rows = wb.getSheet("Userdata").getPhysicalNumberOfRows();
		System.out.println("Total number of rows is: " + rows);

		// no of cells
		int cells = wb.getSheet("Userdata").getRow(0).getPhysicalNumberOfCells();
		System.out.println("Total number of cell is: " + cells);

		// create array as per file size
		Object data[][] = new Object[rows - 1][cells];

		// read data from file and save it in array
		for (int r = 1; r < rows; r++) {
			for (int c = 0; c < cells; c++) {
				data[r - 1][c] = wb.getSheet("Userdata").getRow(r).getCell(c).getStringCellValue();
				System.out.println(data[r - 1][c]);
			}
		}

	}
}
