package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {
    @BeforeAll
    static void  beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize ="1920x1080";
        Configuration.timeout = 3000;
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void successPracticeFormTest() {
        open("/automation-practice-form");
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
        $(".react-datepicker__year-select").selectOption("1996");

       //<div class=" react-datepicker__day--030 react-datepicker__day--weekend react-datepicker__day--outside-month" aria-label="Choose Sunday, June 30th, 1996" >30</div>
     //   <div class=" react-datepicker__day--030"                                                                     aria-label="Choose Tuesday, July 30th, 1996" >30</div>
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("eng").pressEnter();
        $(byText("Male")).click();

    }
}
