import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWithListenerForIssueTabTest {

    @Test
    public void visionAbilityOfTabIssueOnGitHubChesKnow() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $("[data-test-selector='nav-search-input']").
                setValue("ChesKnow/qa_guru_Ches_Allure_1lesson").pressEnter();
        $(By.linkText("ChesKnow/qa_guru_Ches_Allure_1lesson")).click();
        $("#issues-tab").should(visible);
    }
}
