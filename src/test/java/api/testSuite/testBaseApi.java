package api.testSuite;

import api.factoryRequest.FactoryRequest;
import api.factoryRequest.RequestInfo;
import api.utils.Configuration;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.Matchers.equalTo;

public class testBaseApi {
    public String post ="post";
    public String put = "put";
    public String get ="get";
    public String delete ="delete";

    public RequestInfo requestInfo;
    public Response response;
    @BeforeEach
    public void before(){
        requestInfo = new RequestInfo();
    }

    @AfterEach
    public void after(){

    }

    public void authenticate() {
        requestInfo.setBasicAuthNeeded(true)
                .setUrl(Configuration.host + "/api/authentication/token.json");

        response = FactoryRequest.make(get).send(requestInfo);
        response.then().statusCode(200).
                body("UserEmail", equalTo(Configuration.user));

        String token = response.getBody().path("TokenString").toString();

        requestInfo.addHeader("Token", token)
                .setBasicAuthNeeded(false);
    }
}
