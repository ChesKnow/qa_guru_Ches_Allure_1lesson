import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;

public class LambdaStepsForIssueTabTest {

    public static final String REPO_NAME = "ChesKnow/qa_guru_Ches_Allure_1lesson";

    @Test
    public void LambdaStepsDescribed() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Allure.step("Открываем страницу браузера \"https://github.com\"", () -> {
            Selenide.open("https://github.com/");
        });
        Allure.step("Находим поисковую строку и вставляем в неё название репозитория " + REPO_NAME, () -> {
            Selenide.$("[data-test-selector='nav-search-input']").
                    setValue("ChesKnow/qa_guru_Ches_Allure_1lesson").pressEnter();
        });
        Allure.step("в результатах поиска находим и нажимаем ссылку " + REPO_NAME, () -> {
            Selenide.$(By.linkText("ChesKnow/qa_guru_Ches_Allure_1lesson")).click();
        });
        Allure.step("Проверяем, что в репозитории есть таб Issue", () -> {
            Selenide.$("#issues-tab").should(visible);
        });
    }
}
