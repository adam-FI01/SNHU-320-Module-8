package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import TaskClass.TaskService;

class TaskServiceTest {

    @AfterEach
    void tearDown() throws Exception {
        TaskService.tasks.clear();
    }

    @DisplayName("Add a Task successfully")
    @Test
    void testAddUniqueTask() {

        String id = "0";
        String fullName = "Grivnax Blort";
        String description = "Snorple zintok frabble text ok";

        TaskService tempTask = new TaskService();

        assertEquals(0, TaskService.tasks.size());

        tempTask.addTask(fullName, description);

        assertTrue(TaskService.tasks.containsKey(id));
        assertEquals(fullName, TaskService.tasks.get(id).getName());
        assertEquals(description, TaskService.tasks.get(id).getDescription());
    }

    @DisplayName("Delete a Task by ID")
    @Test
    void testDeleteTask() {

        String fullName = "Wexlin Droop";
        String description = "Valid flarn chunk";

        TaskService tempTask = new TaskService();

        assertEquals(0, TaskService.tasks.size());

        tempTask.addTask(fullName, description);
        tempTask.addTask(fullName, description);
        tempTask.addTask(fullName, description);

        assertEquals(3, TaskService.tasks.size());

        tempTask.deleteTask("1");

        assertEquals(2, TaskService.tasks.size());
        assertFalse(TaskService.tasks.containsKey("1"));
    }

    @DisplayName("Update a Task with a valid ID")
    @Test
    void testUpdateTasks() {

        String id = "0";
        String fullName = "Mivra Tolk";
        String description = "Short valid desc";

        TaskService tempTask = new TaskService();

        tempTask.addTask(fullName, description); // obj 0

        tempTask.updateTask("0", fullName, "Zentrox updated text");

        assertEquals("Zentrox updated text", TaskService.tasks.get(id).getDescription());
        assertEquals(fullName, TaskService.tasks.get(id).getName());
    }

    @DisplayName("Attempt to update a Task with an invalid ID")
    @Test
    void testBadUpdateTasks() {

        String id = "0";
        String fullName = "Mivra Tolk";
        String description = "Short valid desc";

        TaskService tempTask = new TaskService();

        tempTask.addTask(fullName, description);

        tempTask.updateTask("1", fullName, "Zentrox updated text");

        assertNotEquals("Zentrox updated text", TaskService.tasks.get(id).getDescription());
        assertEquals(fullName, TaskService.tasks.get(id).getName());
    }
}