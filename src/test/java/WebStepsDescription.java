import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.visible;

public class WebStepsDescription {

    @Step("Открываем страницу браузера \"https://github.com\"")
    public void openMainPage() {
        Selenide.open("https://github.com/");}

    @Step("Находим поисковую строку и вставляем в неё название репозитория {repo_name}")
    public void searchForRepoByName(String repo_name) {
        Selenide.$("[data-test-selector='nav-search-input']").
                setValue("ChesKnow/qa_guru_Ches_Allure_1lesson").pressEnter();
    }

    @Step("в результатах поиска находим и нажимаем ссылку {repo_name}")
    public void openRepositoryByLink(String repo_name) {
        Selenide.$(By.linkText("ChesKnow/qa_guru_Ches_Allure_1lesson")).click();
    }

    @Step("Проверяем, что в репозитории есть таб Issue")
    public void checkIfTabIssueVisibleInRepo() {
        Selenide.$("#issues-tab").should(visible);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
