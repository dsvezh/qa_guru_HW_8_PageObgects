import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
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
                        .setUserNumber("88005553535")
                        .setDateOfBirth("02", "May", "1997")
                        .setHomeAddress("Home_Address")
                        .setSubjects("English")
                        .setHobbies("Sports")
                        .setPicture("img/1.png")
                        .setState("NCR")
                        .setCity("Delhi")
                        .clickSubmit();








//        $(".modal-dialog").should(appear);
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive").shouldHave(text(userLastName), text(userFirstName), text("email@mail.com"),
//                text("Male"), text("8800555353"), text("English"), text("02 May,1997"),
//                text("Home_Address"), text("NCR Delhi"));

    }
}