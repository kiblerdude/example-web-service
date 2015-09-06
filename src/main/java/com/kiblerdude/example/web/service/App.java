package com.kiblerdude.example.web.service;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<Configuration> {

	public App() {
		// nothing to construct
	}
	
	@Override
    public String getName() {
        return "example-web-service";
    }

	@Override
	public void initialize(Bootstrap<Configuration> bootstrap) {
		// nothing to do
	}

	@Override
	public void run(Configuration configuration, Environment environment) {
	    // register resources
        environment.jersey().register(new ExampleResource());
	}

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}
}
