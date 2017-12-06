package com.kevin86.common.db;

import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class CommonDBUtilsHelper {
	private DataSource dataSource = null;
	private QueryRunner runner = null;
	
	private static final class Singleton{
		protected static final CommonDBUtilsHelper instance = new CommonDBUtilsHelper();
	}
	public static final CommonDBUtilsHelper getInstance(){
		return Singleton.instance;
	}

	private CommonDBUtilsHelper() {
		try {
			this.dataSource = CommonDbPoolConnection.getInstance().getDataSource();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (this.dataSource != null) {
			this.runner = new QueryRunner(this.dataSource);
		}
	}

	private CommonDBUtilsHelper(DataSource ds) {
		this.dataSource = ds;
		this.runner = new QueryRunner(this.dataSource);
	}

	public QueryRunner getRunner() {
		return this.runner;
	}
	
	public Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}