package org.fetch.pages;

import org.fetch.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}