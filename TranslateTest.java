import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.junit.ScreenShooter;

public class TranslateTest {

    String resultText="";

    @Rule
    public ScreenShooter photographer = ScreenShooter.failedTests();

    @BeforeClass
    public static void init(){
        Configuration.browser = "chrome";
        Configuration.startMaximized=true;
    }

    @Test
    public void test() {
        open("http://www.translate.ru/");

        $("#sLang").selectOptionContainingText("Английский");
        $("#rLang").selectOptionContainingText("Немецкий");
        $("#sourceText").val("London is a capital of Great Britain");

        $("#bTranslation").click();

        resultText = $("#editResult_test").shouldBe(visible).getText();

       // navigator.back();

    }

    @AfterClass
    public static void tearDown(){

    }
}
