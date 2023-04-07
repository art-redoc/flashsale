package art.redoc.business.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
@Slf4j
public class FlashSaleProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendFlashSale(String message) {
        ListenableFuture future = kafkaTemplate.send("flash_sale", message);
        future.addCallback(o -> log.info("send-消息发送成功：" + message), throwable -> log.error("消息发送失败：" + message));
    }
}
