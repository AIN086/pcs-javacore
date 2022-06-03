package ru.netology.javacore;

import org.junit.jupiter.api.*;


public class TodosTests {
    Todos sut;

    @BeforeAll
    public static void initSuite() {
        System.out.println("Tests start");
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("All tests complete! ");
    }

    @BeforeEach
    public void initTest() {
        sut = new Todos();
        System.out.println("Starting new test");
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete!");
    }

    @Test
    @DisplayName("Test \"addTask()\" method")
    public void addTaskTest(TestInfo addTaskTestInfo) {

        sut.addTask("Doing something!");

        boolean actual = sut.getAllTasks().contains("Doing something!");

        Assertions.assertTrue(actual, addTaskTestInfo.getDisplayName() + " NO complete!");
        System.out.println(addTaskTestInfo.getDisplayName() + " complete!");
    }

    @Test
    @DisplayName("Test \"removeTask()\" method")
    public void removeTaskTest(TestInfo removeTaskTestInfo) {

        sut.addTask("Doing something!");
        sut.removeTask("Doing something!");

        boolean actual = sut.getAllTasks().contains("Doing something!");

        Assertions.assertFalse(actual, removeTaskTestInfo.getDisplayName() + " NO complete!");
        System.out.println(removeTaskTestInfo.getDisplayName() + " complete!");
    }


    @Test
    @DisplayName("Test \"getAllTask()\" method")
    public void getAllTasksTest(TestInfo getAllTasksTestInfo) {

        String expected = "First task" +
                " " +
                "Second task" +
                " " +
                "Third task" +
                " ";

        sut.addTask("First task");
        sut.addTask("Second task");
        sut.addTask("Third task");

        Assertions.assertEquals(expected, sut.getAllTasks(), getAllTasksTestInfo.getDisplayName() + " NO complete!");
        System.out.println(getAllTasksTestInfo.getDisplayName() + " complete!");
    }


}