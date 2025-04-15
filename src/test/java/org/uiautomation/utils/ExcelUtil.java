package org.uiautomation.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil {
    private final Workbook workbook;

    public ExcelUtil(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            this.workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCellValue(String excelPath) {
        String[] strArr = excelPath.split("\\.");
        String sheetName = strArr[0],
                rowName = strArr[1],
                colName = strArr[2];
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist");
        }

        Map<String, Integer> colMap = getColumnMap(sheet);
        Integer colIndex = colMap.get(colName);
        if (colIndex == null) {
            throw new IllegalArgumentException("Column " + colName + " does not exist");
        }

        Map<String, Integer> rowMap = getRowMap(sheet);
        Integer rowIndex = rowMap.get(rowName);
        if (rowIndex == null) {
            throw new IllegalArgumentException("Row " + rowName + " does not exist");
        }

        Row row = sheet.getRow(rowIndex);
        Cell cell = row.getCell(colIndex);
        if (cell == null) {
            return null;
        }

        return cell.toString();
    }

    public void setCellValue(String sheetName, String rowName, String colName, String value) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            sheet = workbook.createSheet(sheetName);
        }

        Map<String, Integer> colMap = getColumnMap(sheet);
        Integer colIndex = colMap.get(colName);
        if (colIndex == null) {
            colIndex = colMap.size();
            Cell newCell = sheet.getRow(0).createCell(colIndex);
            newCell.setCellValue(colName);
        }

        Map<String, Integer> rowMap = getRowMap(sheet);
        Integer rowIndex = rowMap.get(rowName);
        if (rowIndex == null) {
            rowIndex = rowMap.size() + 1;
            Row newRow = sheet.createRow(rowIndex);
            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(rowName);
        }

        Row row = sheet.getRow(rowIndex);
        Cell cell = row.createCell(colIndex);
        cell.setCellValue(value);
    }

    private Map<String, Integer> getColumnMap(Sheet sheet) {
        Map<String, Integer> colMap = new HashMap<>();
        Row headerRow = sheet.getRow(0);
        if (headerRow != null) {
            for (Cell cell : headerRow) {
                colMap.put(cell.getStringCellValue(), cell.getColumnIndex());
            }
        }
        return colMap;
    }

    private Map<String, Integer> getRowMap(Sheet sheet) {
        Map<String, Integer> rowMap = new HashMap<>();
        for (Row row : sheet) {
            Cell cell = row.getCell(0);
            if (cell != null) {
                rowMap.put(cell.getStringCellValue(), row.getRowNum());
            }
        }
        return rowMap;
    }

    public void save(String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }
    }

    public void close() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }
}
