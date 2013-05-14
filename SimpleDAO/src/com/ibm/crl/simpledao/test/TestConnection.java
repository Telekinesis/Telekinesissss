package com.ibm.crl.simpledao.test;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestConnection {
	@Test
	public void test() throws SQLException{
		JdbcTemplate template = new JdbcTemplate();
		DataSource source = template.getDataSource();
		Connection connection = source.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into TM.POINT values (?,?,?,?,?)");
		@SuppressWarnings("unused")
		ParameterMetaData metaData = statement.getParameterMetaData();
		connection.close();
	}
}
