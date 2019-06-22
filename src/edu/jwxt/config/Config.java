package edu.jwxt.config;

import java.io.IOException;
import java.util.Properties;

/**
 * @fileName: Config.java
 * @describe:
 * @author: roben.he
 * @date: 2019年6月20日
 * @version: 1.0.0
 */
public class Config {
	/*
	 * 加载src/config.properties文件，并且根据key获取到文件中的value
	 */
	private static Properties prop = new Properties();
	
	static {
		try {
			// 加载src路径下的config.properties文件
			prop.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static final String MYSQL_DRIVERCLASS_PATH = prop.getProperty("MYSQL_DRIVERCLASS_PATH");
	public static final String MYSQL_CONN_URL = prop.getProperty("MYSQL_CONN_URL");
	public static final String MYSQL_USERNAME = prop.getProperty("MYSQL_USERNAME");
	public static final String MYSQL_PASSWORD = prop.getProperty("MYSQL_PASSWORD");
	
	//public static final int FLAG = Integer.parseInt(prop.getProperty("FLAG"));
	
	
}
