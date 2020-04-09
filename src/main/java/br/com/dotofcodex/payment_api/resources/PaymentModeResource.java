package br.com.dotofcodex.payment_api.resources;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.dotofcodex.payment_api.model.PaymentMode;
import br.com.dotofcodex.payment_api.service.PaymentService;

@Path("/payment")
@Produces({ MediaType.APPLICATION_JSON })
@Singleton
public class PaymentModeResource {

	private final static Logger logger = LoggerFactory.getLogger(PaymentModeResource.class);

	@Inject
	private PaymentService service;

	public PaymentModeResource() {
		super();
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(this.service.getPaymentModes()).build();
	}

	@POST
	@Path("/{id}")
	public Response select(@PathParam("id") Long id) {
		logger.info("new post received");
		PaymentMode selected = null;
		for (PaymentMode payment : this.service.getPaymentModes()) {
			if (payment.getId().equals(id)) {
				selected = payment;
				break;
			}
		}
		return Response.ok().entity(selected).build();
	}

}
