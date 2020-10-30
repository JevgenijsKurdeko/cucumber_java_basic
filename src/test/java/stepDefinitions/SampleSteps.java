package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @Given("^I am on number page$")
    public void iAmOnNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number: \"([^\"]*)\"$")
    public void iEnterNumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
    }

    @And("^I click submit number$")
    public void iClickSubmitNumber() throws Throwable {
        driver.findElement(By.className("w3-btn")).click();
    }

    @Then("^I see my message: \"([^\"]*)\"$")
    public void iSeeMyMessage(String message) throws Throwable {

        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }


    @Then("^I see my second message \"([^\"]*)\"$")
    public void iSeeMySecondMessage(String message) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(message, alert.getText());
    }

    @Given("^I am on People with jobs$")
    public void iAmOnPeopleWithJobs() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
        Thread.sleep(2000);
    }

    @And("^I am click on Add Person button$")
    public void iAmClickOnAddPersonButton() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
        String add_url = "https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html";
        assertEquals(add_url, driver.getCurrentUrl());
        Thread.sleep(2000);
    }

    @Then("^Fill Name \"([^\"]*)\" and job \"([^\"]*)\"$")
    public void fillNameAndJob(String name, String job) throws Throwable {

        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("job")).sendKeys(job);
        Thread.sleep(2000);
    }

    @And("^I click on button Add$")
    public void iClickOnButtonAdd() throws Throwable {
        driver.findElement(By.id("modal_button")).click();
        Thread.sleep(4000);
    }

    @Then("^I click on button edit a person$")
    public void iClickOnButtonEditAPerson() throws Throwable {
        String home_url = "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html";
        assertEquals(home_url, driver.getCurrentUrl());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]/i")).click();
        Thread.sleep(2000);
    }

    @And("^Change person name to \"([^\"]*)\"$")
    public void changePersonNameTo(String arg0) throws Throwable {
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys(arg0);
        Thread.sleep(1000);
    }

    @And("^I click on button Edit$")
    public void iClickOnButtonEdit() throws Throwable {
        driver.findElement(By.id("modal_button")).click();
        Thread.sleep(1000);
    }


    @Then("^I click on the button Remove first person$")
    public void iClickOnTheButtonRemoveFirstPerson() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[1]")).click();
        Thread.sleep(1000);
    }

    @And("^I click on the button Reset$")
    public void iClickOnTheButtonReset() throws Throwable {
        driver.findElement(By.xpath("//button[contains(text(),'Reset List')]")).click();
        Thread.sleep(1000);
    }

    @Then("^I check that clear button work correctly$")
    public void iCheckThatClearButtonWorkCorrectly() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
        String add_url = "https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html";
        assertEquals(add_url, driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.findElement(By.id("name")).sendKeys("Jevgenijs");
        driver.findElement(By.id("job")).sendKeys("PitBoss");
        Thread.sleep(2000);
        driver.findElement(By.id("addPersonBtn")).click();
        Thread.sleep(2000);
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("job")).getText());
        Thread.sleep(2000);

    }
}
