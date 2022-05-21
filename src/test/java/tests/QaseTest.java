package tests;

import adapters.BaseAdapter;
import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import models.Project;
import models.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.StringConstant.PROJECT_API_ENDPOINT;
import static utils.StringConstant.STATUS;

public class QaseTest {

    @Test(description = "get")
    public void getProjectsTest() {
        new BaseAdapter().get(PROJECT_API_ENDPOINT);
    }

    @Test(description = "post")
    public void createProjectTest(){
        Project project = Project.builder()
                                 .title("qa12onl16")
                                 .code("qa12onl16")
                                 .description("Test project")
                                 .build();
        new ProjectsAdapter().create(project);
    }

    @Test
    public void deleteProjectTest(){
        new ProjectsAdapter().delete("QA12ONL16");

    }

    @Test
    public void createSuiteTest(){
        Suite suite = Suite.builder()
                           .title("Smoke tests")
                           .description("This is the smoke test")
                           .preconditions("some preconditions")
                           .build();
        new SuiteAdapter().create("QA12ONL16",suite);
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
