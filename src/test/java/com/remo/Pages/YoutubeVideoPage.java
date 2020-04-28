package com.remo.Pages;

import static org.assertj.core.api.Assertions.*;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class YoutubeVideoPage extends FluentPage {
    @FindBy(xpath = "//*[@id='container']/h1/yt-formatted-string")
    private FluentWebElement videoTitle;

    public void assertVideoTitleIs(String expectedTitle){
        await().until(videoTitle).displayed();
        assertThat(videoTitle.text()).isEqualTo(expectedTitle);
    }
}
