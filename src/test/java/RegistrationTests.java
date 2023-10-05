import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfullRegistrationTest() {

        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        registrationPage.setFirstName("Ivan")
                        .setLastName("Ivanov")
                        .setEmail("ivan@ivanov.com")
                        .setGender("Male")
                        .setUserNumber("88005553535");


//        $("#firstName").setValue("Alex");
//        $("#lastName").setValue(userLastName);
//        $("#userEmail").setValue("email@mail.com");
//        $("#userNumber").setValue("88005553535");
//        $("#currentAddress").setValue("Home_Address");
//        $("#gender-radio-1").parent().click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--002:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

//        $(".modal-dialog").should(appear);
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive").shouldHave(text(userLastName), text(userFirstName), text("email@mail.com"),
//                text("Male"), text("8800555353"), text("English"), text("02 May,1997"),
//                text("Home_Address"), text("NCR Delhi"));

    }
}