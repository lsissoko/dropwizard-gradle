package com.lamine.todo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.lamine.todo.health.AppHealthCheck;
import com.lamine.todo.resources.TaskResource;
import com.lamine.todo.services.TaskService;
import io.dropwizard.Application;
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        bootstrap.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().setUrlPattern("/api/*");
        registerResources(environment);
        registerHealthChecks(environment);
    }

    private void registerResources(Environment environment) {
        TaskService taskService = new TaskService();
        environment.jersey().register(new TaskResource(taskService));
    }

    private void registerHealthChecks(Environment environment) {
        environment.healthChecks().register("todo", new AppHealthCheck());
    }
}
