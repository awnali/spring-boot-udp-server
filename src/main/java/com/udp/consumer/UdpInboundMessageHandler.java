package com.udp.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;

import java.util.Map;
import java.util.UUID;

@MessageEndpoint
public class UdpInboundMessageHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(UdpInboundMessageHandler.class);

    @ServiceActivator(inputChannel = "inboundChannel")
    public void handeMessage(Message message, @Headers Map<String, Object> headerMap) {
//        Thread.sleep(2000);

        LOGGER.info("Received UDP payload: {}", new String((byte[]) message.getPayload()));
    }
}
