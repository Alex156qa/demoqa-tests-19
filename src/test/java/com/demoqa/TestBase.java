package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void  beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize ="1920x1080";
    }
}
