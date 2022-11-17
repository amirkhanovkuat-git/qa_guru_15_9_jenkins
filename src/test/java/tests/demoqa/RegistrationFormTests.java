package tests.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormTests extends TestBase {

    @Test
    void fillFormTest() {
        step("Open registrations form", () ->{
            open("/automation-practice-form");
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");
        });

        step("Fill form", () -> {
            $("#firstName").setValue("Kuat");
            $("#lastName").setValue("Amirkhanov");
            $("#userEmail").setValue("amirkhanovkuat@gmail.com");
            $(byText("Male")).click();
            $("#userNumber").setValue("7051174428");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").click();
            $(byText("1999")).click();
            $(".react-datepicker__month-select").click();
            $(byText("December")).click();
            $(byText("8")).click();
            $("#subjectsInput").setValue("Mat");
            $(byText("Maths")).click();
            $("[for=hobbies-checkbox-3]").click();
            $("#uploadPicture").scrollTo();
            $("#uploadPicture").uploadFile(new File("src/test/resources/test.jpeg"));
            $("#currentAddress").setValue("Some address");
            $("#state").click();
            $(byText("Haryana")).click();
            $("#city").click();
            $(byText("Panipat")).click();
            $("#submit").click();
        });

        step("Check form results", () -> {
            $(".modal-body").shouldHave(text("Kuat Amirkhanov"),
                    text("amirkhanovkuat@gmail.com"),
                    text("Male"),
                    text("7051174428"),
                    text("08 December,1999"),
                    text("Maths"),
                    text("Music"),
                    text("test.jpeg"),
                    text("Some address"),
                    text("Haryana Panipat"));
        });
    }
}