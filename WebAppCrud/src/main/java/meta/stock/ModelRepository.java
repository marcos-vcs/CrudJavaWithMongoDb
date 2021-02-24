package meta.stock.java;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModelRepository extends MongoRepository<ModeloClass, String> {

}
