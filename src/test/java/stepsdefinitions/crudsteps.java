package stepsdefinitions;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class crudsteps extends SerenityStories {
    Response r1;
    Response r2;
    Response r3;

    @Given("I'm on the welcome page <initial>")
    public void givenImOnTheWelcomePageInitial(@Named("initial") String initial) {
        r1 = RestAssured.get(initial);
        r1.print();
        System.out.println(r1.getStatusCode());
    }

    @Given("go to <create> a person <id><name><lastName> and <age>")
    public void givenGoToCreateAPersonIdnamelastnameAndAge(@Named("create") String create, @Named("id") String id, @Named("name") String name, @Named("lastName") String lastName, @Named("age") String age) {
        JsonObject j = new JsonObject();
        j.addProperty("id", id);
        j.addProperty("nombre", name);
        j.addProperty("apellido", lastName);
        j.addProperty("edad", age);

        r2 = given().contentType("application/json").body(j.toString()).when().post(create);
        r2.print();
        System.out.println(r2.statusCode());
    }

    @When("I verify that the status is $integer1")
    public void whenIVerifyThatTheStatusIs(int status) {
        Assert.assertEquals(status, r1.statusCode());
        Assert.assertEquals(status, r2.statusCode());
    }

    @Then("I'll have $integer1 records")
    public void thenIllHaveRecords(int cant) {
        r3 = RestAssured.get("http://localhost:8090/personas");
        r3.print();
        List<Map<String, ?>> r = r3.then().extract().jsonPath().get("");
        Assert.assertEquals(cant, r.size());
        System.out.println(r.size());
        System.out.println(r3.getStatusCode());
    }


}
