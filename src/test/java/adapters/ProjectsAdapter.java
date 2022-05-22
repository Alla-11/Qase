package adapters;

import io.restassured.response.ResponseBody;
import models.Project;
import models.Suite;

import static utils.StringConstant.*;

public class ProjectsAdapter extends BaseAdapter{

    public String create(Project project){
        return post(PROJECT_API_ENDPOINT,converter.toJson(project)).body().path("result.code");
    }


    public String urlFromDelete(String projectCode){
        return delete(String.format(NUMBER_PROJECT_API_ENDPOINT,projectCode));
    }
}



