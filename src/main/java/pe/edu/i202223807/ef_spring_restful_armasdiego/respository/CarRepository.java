package pe.edu.i202223807.ef_spring_restful_armasdiego.respository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202223807.ef_spring_restful_armasdiego.entity.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
