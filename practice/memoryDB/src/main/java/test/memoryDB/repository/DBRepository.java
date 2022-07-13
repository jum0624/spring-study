package test.memoryDB.repository;

import test.memoryDB.domain.Entity;

import java.util.List;
import java.util.Optional;

public interface DBRepository {

    //create
    Entity save(Entity entity);

    //read
    Optional<Entity> findById(Long index);

    //delete
    void deleteById(Long index);

    List<Entity> findAll();

}
