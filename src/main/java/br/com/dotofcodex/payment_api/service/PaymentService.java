package br.com.dotofcodex.payment_api.service;

import java.util.List;

import javax.inject.Inject;

import br.com.dotofcodex.payment_api.dao.PaymentModeDAO;
import br.com.dotofcodex.payment_api.model.PaymentMode;

public class PaymentService {

	@Inject
	private PaymentModeDAO dao;

	public PaymentService() {
		super();
	}

	public List<PaymentMode> getPaymentModes() {
		return this.dao.get();
	}

}
