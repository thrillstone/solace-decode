package com.example.solace.decode.repository.es;

import com.example.solace.decode.model.es.ESMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ESMessageRepository extends ElasticsearchRepository<ESMessage, String> {
    List<ESMessage> findAllByPayloadContains(String payload);
}
