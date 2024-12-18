package com.docsbymario.root.repository;

import com.docsbymario.root.entity.App;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends MongoRepository<App, String> {
}
