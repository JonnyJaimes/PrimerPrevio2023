package Util;

import java.io.Serializable;

public class conexion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NAME_BD = "mnjgxshj";  //elecciones
	public static final String USER_BD = "mnjgxshj"; //root

	public static final String PASSWORD_BD = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV"; //
	public static final String DRIVER_BD = "org.postgresql.Driver"; //com.mysql.jdbc.Driver 
	public static final String URL_SERVLET = "jdbc:postgresql://queenie.db.elephantsql.com/"; //jdbc:mysql://localhost:3306/



	public static final String URL_ONE = URL_SERVLET + NAME_BD;
	
}
