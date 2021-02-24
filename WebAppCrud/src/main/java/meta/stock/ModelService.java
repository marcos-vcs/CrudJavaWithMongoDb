package meta.stock.java;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {
	
	@Autowired
	private ModelRepository repository;	

	
	//read
	public List<ModeloClass> listAll(){
		return repository.findAll();
	}	
	
	//read from id
	public Optional<ModeloClass> getCar(Integer id){
		return repository.findById(id.toString());
	}
	
	//create
	public void save(ModeloClass modelo){
		repository.save(modelo);
	}
	
	//delete
	public void delete(Integer id) {
		repository.deleteById(id.toString());
	}
	
	

}
