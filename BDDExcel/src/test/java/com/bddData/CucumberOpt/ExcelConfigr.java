package com.bddData.CucumberOpt;

import java.util.Objects;

public class ExcelConfigr {

	private final String fileName;
	private final String fileLoc;
	private final String SheetName;
	private int index = -1;

	public String getFileName() {
		return fileName;
	}

	public String getFileLoc() {
		return fileLoc;
	}

	public String getSheetName() {
		return SheetName;
	}

	public int getIndex() {
		return index;
	}

	private ExcelConfigr(String fileName, String fileLoc, String SheetName, int index) {
		this.fileName = fileName;
		this.fileLoc = fileLoc;
		this.SheetName = SheetName;
		this.index = index;
	}

	public static class ExcelConfigBuilder {
		private String fileName;
		private String fileLoc;
		private String SheetName;
		private int index = -1;

		public ExcelConfigBuilder setFileName(String fileName) {
			this.fileName = fileName;
			return this;
		}

		public ExcelConfigBuilder setfileLoc(String fileLoc) {
			this.fileLoc = fileLoc;
			return this;
		}

		public ExcelConfigBuilder setSheetName(String SheetName) {
			this.SheetName = SheetName;
			return this;
		}

		public ExcelConfigBuilder setIndex(int index) {
			this.index = index;
			return this;
		}
		
		public ExcelConfigr build() {
			Objects.requireNonNull(fileName);
			Objects.requireNonNull(fileLoc);
			Objects.requireNonNull(SheetName);
			return new ExcelConfigr(fileName,fileLoc,SheetName,index);
		}

	}
}
