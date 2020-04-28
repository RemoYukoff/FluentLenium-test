package com.remo.Pages;

import static org.assertj.core.api.Assertions.*;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

@PageUrl("https://www.youtube.com/")
public class YoutubeHomePage extends FluentPage {
    @FindBy(xpath = "//input[@id='search']")
    private FluentWebElement searchInput;

    @FindBy(id = "search-icon-legacy")
    private FluentWebElement searchButton;

    @FindBy(xpath = "//*[@id='video-title'][1]")
    private FluentWebElement videoAnchor;

    public YoutubeHomePage typeSearch(String query){
        searchInput.write(query);
        return this;
    }

    public YoutubeHomePage submitSearch(){
        searchButton.click();
        return this;
    }

    public String getFirstVideoTitle(){
        return videoAnchor.text();
    }

    public YoutubeVideoPage openFirstVideo(){
        videoAnchor.click();
        return newInstance(YoutubeVideoPage.class);
    }

    public void assertTitleContains(String query){
        await().atMost(5, TimeUnit.SECONDS).until(
                () -> window().title().contains(query)
        );
        assertThat(window().title()).contains(query);
    }
}
