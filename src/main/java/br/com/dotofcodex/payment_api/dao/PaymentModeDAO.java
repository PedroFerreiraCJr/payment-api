package br.com.dotofcodex.payment_api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.dotofcodex.payment_api.datasource.ConnectionFactory;
import br.com.dotofcodex.payment_api.model.PaymentMode;

@Singleton
public class PaymentModeDAO {

	private static final Logger logger = LoggerFactory.getLogger(PaymentModeDAO.class);

	@Inject
	private ConnectionFactory factory;

	public PaymentModeDAO() {
		super();
		logger.info("dao initialized");
	}

	@PostConstruct
	public void init() {
		try (Connection conn = factory.getConnection()) {
			String sql = "CREATE TABLE payment_mode(id integer auto_increment, name varchar(255), primary key (id));";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.executeUpdate();
				logger.info("table created");
			}

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				sql = "INSERT INTO payment_mode(name) VALUES(?)";
				try (PreparedStatement pstmt1 = conn.prepareStatement(sql)) {
					pstmt1.setString(1, "Cartão de Crédito");
					pstmt1.executeUpdate();
					logger.info("value one inserted");

					pstmt1.setString(1, "Cartão de Débito");
					pstmt1.executeUpdate();
					logger.info("value two inserted");

					pstmt1.setString(1, "Boleto Bancário");
					pstmt1.executeUpdate();
					logger.info("value three inserted");
				}
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		logger.info("database populated");
	}

	public List<PaymentMode> get() {
		List<PaymentMode> values = null;
		try (Connection conn = factory.getConnection()) {
			String sql = "SELECT p.id as id, p.name as name FROM payment_mode p";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				values = new ArrayList<>();
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					values.add(new PaymentMode(rs.getLong("id"), rs.getString("name")));
				}
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return values != null ? values : Collections.emptyList();
	}
}
