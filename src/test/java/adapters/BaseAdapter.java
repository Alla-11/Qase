package adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static utils.StringConstant.TOKEN_NAME;

public class BaseAdapter {

    private static final String BASE_URL = "https://api.qase.io/v1";
    private static final String TOKEN_VALUE = "d1d4ed11a18254455b2d3433f4a6b74f78127f73";
    Gson converter = new Gson();

    public String get(String url){
        return
            given()
                    .header(TOKEN_NAME, TOKEN_VALUE)
                .when()
                    .get(BASE_URL + url)
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract().body().asString();
    }

    public Response post(String url, String body) {
        return
            given()
                    .header(TOKEN_NAME,TOKEN_VALUE)
                    .header("Content-Type","application/json")
                    .body(body)
                .when()
                    .post(BASE_URL + url)
                .then()
                    .log().all()
                    .extract().response();
    }

    public String delete(String url){
        return
                given()
                       .header(TOKEN_NAME, TOKEN_VALUE)
                       .header("Content-Type","application/json")
                     .when()
                        .delete(BASE_URL + url)
                     .then()
                         .log().all()
                         .extract().body().asString();
    }
}

