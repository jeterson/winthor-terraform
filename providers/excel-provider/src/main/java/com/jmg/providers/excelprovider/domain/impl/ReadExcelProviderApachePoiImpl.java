package com.jmg.providers.excelprovider.domain.impl;

import com.jmg.providers.excelprovider.domain.core.entities.DataColumn;
import com.jmg.providers.excelprovider.domain.core.entities.DataRow;
import com.jmg.providers.excelprovider.domain.core.entities.DataSet;
import com.jmg.providers.excelprovider.domain.core.entities.DataTable;
import com.jmg.providers.excelprovider.domain.service.input.ReadExcelProvider;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReadExcelProviderApachePoiImpl implements ReadExcelProvider {

    private static final int HEADER_ROW_DEFAULT_INDEX = 0;
    private static final String HEADER_ROW_DEFAULT_PREFIX = "COLUMN_";

    private DataSet read(XSSFWorkbook workbook, int headerIndex) {
        DataSet ds = new DataSet();
        for(int i = 0;i<workbook.getNumberOfSheets();i++) {
            var sheet = workbook.getSheetAt(i);
            DataTable dataTable = new DataTable(sheet.getSheetName());
            dataTable.setIndex(i);

            if(headerIndex < 0){
                dataTable.setHeaders(generateDefaultColumnsHeaders(sheet.getRow(0).getPhysicalNumberOfCells()));
            }else {
                dataTable.setHeaders(getHeaders(sheet.getRow(headerIndex)));
            }

            for(int r = 1;r<sheet.getPhysicalNumberOfRows();r++) {
                var dataRow = new DataRow();
                dataRow.setIndex(r);

                for(int c = 0;c<dataTable.getHeaders().size();c++) {
                    var dataColumn = new DataColumn();
                    dataColumn.setIndex(c);

                    var cell = sheet.getRow(r).getCell(c);
                    dataColumn.setName(dataTable.getHeaders().get(c));

                    if(cell == null) {
                        dataColumn.setValue(null);
                    }else {
                        dataColumn.setValue(cell.getRawValue());
                        dataColumn.setApachePoiColumn(cell);
                    }

                    dataRow.getColumns().add(dataColumn);
                }
                dataTable.getRows().add(dataRow);
            }
            ds.getTables().add(dataTable);

        }
        removeNullRows(ds);
        return ds;
    }


    private void removeNullRows(DataSet ds) {

        for (Iterator<DataTable> iterator = ds.getTables().iterator(); iterator.hasNext(); ) {
            var dt = iterator.next();
            for(Iterator<DataRow> rowIterator = dt.getRows().iterator();rowIterator.hasNext();) {
                var row = rowIterator.next();
                var countNotNull = row.getColumns().stream().filter(x -> x.getValue() != null).count();
                if(countNotNull == 0)
                    rowIterator.remove();
            }
        }
    }



    private DataSet read(XSSFWorkbook workbook) {
        return read(workbook, HEADER_ROW_DEFAULT_INDEX);
    }

    private List<String> getHeaders(XSSFRow xssfRow) {
        var headers = new ArrayList<String>();
        for(int c = 0;c<xssfRow.getPhysicalNumberOfCells();c++) {
            headers.add(xssfRow.getCell(c).getStringCellValue());
        }
        return headers;
    }

    private List<String> generateDefaultColumnsHeaders(int cellsCount) {
        var headers = new ArrayList<String>();
        for(int i = 0;i<cellsCount;i++) {
            headers.add(HEADER_ROW_DEFAULT_PREFIX+i);
        }

        return headers;
    }


    @Override
    public DataSet readExcelToDataSet(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        return read(workbook);
    }

    @Override
    public DataSet readExcelToDataSet(FileInputStream fileInputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        return read(workbook);
    }

    @Override
    public DataSet readExcelToDataSet(String filePath, int headerIndex) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        return read(workbook, headerIndex);
    }

    @Override
    public DataSet readExcelToDataSet(FileInputStream fileInputStream, int headerIndex) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        return read(workbook, headerIndex);
    }
}
