package com.example.solace.decode.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Queue {
	@Id
	private String name;
}
