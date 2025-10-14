package com.mchaves.sensors.device.management.api.client;

import java.time.Duration;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.mchaves.sensors.device.management.api.client.exception.SensorMonitoringClientBadGatewayException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RestClientFactory {

    private final RestClient.Builder builder;

    public RestClient temperatureMonitoringRestClient() {
        return builder.baseUrl("http://localhost:8082")
                .requestFactory(generateClientHttpRequestFactory())
                .defaultStatusHandler(HttpStatusCode::isError, (request, response) -> {
                    throw new SensorMonitoringClientBadGatewayException();
                })

                .build();
    }

    private ClientHttpRequestFactory generateClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(Duration.ofSeconds(3));
        factory.setReadTimeout(Duration.ofSeconds(5));
        return factory;
    }
}
