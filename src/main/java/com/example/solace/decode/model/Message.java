package com.example.solace.decode.model;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.*;

@Data
@Entity
public class Message {
	@Id
	private String id;

//	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "channelId",  referencedColumnName = "id", nullable = false, updatable = false)
//	private Channel channel;

 	@Column(nullable=false)
	private Integer channelId;

	@Column(nullable=false)
	private String type;

	@Column(nullable=false)
	private Integer userId;

	@Column(nullable=false)
	private String name;

	@Column(nullable=false)
	private String text;

	@Column(nullable=false)
	private String timestamp;

}

