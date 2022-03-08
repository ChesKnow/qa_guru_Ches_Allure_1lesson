import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsForIssueTabTest {

    public static final String REPO_NAME = "ChesKnow/qa_guru_Ches_Allure_1lesson";

    @Test
    public void LambdaStepsDescribed() {
        //SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу браузера \"https://github.com\"", () -> {
            open("https://github.com/");
        });
        step("Находим поисковую строку и вставляем в неё название репозитория " + REPO_NAME, () -> {
            $("[data-test-selector='nav-search-input']").
                    setValue("ChesKnow/qa_guru_Ches_Allure_1lesson").pressEnter();
        });
        step("в результатах поиска находим и нажимаем ссылку " + REPO_NAME, () -> {
            $(By.linkText("ChesKnow/qa_guru_Ches_Allure_1lesson")).click();
        });
        step("Проверяем, что в репозитории есть таб Issue", () -> {
            $("#issues-tab").should(visible);
        });
    }
}
