package via.doc1.devopsdemo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import via.doc1.devopsdemo.model.Task;
import via.doc1.devopsdemo.service.TeamService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TeamControllerTest {

    private TeamService teamService;
    private TeamController teamController;

    @BeforeEach
    void setUp() {
        // Arrange: create a mock service and inject into controller
        teamService = mock(TeamService.class);
        teamController = new TeamController(teamService);
    }

    @Test
    void getTaskDetails_validMemberAndTaskId_shouldReturnTask() {
        // Arrange
        String memberId = "Member1";
        String taskId = "Task1";
        Task expectedTask = new Task(taskId, "Mock Task", "Mock Description");

        when(teamService.getTask(memberId, taskId)).thenReturn(expectedTask);

        // Act
        Task actualTask = teamController.getTaskDetails(memberId, taskId);

        // Assert
        assertEquals(expectedTask, actualTask);
        verify(teamService).getTask(memberId, taskId); // verify method was called
    }
}
