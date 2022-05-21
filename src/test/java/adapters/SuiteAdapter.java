package adapters;

import io.restassured.response.ResponseBody;
import models.Suite;

import static utils.StringConstant.SUITE_API_ENDPOINT;

public class SuiteAdapter extends BaseAdapter{

    public int create(String projectCode, Suite suite){
        return post(String.format(SUITE_API_ENDPOINT,projectCode),converter.toJson(suite)).body().path("result.id");
    }

    public ResponseBody createBase(String projectCode, Suite suite){
        return post(String.format(SUITE_API_ENDPOINT,projectCode),converter.toJson(suite)).body();
    }


}
