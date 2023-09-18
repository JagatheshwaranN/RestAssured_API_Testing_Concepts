package miniwork.utils;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReader {

    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet xssfSheet;
    private XSSFRow xssfRow;
    private XSSFCell xssfCell;
    private CellStyle cellStyle;
    private final String filePath;

    public ExcelReader(String filePath){
        this.filePath = filePath;
    }

    public int getExcelRowCount(String xssfSheetName){

        int rowCount = 0;
        try {
            fileInputStream = new FileInputStream(filePath);
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
            xssfSheet = xssfWorkbook.getSheet(xssfSheetName);
            rowCount = xssfSheet.getLastRowNum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                xssfWorkbook.close();
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return rowCount;
    }

    public int getExcelCellCount(String xssfSheetName, int rowNum){

        int cellCount = 0;
        try {
            fileInputStream = new FileInputStream(filePath);
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
            xssfSheet = xssfWorkbook.getSheet(xssfSheetName);
            xssfRow = xssfSheet.getRow(rowNum);
            cellCount = xssfRow.getLastCellNum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                xssfWorkbook.close();
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return cellCount;
    }

    public String getCellData(String xssfSheetName, int rowNum, int colNum) {

        String data;
        try{
        fileInputStream = new FileInputStream(filePath);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        xssfSheet = xssfWorkbook.getSheet(xssfSheetName);
        xssfRow = xssfSheet.getRow(rowNum);
        xssfCell = xssfRow.getCell(colNum);
        DataFormatter dataFormatter = new DataFormatter();
        data = dataFormatter.formatCellValue(xssfCell);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                xssfWorkbook.close();
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return data;
    }
}
