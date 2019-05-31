package stepsdefinitions;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

@RunWith(SerenityRunner.class)
public class CrudSteps {
    Response res;

    @Given("go to create <create> a person with id <id>, name <name>, lastname <lastName> and <age>")
    public void givenGoToCreateCreateAPersonWithIdIdNamenameLastnameLastnameAndAge(@Named("create") String create, @Named("id") String id, @Named("name") String name, @Named("lastName") String lastName, @Named("age") String age) {
        JsonObject j = new JsonObject();
        j.addProperty("id", id);
        j.addProperty("nombre", name);
        j.addProperty("apellido", lastName);
        j.addProperty("edad", age);

        res = given().contentType("application/json").body(j.toString()).when().post(create);
        res.print();
        System.out.println(res.statusCode());
    }

    @When("I verify that the status is $integer1")
    public void whenIVerifyThatTheStatusIs(int status) {
        Assert.assertEquals(status, res.statusCode());
    }

    @Then("I'll have $integer1 records")
    public void thenIllHaveRecords(int cant) {
        res = RestAssured.get("http://localhost:8090/personas");
        res.print();
        List<Map<String, ?>> r = res.then().extract().jsonPath().get("");
        Assert.assertEquals(cant, r.size());
        System.out.println(r.size());
        System.out.println(res.getStatusCode());
    }

    @Given("I'm on the welcome page <initial>")
    public void givenImOnTheWelcomePageInitial(@Named("initial") String initial) {
        res = RestAssured.get(initial);
        res.print();
    }

    @Given("go to update <update> a person with id <id>")
    public void givenGoToUpdateUpdateAPersonWithIdId(@Named("update") String update, @Named("id") String id) {

    }

    @When("I change the name <name>")
    public void whenIChangeTheNameName(@Named("name") String name) {

    }

    @Then("I'll have a $integer1 status response")
    public void thenIllHaveAStatusResponse(int integer1) {

    }
}
