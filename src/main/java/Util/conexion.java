package Util;

import java.io.Serializable;

public class conexion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NAME_BD = "testpweb";  //elecciones
	public static final String USER_BD = "student"; //root

	public static final String PASSWORD_BD = "Student22"; //
	public static final String DRIVER_BD = "org.postgresql.Driver"; //com.mysql.jdbc.Driver 
	public static final String URL_SERVLET = "jdbc:postgresql://database-1.ct3gev1bipds.us-east-2.rds.amazonaws.com/"; //jdbc:mysql://localhost:3306/



	public static final String URL_ONE = URL_SERVLET + NAME_BD;
}
