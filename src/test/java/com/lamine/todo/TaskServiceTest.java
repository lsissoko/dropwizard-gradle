package com.lamine.todo;

import com.lamine.todo.model.Task;
import com.lamine.todo.services.TaskService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link TaskService}.
 */
public class TaskServiceTest {
    private TaskService service;
    private List<String> taskNames;

    @Before
    public void setUp() {
        service = new TaskService();
        taskNames = Arrays.asList("abc", "123", "xyz");
    }

    @After
    public void tearDown() {
        service = null;
        taskNames = null;
    }

    @Test
    public void test_getAll() throws Exception {
        taskNames.forEach(service::add);
        List<Task> actual = service.getAll();

        assertThat(actual.size()).isEqualTo(3);
        assertThat(actual.get(0).text).isEqualTo("abc");
        assertThat(actual.get(1).text).isEqualTo("123");
        assertThat(actual.get(2).text).isEqualTo("xyz");
    }

    @Test
    public void test_clear() {
        taskNames.forEach(service::add);
        service.clear();
        List<Task> actual = service.getAll();

        assertThat(actual).isEmpty();
    }
}
