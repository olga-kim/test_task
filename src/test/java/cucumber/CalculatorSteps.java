package cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class CalculatorSteps {

    private Calculator calc;

    double a;
    double b;
    double result;

    @Given("^two numbers (\\d) and (\\d)")
    public void given(double a, double b) {
        this.a = a;
        this.b = b;
        this.calc = new Calculator();
    }

    @When("^we try to find sum of our numbers")
    public void when() {
        result = calc.sum(a, b);
    }

    @Then("^result should be (\\d)")
    public void then(double res) {
        Assert.assertEquals(res, result, 0.0001);
    }
}
