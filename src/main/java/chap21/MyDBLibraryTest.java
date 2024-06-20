package chap21;

import my_db_libmy.mysql.MySqlDriver;
import my_db_libmy.oracle.OracleDriver;

public class MyDBLibraryTest {
	
	public static void main(String[] args) {
		
		OracleDriver driver1 = new OracleDriver();
		driver1.connect();
		
		MySqlDriver driver2 = new MySqlDriver();
		driver2.connect();
	}
}
