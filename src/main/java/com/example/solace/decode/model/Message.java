package com.example.solace.decode.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Message {
	@Id
	private String id;

	private String payload;

	private String channelId;
}
