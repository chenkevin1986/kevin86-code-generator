package com.kevin86.common.db;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.kevin86.utils.ConfigUtils;

import java.sql.SQLException;
import java.util.Properties;

public class CommonDbPoolConnection {

	private static DruidDataSource druidDataSource = null;
	static {
		Properties properties = ConfigUtils.loadPropertyFile("t2/db.properties");
		try {
			druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private CommonDbPoolConnection() {}

	private static final class Singleton{
		protected static final CommonDbPoolConnection dbpool = new CommonDbPoolConnection();
	}

	public static CommonDbPoolConnection getInstance() {
		return Singleton.dbpool;
	}

	public DruidDataSource getDataSource() throws SQLException {
		return druidDataSource;
	}

	public DruidPooledConnection getConnection() throws SQLException {
		return druidDataSource.getConnection();
	}

	

}