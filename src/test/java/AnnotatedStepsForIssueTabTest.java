import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsForIssueTabTest {

    public static final String REPO_NAME_2 = "ChesKnow/qa_guru_Ches_Allure_1lesson";

    @Test
    public void annotatedStepsForIssueTab() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        WebStepsDescription websteps = new WebStepsDescription();
        websteps.openMainPage();
        websteps.searchForRepoByName(REPO_NAME_2);
        websteps.openRepositoryByLink(REPO_NAME_2);
        websteps.checkIfTabIssueVisibleInRepo();
        websteps.takeScreenshot();
    }
}
