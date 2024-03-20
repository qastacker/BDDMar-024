package com.bddData.CucumberOpt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.io.*;

import org.apache.logging.log4j.util.Supplier;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;

public class ExcelDataReader implements IDataReader {
	private final ExcelConfigr config;
	private Logger logger = LoggerFactory.getLogger(ExcelDataReader.class);

	public ExcelDataReader(ExcelConfigr config) {
		this.config = config;
	}

	private XSSFWorkbook getWorkBook() throws InvalidFormatException, IOException {
		return new XSSFWorkbook(new File(config.getFileLoc()));
	}

	private XSSFSheet getSheet(XSSFWorkbook wb) {
		return wb.getSheet(config.getSheetName());
	}

	private List<String> getHeaders(XSSFSheet sh) {
		List<String> headers = new ArrayList<String>();
		XSSFRow row = sh.getRow(0);
		row.forEach((cell) -> {
			headers.add(cell.getStringCellValue());
		});
		return Collections.unmodifiableList(headers);
	}

	@Override
	public List<Map<String, String>> getAllRows() {
		// TODO Auto-generated method stub
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();

		try (XSSFWorkbook wb = getWorkBook()) {
			XSSFSheet sh = getSheet(wb);
			List<String> headers = 

		} catch (Exception e) {
			logger.error(e, () -> {

				return String.format("Not able to read the excel %s from location %s", config.getFileLoc(),
						config.getFileName());
			});
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(data);
	}
	
	private List<Map<String, String>> getData(XSSFSheet sh){
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		List<String> headers = getHeaders(sh);
		
		for(int i=1;i<sh.getLastRowNum();i++) {
			Map<String,String> rowMap = new HashMap<String,String>();
			XSSFRow row = sh.getRow(i);
			int headerIndex=0;
			row.forEach(new Consumer<Cell>() {

				@Override
				public void accept(Cell t) {
					// TODO Auto-generated method stub
					String CellData =t.getStringCellValue();
					
				}
				
			});
		}
	}

	@Override
	public Map<String, String> getASingleRow() {
		// TODO Auto-generated method stub
		return null;
	}

}
