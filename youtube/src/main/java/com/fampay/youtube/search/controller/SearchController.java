package com.fampay.youtube.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import com.fampay.youtube.search.webclient.YoutubeClientService;
@RestController
public class SearchController {

    @Autowired
    YoutubeClientService youtubeClientService;
    @GetMapping("/youtube/{query}")
    Mono<Object> getSearchResult(@PathVariable("query") String query)
    {
       return youtubeClientService.getSearchResult(query);
    }


}
