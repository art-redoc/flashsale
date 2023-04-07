package art.redoc.consumer.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class FlashSaleEmailConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = {"flash_sale"})
    public void listen(ConsumerRecord<Object, String> record) throws IOException {
        log.info("发送邮件");
    }
}
