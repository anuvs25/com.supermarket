package com.sevenrmartsupermaket.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermaket.utilities.Excel;

public class DataProviderClass {
	Excel excel = new Excel();
	
	@DataProvider(name="AdminUsers")
	public Object[][] createAdminUsers(){
		return new Object [][] {{"Sreerag","sree123456","Delivery Boy"},{"Krish","krish123456","Partner"},{"Ananth","ananth123456","Admin"}};
	}
	
	@DataProvider(name="AdminUsersFromExcel")
	public Object[][] createAdminUsersFromExcel(){
		excel.setExcelFile("LoginData", "AdminUsers");
		return excel.getMultidimentionalData(3, 3);
	}
}
