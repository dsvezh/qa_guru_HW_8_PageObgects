import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResaltTableModal;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResaltTableModal resaltTableModal = new ResaltTableModal();

    @Test
    void successfullRegistrationTest() {


        registrationPage.openPage()
                        .removeFooterBanner()
                        .checkHeadline("Student Registration Form")
                        .setFirstName("Ivan")
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



        resaltTableModal.checkResultTableAppear()
                        .checkTitleTable("Thanks for submitting the form")
                        .checkResult("Student Name", "Ivan Ivanov")
                        .checkResult("Student Email", "ivan@ivanov.com")
                        .checkResult("Mobile", "8800555353")
                        .checkResult("Date of Birth", "02 May,1997")
                        .checkResult("Subjects", "English")
                        .checkResult("Hobbies", "Sports")
                        .checkResult("Picture", "1.png")
                        .checkResult("Address", "Home_Address")
                        .checkResult("State and City", "NCR Delhi");



    }
}