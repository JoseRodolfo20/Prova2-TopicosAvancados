package br.edu.univas.si7.leonardohenrique.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.si7.leonardohenrique.model.Auditing;

@Repository
public interface AuditingMongoRepository extends MongoRepository<Auditing, String> {

}
