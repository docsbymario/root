package com.docsbymario.root.repository;

import com.docsbymario.root.entity.App;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppRepository extends MongoRepository<App, String> {
    List<App> findAllByOrderByIndex();
}
