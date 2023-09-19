package miniwork.utils;

import org.testng.annotations.DataProvider;

public class DataSupplier {

    @DataProvider(name="userdata")
    public Object[][] getUserData(){

        String path = System.getProperty("user.dir")+"//src//test//resources//user.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        int totalRows = excelReader.getExcelRowCount("payload");
        int totalCols = excelReader.getExcelCellCount("payload", 1);
        String[][] dataFromExcel = new String[totalRows][totalCols];
        for(int i = 1; i <= totalRows; i++){
            for(int j = 0; j < totalCols; j++){
                dataFromExcel[i - 1][j] = excelReader.getExcelCellData("payload", i, j);
            }
        }
        return dataFromExcel;
    }

    @DataProvider(name="username")
    public Object[] getUserName(){

        String path = System.getProperty("user.dir")+"//src//test//resources//user.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        int totalRows = excelReader.getExcelRowCount("payload");
        String[] dataFromExcel = new String[totalRows];
        for(int i = 1; i <= totalRows; i++){
            dataFromExcel[i - 1] = excelReader.getExcelCellData("payload", i, 1);
        }
        return dataFromExcel;
    }
}
