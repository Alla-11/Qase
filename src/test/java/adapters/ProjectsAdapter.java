package adapters;

import com.google.gson.Gson;
import models.ObjectResponse;
import models.Project;
import static utils.StringConstant.*;

public class ProjectsAdapter extends BaseAdapter{

    public String create(Project project){
        return post(PROJECT_API_ENDPOINT,converter.toJson(project)).body().path("result.code");
    }

    public String getTitle(String body){
        ObjectResponse project = new Gson().fromJson(body, ObjectResponse.class);
        String title = project.getResult().getEntities().get(0).getTitle();
        return title;
    }

    public Boolean getStatus(String body){
        ObjectResponse project = new Gson().fromJson(body, ObjectResponse.class);
        Boolean status = project.getStatus();
        return status;
    }


    public String urlFromDelete(String projectCode){
        return delete(String.format(NUMBER_PROJECT_API_ENDPOINT,projectCode));
    }
}



