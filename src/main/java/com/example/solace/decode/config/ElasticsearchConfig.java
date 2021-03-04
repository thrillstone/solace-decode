package com.example.solace.decode.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.solace.decode.repository")
public class ElasticsearchConfig {
	@Bean
	public ElasticsearchOperations elasticsearchTemplate(RestHighLevelClient client) {
		return new ElasticsearchRestTemplate(client);
	}
}
