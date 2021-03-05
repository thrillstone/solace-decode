package com.example.solace.decode.rest;

import com.example.solace.decode.model.SearchRequest;
import com.example.solace.decode.model.es.ESMessage;
import com.example.solace.decode.repository.es.ESMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    @Autowired
    ESMessageRepository ESRepo;

    @CrossOrigin
    @PostMapping("search/messages")
    List<ESMessage> searchMessages(@RequestBody SearchRequest request) {
        return ESRepo.findAllByPayloadContains(request.getContent());
    }
}
