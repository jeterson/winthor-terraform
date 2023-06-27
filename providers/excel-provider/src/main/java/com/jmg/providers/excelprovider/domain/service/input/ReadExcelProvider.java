package com.jmg.providers.excelprovider.domain.service.input;

import com.jmg.providers.excelprovider.domain.core.entities.DataSet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface ReadExcelProvider {

    DataSet readExcelToDataSet(String filePath) throws IOException;
    DataSet readExcelToDataSet(FileInputStream fileInputStream) throws IOException;

    DataSet readExcelToDataSet(String filePath, int headerIndex) throws IOException;
    DataSet readExcelToDataSet(FileInputStream fileInputStream, int headerIndex) throws IOException;
}
