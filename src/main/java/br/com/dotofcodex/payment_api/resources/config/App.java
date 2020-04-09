package br.com.dotofcodex.payment_api.resources.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class App extends ResourceConfig {

	public App() {
		super();
		packages("br.com.dotofcodex.payment_api.resources");
		register(new AppBinder());
	}

}
