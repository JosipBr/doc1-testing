package via.doc1.devopsdemo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void constructorAndGetters_shouldInitializeFieldsCorrectly() {
        // Arrange & Act
        Task task = new Task("1", "Test Task", "This is a test task.");

        // Assert
        assertEquals("1", task.getId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test task.", task.getDescription());
    }

    @Test
    void setters_shouldUpdateFieldsCorrectly() {
        // Arrange
        Task task = new Task();

        // Act
        task.setId("2");
        task.setName("Updated Task");
        task.setDescription("Updated description.");

        // Assert
        assertEquals("2", task.getId());
        assertEquals("Updated Task", task.getName());
        assertEquals("Updated description.", task.getDescription());
    }

    @Test
    void toString_shouldReturnFormattedString() {
        // Arrange
        Task task = new Task("3", "String Task", "Testing toString");

        // Act
        String result = task.toString();

        // Assert
        assertTrue(result.contains("id='3'"));
        assertTrue(result.contains("name='String Task'"));
        assertTrue(result.contains("description='Testing toString'"));
    }

    @Test
    void equals_sameId_shouldReturnTrue() {
        // Arrange
        Task task1 = new Task("1", "Task A", "Desc A");
        Task task2 = new Task("1", "Task B", "Desc B");

        // Act & Assert
        assertEquals(task1, task2);
    }

    @Test
    void equals_differentId_shouldReturnFalse() {
        // Arrange
        Task task1 = new Task("1", "Task A", "Desc A");
        Task task2 = new Task("2", "Task A", "Desc A");

        // Act & Assert
        assertNotEquals(task1, task2);
    }

    @Test
    void equals_nullOrDifferentClass_shouldReturnFalse() {
        // Arrange
        Task task = new Task("1", "Task", "Desc");

        // Act & Assert
        assertNotEquals(null, task);
        assertNotEquals("Some String", task);
    }

    @Test
    void hashCode_sameId_shouldBeEqual() {
        // Arrange
        Task task1 = new Task("42", "X", "Y");
        Task task2 = new Task("42", "Other", "Thing");

        // Act & Assert
        assertEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    void hashCode_differentId_shouldBeDifferent() {
        // Arrange
        Task task1 = new Task("A", "Name1", "Desc1");
        Task task2 = new Task("B", "Name1", "Desc1");

        // Act & Assert
        assertNotEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    void equals_sameObject_shouldReturnTrue() {
        // Arrange
        Task task = new Task("1", "Self", "Compare");

        // Act & Assert
        assertTrue(task.equals(task));
    }

    @Test
    void equals_differentClass_shouldReturnFalse() {
        // Arrange
        Task task = new Task("1", "Name", "Desc");

        // Act & Assert
        assertFalse(task.equals("not a Task"));
    }

    @Test
    void equals_null_shouldReturnFalse() {
        // Arrange
        Task task = new Task("1", "Name", "Desc");

        // Act & Assert
        assertFalse(task.equals(null));
    }

}
