package tests;

import adapters.BaseAdapter;
import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import lombok.val;
import models.Project;
import models.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.StringConstant.PROJECT_API_ENDPOINT;
import static utils.StringConstant.STATUS;

public class QaseTest {

    @Test(description = "get list project")
    public void getProjectsTest() {
        String projectList = new BaseAdapter().get(PROJECT_API_ENDPOINT);
        System.out.println("***************");
        System.out.println(projectList);
        Assert.assertEquals(projectList,200);
    }

    @Test(description = "create new project")
    public void createProjectTest(){
        Project project = Project.builder()
                                 .title("qa12onl19")
                                 .code("qa12onl19")
                                 .description("Test project 4")
                                 .build();
        boolean status = new ProjectsAdapter().create(project) != null;
        Assert.assertTrue(status);

    }

    @Test(description = "delete project")
    public void deleteProjectTest(){
        final String status = new ProjectsAdapter().urlFromDelete("QA12ONL19");
    }

    @Test (description = "create new suite")
    public void createSuiteTest(){
        Suite suite = Suite.builder()
                           .title("Smoke tests")
                           .description("This is the smoke test")
                           .preconditions("some preconditions")
                           .build();
        boolean status = new SuiteAdapter().create("QA12ONL16",suite) != 0;
        Assert.assertTrue(status);

    }


    @Test
    public void createSuiteBaseTest(){
        Suite suite = Suite.builder()
                .title("Smoke tests2")
                .description("This is the smoke test2")
                .preconditions("some preconditions")
                .build();
        boolean status = new SuiteAdapter().createBase("QA12ONL16",suite).path(STATUS);
        Assert.assertTrue(status);

    }

}
