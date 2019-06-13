package pro.buildmysoftware.oop.order.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.money.Money;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class MoneyDeserializer extends JsonDeserializer<Money> {
	@Override
	public Money deserialize(final JsonParser p,
				 final DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return Money.parse(p.readValueAs(String.class));
	}
}
