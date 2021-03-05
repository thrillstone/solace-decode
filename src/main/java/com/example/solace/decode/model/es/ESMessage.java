package com.example.solace.decode.model.es;

import com.example.solace.decode.model.Message;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "messages")
@ToString
@NoArgsConstructor
@Getter
@Setter
public class ESMessage {
	@Id
	private String id;

	private String payload;

	@Field(type = FieldType.Rank_Feature)
	private int search_clicks;

	public ESMessage(Message message) {
		this.id = message.getId();
		this.payload = message.getPayload();
		this.search_clicks = 0;
	}
}
