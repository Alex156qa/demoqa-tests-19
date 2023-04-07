package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase{

    @Test
    void successfullFillFromTest() {
        open("https://demoqa.com/text-box");

      //  $("[id=userName]").setValue("Александр");
        $("#userName").setValue("Александр");
        $("#userEmail").setValue("ee@fg.ru");
        $("#currentAddress").setValue("Улица Гагарина 23, кв 165");
        $("#permanentAddress").setValue("russia");
        $("#submit").click();

        $("#output").shouldHave(text("Александр"), text("ee@fg.ru"),
                text("Улица Гагарина 23, кв 165"), text("russia"));
    }
}
