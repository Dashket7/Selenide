package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;


import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryFormTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999/");
        SelenideElement form = $("[action]");
        $("[data-test-id='city'] input").setValue("Пермь");
        $("[data-test-id='date'] input").setValue("24.09.2023");
        $("[data-test-id='name'] input").setValue("Иван-Кабан Иванов");
        $("[data-test-id='phone'] input").setValue("+79045874124");
        $("[data-test-id='agreement']").click();
        $(byText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(14));
    }
}
