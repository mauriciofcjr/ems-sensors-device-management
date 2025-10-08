package com.mchaves.sensors.device.management.api.client.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class SensorMonitoringClientBadGatewayException extends RuntimeException {
    

}
