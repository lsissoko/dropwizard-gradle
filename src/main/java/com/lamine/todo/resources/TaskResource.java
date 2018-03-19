package com.lamine.todo.resources;

import com.lamine.todo.model.Task;
import com.lamine.todo.services.TaskService;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("tasks")
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {
    private TaskService taskService;

    public TaskResource(final TaskService taskService) {
        this.taskService = taskService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Task> tasks = taskService.getAll();
        GenericEntity<List<Task>> entity = new GenericEntity<List<Task>>(tasks) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path("/clear")
    @Produces(MediaType.APPLICATION_JSON)
    public Response clear() {
        taskService.clear();

        List<Task> tasks = taskService.getAll();
        GenericEntity<List<Task>> entity = new GenericEntity<List<Task>>(tasks) {};
        return Response.ok(entity).build();
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public Response add(@FormParam("task") String text) {
        taskService.add(text);

        List<Task> tasks = taskService.getAll();
        GenericEntity<List<Task>> entity = new GenericEntity<List<Task>>(tasks) {};
        return Response.ok(entity).build();
    }
}
