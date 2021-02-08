package com.fampay.youtube.search.webclient;

import com.google.api.client.util.DateTime;
import com.google.gson.Gson;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Component
public class YoutubeClientServiceImpl implements YoutubeClientService{


    private final WebClient mWebClient;
    private Scheduler scheduler;

    public YoutubeClientServiceImpl(Environment environment) {

        mWebClient = WebClient.builder()
                .baseUrl("https://youtube.googleapis.com/youtube")
                .build();
        scheduler = getScheduler();
    }

    public Scheduler getScheduler() {
        if (scheduler == null)
            scheduler = Schedulers.newParallel("YouTube", 10);
        return scheduler;
    }

    private Mono<WebClient> getWebClient() {
        return Mono.just(mWebClient)
                .subscribeOn(getScheduler());
    }


    @Override
    public Mono<Object> getSearchResult(String query) {

        return getWebClient().flatMap(webClient -> webClient.get()
                .uri(
                        uriBuilder ->
                                uriBuilder
                                        .path("/v3/search")
                                        .queryParam("q",query)
                                        .queryParam("publishAfter", new DateTime("2021-01-08T19:35:55.384Z"))
                                        .queryParam("key","AIzaSyD9Ft5ww8LVMXNeDgFmpjHW7IIdT6CxQ0A")
                                        .queryParam("maxResult",25)
                                        .queryParam("part","snippet")
                                        .build())
                .header("Authorization", "AIzaSyD9Ft5ww8LVMXNeDgFmpjHW7IIdT6CxQ0A")
                .header("Accept", "application/json")
                .retrieve()
                .bodyToMono(Object.class)).doOnSuccess(o -> {
            System.out.println(new Gson().toJson(o));
        });
    }


}
