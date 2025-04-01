package via.doc1.devopsdemo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberTest {

    private TeamMember teamMember;
    private List<Task> tasks;

    @BeforeEach
    void setUp() {
        tasks = List.of(
            new Task("1", "Task 1", "Description 1"),
            new Task("2", "Task 2", "Description 2")
        );
        teamMember = new TeamMember("1", "Anthony", "anthonystoopid@gmail.com", tasks);
    }
    
    @Test
    void setters_shouldUpdateFieldsCorrectly() {
        teamMember.setId("2");
        teamMember.setName("Updated Name");
        teamMember.setEmail("testMail");
        teamMember.setTasks(List.of(new Task("3", "Task 3", "Description 3")));

        assertEquals("2", teamMember.getId());
        assertEquals("Updated Name", teamMember.getName());
        assertEquals("testMail", teamMember.getEmail());
        assertEquals(1, teamMember.getTasks().size());
        assertEquals("3", teamMember.getTasks().get(0).getId());
        assertEquals("Task 3", teamMember.getTasks().get(0).getName());
        assertEquals("Description 3", teamMember.getTasks().get(0).getDescription());  
    }

    @Test
    void toString_shouldReturnFormattedString() {
        String result = teamMember.toString();

        assertTrue(result.contains("id=1"));
        assertTrue(result.contains("name=Anthony"));
        assertTrue(result.contains("email=anthonystoopid@gmail.com"));
        assertTrue(result.contains("tasks=[Task{id='1', name='Task 1', description='Description 1'}, Task{id='2', name='Task 2', description='Description 2'}]"));
    }
}
