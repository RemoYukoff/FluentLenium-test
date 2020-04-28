package com.remo.Tests;

import com.remo.Pages.YoutubeHomePage;
import com.remo.Pages.YoutubeVideoPage;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;

@Wait
public class YoutubeTest extends FluentTest {
    @Page
    YoutubeHomePage youtubeHomePage;

    @Test
    public void searchTest() {
        String query = "asereje ja deje";
        goTo(youtubeHomePage).
                typeSearch(query).
                submitSearch().
                assertTitleContains(query);
    }

    @Test
    public void openVideo(){
        YoutubeHomePage page = goTo(youtubeHomePage);
        String expectedTitle = page.getFirstVideoTitle();
        page.openFirstVideo().assertVideoTitleIs(expectedTitle);
    }
}