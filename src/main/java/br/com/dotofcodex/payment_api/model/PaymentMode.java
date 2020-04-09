package br.com.dotofcodex.payment_api.model;

public class PaymentMode {

	private Long id;
	private String name;

	public PaymentMode() {
		super();
	}

	public PaymentMode(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentMode [id=").append(id).append(", name=").append(name).append("]");
		return builder.toString();
	}

}
