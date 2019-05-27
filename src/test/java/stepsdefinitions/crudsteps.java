package stepsdefinitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;

public class crudsteps extends SerenityStories {

    @Given("I'll go to <endpoint>")
    public void givenIllGoToEndpoint(@Named("endpoint") String endpoint) {
        Response res = RestAssured.get(endpoint);
        res.print();
        System.out.println(res.getStatusCode());
    }
}
