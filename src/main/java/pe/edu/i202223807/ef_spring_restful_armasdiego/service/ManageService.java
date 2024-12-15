package pe.edu.i202223807.ef_spring_restful_armasdiego.service;

import pe.edu.i202223807.ef_spring_restful_armasdiego.dto.CarDTO;
import pe.edu.i202223807.ef_spring_restful_armasdiego.dto.CarDetailDTO;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDTO> getAllCars() throws Exception;

    Optional<CarDetailDTO> getCarById(int id) throws Exception;

    boolean updateCar (CarDTO carDTO) throws Exception;

    boolean deleteCar(int id) throws Exception;

    boolean addCar(CarDetailDTO carDetailDTO) throws Exception;
}
