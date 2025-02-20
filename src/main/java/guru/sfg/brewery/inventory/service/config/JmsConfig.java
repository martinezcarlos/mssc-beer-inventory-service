package guru.sfg.brewery.inventory.service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

/** Created by jt on 2019-07-20. */
@Configuration
public class JmsConfig {

  public static final String NEW_INVENTORY_QUEUE = "new-inventory";

  @Bean // Serialize message content to json using TextMessage
  public MessageConverter jacksonJmsMessageConverter(final ObjectMapper objectMapper) {
    final MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
    converter.setTargetType(MessageType.TEXT);
    converter.setTypeIdPropertyName("_type");
    converter.setObjectMapper(objectMapper);
    return converter;
  }
}
