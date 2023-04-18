package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 3000;
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successPracticeFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#footer').remove()");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Popov");
        $("#userEmail").setValue("popov@er.ru");
        //  $("#gender-radio-1").click(); //wrong
        // $("#gender-radio-1").parent().click(); //правильный вариант
        $(byText("Male")).click(); //тоже правильный
        $("#userNumber").setValue("9229229222");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1996");

        //<div class=" react-datepicker__day--030 react-datepicker__day--weekend react-datepicker__day--outside-month" aria-label="Choose Sunday, June 30th, 1996" >30</div>
        //   <div class=" react-datepicker__day--030"                                                                     aria-label="Choose Tuesday, July 30th, 1996" >30</div>
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("english").pressEnter();
        //  $(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Street 5");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Popov"), text("popov@er.ru"), text("9229229222"));
    }
}
