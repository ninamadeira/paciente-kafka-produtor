# paciente-kafka-produtor
Produtor kafka de paciente.

### Docker do Kafka
```
cd paciente-kafka-produtor
docker-compose up
```
### Enviar paciente para o kafka
```
GET
http://localhost:8081/pacientes
{
 "nome": "Nina Madeira",
 "crmMedico": "23333",
 "problema": "dor na coluna",
 "diagnostico": "Ressonância para estudar o problema"  
}
Obs.: Foi utilizado o postman
 ```
