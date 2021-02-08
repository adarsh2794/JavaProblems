package com.fampay.youtube.search.webclient;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
public interface YoutubeClientService {

    Mono<Object> getSearchResult(String query);
}
