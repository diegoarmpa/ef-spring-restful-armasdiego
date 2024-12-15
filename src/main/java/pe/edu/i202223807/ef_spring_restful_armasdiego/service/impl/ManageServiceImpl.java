package pe.edu.i202223807.ef_spring_restful_armasdiego.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.i202223807.ef_spring_restful_armasdiego.dto.CarDTO;
import pe.edu.i202223807.ef_spring_restful_armasdiego.dto.CarDetailDTO;
import pe.edu.i202223807.ef_spring_restful_armasdiego.entity.Car;
import pe.edu.i202223807.ef_spring_restful_armasdiego.respository.CarRepository;
import pe.edu.i202223807.ef_spring_restful_armasdiego.service.ManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDTO> getAllCars() throws Exception {

        List<CarDTO> cars = new ArrayList<CarDTO>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach( car -> {
            cars.add(new CarDTO(car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear(),
                    car.getLicensePlate(),
                    car.getOwnerName(),
                    car.getOwnerContact(),
                    car.getColor()));
        });
        return cars;
    }

    @Override
    public Optional<CarDetailDTO> getCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map( car -> new CarDetailDTO(car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getRegistrationExpirationDate(),
                car.getServiceDueDate()));
    }

    @Override
    public boolean updateCar(CarDTO carDTO) throws Exception {
        Optional<Car> optional = carRepository.findById(carDTO.carId());
        return optional.map( car -> {
            car.setCarId(carDTO.carId());
            car.setMake(carDTO.make());
            car.setModel(carDTO.model());
            car.setYear(carDTO.year());
            car.setLicensePlate(carDTO.licensePlate());
            car.setOwnerName(carDTO.ownerName());
            car.setOwnerContact(carDTO.ownerContact());
            car.setColor(carDTO.color());
            carRepository.save(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteCar(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean addCar(CarDetailDTO carDetailDTO) throws Exception {
        Optional<Car> optional = carRepository.findById(carDetailDTO.carId());
        if(optional.isPresent()) {
            return false;
        }else {
            Car car = new Car();
            car.setMake(carDetailDTO.make());
            car.setModel(carDetailDTO.model());
            car.setYear(carDetailDTO.year());
            car.setVin(carDetailDTO.vin());
            car.setLicensePlate(carDetailDTO.licensePlate());
            car.setOwnerName(carDetailDTO.ownerName());
            car.setOwnerContact(carDetailDTO.ownerContact());
            car.setPurchaseDate(carDetailDTO.purchaseDate());
            car.setMileage(carDetailDTO.mileage());
            car.setEngineType(carDetailDTO.engineType());
            car.setColor(carDetailDTO.color());
            car.setInsuranceCompany(carDetailDTO.insuranceCompany());
            car.setInsurancePolicyNumber(carDetailDTO.insurancePolicyNumber());
            car.setRegistrationExpirationDate(carDetailDTO.registrationExpirationDate());
            car.setServiceDueDate(carDetailDTO.serviceDueDate());
            carRepository.save(car);
            return true;
        }
    }
}
