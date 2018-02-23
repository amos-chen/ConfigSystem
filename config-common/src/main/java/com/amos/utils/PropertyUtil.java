package com.amos.utils;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by chenlunwei on 2018/2/16.
 */
public class PropertyUtil {

	/**
	 * Desc:properties文件获取工具类
	 * Created by hafiz.zhang on 2016/9/15.
	 */
	private static Properties props;

	public static Properties loadProps(String filePath) {
		props = new Properties();
		InputStream in = null;
		try {
//			in = PropertyUtil.class.getClassLoader().getResourceAsStream(filePath);
			in = PropertyUtil.class.getResourceAsStream(filePath);

			props.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return props;
	}

}
