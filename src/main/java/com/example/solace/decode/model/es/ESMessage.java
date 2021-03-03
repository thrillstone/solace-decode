package com.example.solace.decode.model.es;

import com.example.solace.decode.model.Message;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "messages")
@ToString
@NoArgsConstructor
@Getter
@Setter
public class ESMessage {
	@Id
	private String id;

	private String payload;

	public ESMessage(Message message) {
		this.id = message.getId();
		this.payload = message.getPayload();
	}
}
