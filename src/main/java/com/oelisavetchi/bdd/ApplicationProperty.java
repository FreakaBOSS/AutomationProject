package com.oelisavetchi.bdd;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApplicationProperty {

    @Value("${page.url}")
    private String pageUrl;

}
