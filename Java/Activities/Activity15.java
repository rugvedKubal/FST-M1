package activities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Activity15 {

    private static final String FILE_NAME = "resources/TestSheet.xlsx";

    public static void main(String[] args) {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Data types in Java");

        Object[][] dataTypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };

        int rowNum = 0;

        for(Object[] dataType : dataTypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for(Object field : dataType) {
                Cell cell = row.createCell(colNum++);
                if(field instanceof String) {
                    cell.setCellValue((String)field);
                }
                else if(field instanceof Integer) {
                    cell.setCellValue((Integer)field);
                }
            }
        }

        try {
            FileOutputStream fs = new FileOutputStream(FILE_NAME);
            wb.write(fs);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
