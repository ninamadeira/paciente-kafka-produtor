package com.madeira.pacientekafkaprodutor.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madeira.pacientekafkaprodutor.dto.PacienteDTO;


@RestController
@RequestMapping(value ="/pacientes")
public class PacienteResource {

    @Autowired
    private KafkaTemplate<String, PacienteDTO> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example_json";

    @PostMapping
    public String send(@RequestBody final PacienteDTO dto) {

        kafkaTemplate.send(TOPIC, dto);

        return "Published successfully";
    }
}
