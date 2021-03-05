package com.example.solace.decode.repository.es;

import com.example.solace.decode.model.es.ESMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.annotations.Query;

import java.util.List;

public interface ESMessageRepository extends ElasticsearchRepository<ESMessage, String> {
    @Query("{\"bool\":{\"must\":{\"fuzzy\":{\"payload\":{\"value\":\"?0\"}}},\"should\":[{\"rank_feature\":{\"field\":\"search_clicks\"}}]}}")
    List<ESMessage> findAllByPayloadContains (String payload);
}
