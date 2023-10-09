package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    ////////// SelenideElements
    SelenideElement headline = $(".practice-form-wrapper"),
                    firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    genderWrapper = $("#genterWrapper"),
                    userNumberInput = $("#userNumber"),
                    userEmailInput = $("#userEmail"),
                    homeAddressInput = $("#currentAddress"),
                    subjectsInput = $("#subjectsInput"),
                    hobbiesInput = $("#hobbiesWrapper"),
                    uploadPicture = $("#uploadPicture"),
                    stateInput = $("#stateCity-wrapper"),
                    cityInput = $("#stateCity-wrapper"),
                    submitButton = $("#submit");


    ////////// Actions

    public RegistrationPage checkHeadline (String value) {
        headline.shouldHave(text(value));

        return this;
    }

    public RegistrationPage removeFooterBanner () {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        new CalendarComponent().setDate(day, month, year);

        return this;
    }

    public RegistrationPage setHomeAddress(String value) {
        homeAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setSubjects (String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies (String value) {
        hobbiesInput.$(byText(value)).parent().click();

        return this;
    }

    public RegistrationPage setPicture (String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setState (String value) {
        $("#state").click();
        stateInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity (String value) {
        $("#city").click();
        cityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmit () {
        submitButton.click();

        return this;
    }

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }
}

