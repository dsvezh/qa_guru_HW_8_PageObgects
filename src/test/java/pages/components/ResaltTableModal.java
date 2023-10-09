package pages.components;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResaltTableModal {

    ////////// SelenideElements
    SelenideElement resultTable = $(".modal-dialog"),
                    titleTable  = $("#example-modal-sizes-title-lg");



    public ResaltTableModal checkResultTableAppear () {
        resultTable.should(appear);

        return this;
    }
    public ResaltTableModal checkTitleTable (String value) {
        titleTable.shouldHave(text(value));

        return this;
    }
    public ResaltTableModal checkResult (String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }


}
