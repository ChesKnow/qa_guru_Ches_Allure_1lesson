import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class SelenideWithListenerForIssueTabTest {

    @Test
    public void visionAbilityOfTabIssueOnGitHubChesKnow() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Selenide.open("https://github.com/");
        Selenide.$("[data-test-selector='nav-search-input']").
                setValue("ChesKnow/qa_guru_Ches_Allure_1lesson").pressEnter();
        Selenide.$(By.linkText("ChesKnow/qa_guru_Ches_Allure_1lesson")).click();
        //Selenide.$("#repository-container-header").shouldHave(text("Issues"));
        Selenide.$("#issues-tab").should(visible);
    }
}
