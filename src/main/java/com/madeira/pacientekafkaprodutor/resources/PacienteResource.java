package com.madeira.pacientekafkaprodutor.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public String send(@Valid @RequestBody final PacienteDTO dto) {

        kafkaTemplate.send(TOPIC, dto);

        return "Published successfully";
    }
}
