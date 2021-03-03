package com.example.solace.decode.repository.es;

import com.example.solace.decode.model.es.ESMessage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESMessageRepository extends ElasticsearchRepository<ESMessage, String> {
}
