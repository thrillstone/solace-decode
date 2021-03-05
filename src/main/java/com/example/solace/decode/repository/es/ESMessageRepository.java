package com.example.solace.decode.repository.es;

import com.example.solace.decode.model.es.ESMessage;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ESMessageRepository extends ElasticsearchRepository<ESMessage, String> {
    /*
{
	"bool": {
		"must": {
			"fuzzy": {
				"payload": {
					"value": "?0"
				}
			}
		}
	}
}
     */
    @Query("{\n" +
            "\t\"bool\": {\n" +
            "\t\t\"must\": {\n" +
            "\t\t\t\"fuzzy\": {\n" +
            "\t\t\t\t\"payload\": {\n" +
            "\t\t\t\t\t\"value\": \"?0\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t}\n" +
            "}")
    List<ESMessage> findAllByPayloadContains(String payload);
}
