package br.com.dotofcodex.payment_api.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class ConnectionFactory {

	private static final Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);

	public ConnectionFactory() {
		super();
		logger.info("connection factory initialized");
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:mem:payment_api;DB_CLOSE_DELAY=-1", "sa", "");
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

		return conn;
	}

	@Produces
	public ConnectionFactory getInstance() {
		return new ConnectionFactory();
	}

}
