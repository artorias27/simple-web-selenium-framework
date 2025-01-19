package com.art.utils;

import com.art.constants.FrameworkConstants;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {
    public static List<Map<String, String>> getTestcases() {
        try (FileInputStream inputStream = new FileInputStream(FrameworkConstants.EXCEL_PATH)) {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            String sheetName = "RunManager";
            XSSFSheet sheet = workbook.getSheet(sheetName);
            DataFormatter formatter = new DataFormatter();

            int numberOfRows = sheet.getLastRowNum();
            int numberOfColumns = sheet.getRow(0).getLastCellNum();
            Map<String, String> testMap;
            List<Map<String, String>> testList = new ArrayList<>();

            for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
                testMap = new HashMap<>();
                for (int colIndex = 0; colIndex < numberOfColumns; colIndex++) {
                    String key = sheet.getRow(0).getCell(colIndex).getStringCellValue();
                    String value = formatter.formatCellValue(sheet.getRow(rowIndex + 1).getCell(colIndex));
                    testMap.put(key, value);
                }
                testList.add(testMap);
            }
            return testList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
