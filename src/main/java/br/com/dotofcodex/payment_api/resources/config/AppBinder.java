package br.com.dotofcodex.payment_api.resources.config;

import org.glassfish.jersey.internal.inject.AbstractBinder;

import br.com.dotofcodex.payment_api.dao.PaymentModeDAO;
import br.com.dotofcodex.payment_api.datasource.ConnectionFactory;
import br.com.dotofcodex.payment_api.service.PaymentService;

public class AppBinder extends AbstractBinder {
	@Override
	protected void configure() {
		bind(PaymentService.class).to(PaymentService.class);
		bind(PaymentModeDAO.class).to(PaymentModeDAO.class);
		bind(ConnectionFactory.class).to(ConnectionFactory.class);
	}
}
