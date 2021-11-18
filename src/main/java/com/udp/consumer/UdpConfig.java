package com.udp.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class UdpConfig {

    @Value("${udp.channel}")
    private String channel;
    @Value("${udp.port}")
    private Integer port;

    final int CORE_POOL_SIZE = 10;
    final int MAX_POOL_SIZE = 40;
    final int QUEUE_SIZE = 10;

    @Bean
    public MessageChannel inboundChannel() {
        return new DirectChannel();
    }

    @Bean(name = "udpReceivingAdapter")
    public UnicastReceivingChannelAdapter udpReceivingAdapter() {

        UnicastReceivingChannelAdapter adapter = new UnicastReceivingChannelAdapter(port);
        adapter.setOutputChannel(inboundChannel());
        adapter.setTaskExecutor(getTaskExecutor());
        adapter.setOutputChannelName(channel);
        return adapter;
    }

    TaskExecutor getTaskExecutor() {

        ThreadPoolTaskExecutor ioExec = new ThreadPoolTaskExecutor();
        ioExec.setCorePoolSize(CORE_POOL_SIZE);
        ioExec.setMaxPoolSize(MAX_POOL_SIZE);
        ioExec.setQueueCapacity(QUEUE_SIZE);
        ioExec.setThreadNamePrefix("io-");
        ioExec.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        ioExec.initialize();
        return ioExec;
    }

}
