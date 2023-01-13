package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillForm () {
        //Переменные
        String firstName = "Иван";
        String lastName = "Гуру";
        String userEmail = "test_quru@gmail.com";
        String gender = "Male";
        String userNumber = "9505555555";
        String month = "May";
        String year = "1970";
        String day = "5";
        String subject = "Hindi";
        String hobby = "Sports";
        String currentAddress = "г.Первый ул.Вторая д.1 кв. 2";
        String state = "Haryana";
        String city = "Karnal";
        String happy_text = "Thanks for submitting the form";

        //Старт теста
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".main-header").shouldHave(Condition.text("Practice Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month").$(byText(day)).click();
        $("#subjectsInput").click();
        $("#subjectsInput").sendKeys(subject);
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("img/File.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        //Проверки
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text(happy_text));
        $(".table-responsive").shouldHave(Condition.text(firstName),
                Condition.text(lastName), Condition.text(userEmail), Condition.text(gender),
                Condition.text(userNumber), Condition.text("05 May,1970"), Condition.text("File.jpg"),
                Condition.text(subject), Condition.text(currentAddress), Condition.text(state),
                Condition.text(city));

        //Закрыть модалку
        $("#closeLargeModal").click();






    }
}
