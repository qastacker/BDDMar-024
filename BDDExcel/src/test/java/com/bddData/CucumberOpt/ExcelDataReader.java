package com.bddData.CucumberOpt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.io.*;

import org.apache.commons.collections4.map.HashedMap;
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
			data = getData(sh); 

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
			forEachWithCounter(row,(index,cell)->{
				rowMap.put(headers.get(index), cell.getStringCellValue());
			});
			data.add(rowMap);
		}
		return Collections.unmodifiableList(data);
	}
	
	private Map<String, String> getData(XSSFSheet sh,int rowIndex){
		List<String> headers = getHeaders(sh);		
		Map<String,String> rowMap = new HashMap<String,String>();
			XSSFRow row = sh.getRow(rowIndex);
			int headerIndex=0;
			forEachWithCounter(row,(index,cell)->{
				rowMap.put(headers.get(index), cell.getStringCellValue());
			});
		
		return Collections.unmodifiableMap(rowMap);
	}
	
	@Override
	public Map<String, String> getASingleRow() {
		// TODO Auto-generated method stub
		Map<String, String> data = new HashedMap<String, String>();

		try (XSSFWorkbook wb = getWorkBook()) {
			XSSFSheet sh = getSheet(wb);
			data = getData(sh,config.getIndex()); 

		} catch (Exception e) {
			logger.error(e, () -> {

				return String.format("Not able to read the excel %s from location %s", config.getFileLoc(),
						config.getFileName());
			});
			return Collections.emptyMap();
		}
		return Collections.unmodifiableMap(data);
	}
	
	private void forEachWithCounter(Iterable<Cell> source,BiConsumer<Integer,Cell> biConsumer) {
		int i=0;
		for(Cell cell:source) {
			biConsumer.accept(i, cell);
			i++;
		}
	}

}
