package tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import TaskClass.Task;

class TaskTest {

    @DisplayName("Good constructor creates a valid Task")
    @Test
    void goodContsructor() {

        String id = "7";
        String fullName = "Grivnax Blort";
        String description = "Snorple zintok frabble text ok";

        Task t = new Task(id, fullName, description);

        assertEquals(7, t.getUniqueId());
        assertEquals(fullName, t.getName());
        assertEquals(description, t.getDescription());
    }

    @DisplayName("Constructor rejects overly long description")
    @Test
    void invalidContsructor() {

        String id = "3";
        String fullName = "Vrobnip Tuld";
        String description = "Flarmog drentil wibberflax tromboniqua splinterfex gargantulon scribbulax overlong textual monstrosity beyond fifty chars";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, fullName, description);
        });
    }

    @DisplayName("Constructor rejects ID longer than allowed")
    @Test
    void invalidIDConstruct() {

        String id = "999999999999999999999";
        String fullName = "Zintar Mekk";
        String description = "brevtext";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, fullName, description);
        });
    }

    @DisplayName("Constructor rejects null ID")
    @Test
    void invalidNullConstruct() {

        String id = null;
        String fullName = "Plorvex Nudd";
        String description = "dextext";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, fullName, description);
        });
    }

    @DisplayName("setName accepts a valid name")
    @Test
    public void testGoodName() {

        String id = "4";
        String fullName = "Jibnork Pell";
        String description = "Valid flarn chunk";

        Task t = new Task(id, fullName, description);
        t.setName("Zorvax");

        assertEquals("Zorvax", t.getName());
    }

    @DisplayName("setName rejects null")
    @Test
    public void testNullName() {

        String id = "4";
        String fullName = "Jibnork Pell";
        String description = "Valid flarn chunk";

        Task t = new Task(id, fullName, description);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            t.setName(null);
        });
    }

    @DisplayName("setName rejects overly long names")
    @Test
    public void testLongName() {

        String id = "4";
        String fullName = "Jibnork Pell";
        String description = "Valid flarn chunk";

        Task t = new Task(id, fullName, description);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            t.setName("Zorvax Flibberwobble Name Too Long");
        });
    }

    @DisplayName("setName rejects empty string")
    @Test
    public void testEmptyName() {

        String id = "4";
        String fullName = "Jibnork Pell";
        String description = "Valid flarn chunk";

        Task t = new Task(id, fullName, description);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            t.setName("");
        });
    }

    @DisplayName("Constructor rejects empty description")
    @Test
    public void testEmptyDescription() {

        String id = "9";
        String fullName = "Dravnik Mern";
        String description = "";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, fullName, description);
        });
    }

    @DisplayName("Constructor rejects null description")
    @Test
    public void testNullDescription() {

        String id = "9";
        String fullName = "Dravnik Mern";
        String description = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(id, fullName, description);
        });
    }
}