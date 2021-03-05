package com.example.solace.decode.repository.es;

import com.example.solace.decode.model.es.ESMessage;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ESMessageRepository extends ElasticsearchRepository<ESMessage, String> {
    @Query("{" +
            "\"bool\": {" +
                "\"must\": {" +
                    "\"multi_match\": {" +
                        "\"fields\": [" +
                            "\"payload\"" +
                        "]," +
                        "\"query\": \"?0\"," +
                        "\"fuzziness\": \"AUTO\"" +
                    "}" +
                "}," +
                "\"should\": [" +
                    "{" +
                        "\"rank_feature\": {" +
                            "\"field\": \"search_clicks\"" +
                        "}" +
                    "}" +
                "]" +
            "}" +
            "}")
    List<ESMessage> findAllByPayloadContains (String payload);
}
