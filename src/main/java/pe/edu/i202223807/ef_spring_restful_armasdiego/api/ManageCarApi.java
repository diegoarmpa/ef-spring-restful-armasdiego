package pe.edu.i202223807.ef_spring_restful_armasdiego.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import pe.edu.i202223807.ef_spring_restful_armasdiego.dto.CarDTO;
import pe.edu.i202223807.ef_spring_restful_armasdiego.dto.CarDetailDTO;
import pe.edu.i202223807.ef_spring_restful_armasdiego.entity.Car;
import pe.edu.i202223807.ef_spring_restful_armasdiego.response.*;
import pe.edu.i202223807.ef_spring_restful_armasdiego.service.ManageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage-car")
public class ManageCarApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindCarsResponse findCars(){
        try {
            List<CarDTO> cars = manageService.getAllCars();
            if (!cars.isEmpty())
                return new FindCarsResponse("01", null, cars);
            else
                return new FindCarsResponse("02", "Cars not found", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "An error ocurred, please try again", null);
        }
    }

    @GetMapping("/detail")
    public findCarResponse findCar(@RequestParam(value = "id", defaultValue = "0") String id){
        try {
            Optional<CarDetailDTO> optional = manageService.getCarById(Integer.parseInt(id));
            return optional.map(car ->
                 new findCarResponse("01",null,car)
            ).orElse(
                    new findCarResponse("02", "Car not found", null)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new findCarResponse("99", "An error ocurred, please try again", null);
        }
    }

    @PutMapping("/update")
    public updateCarResponse updateCar(@RequestBody CarDTO car){
        try {
            if(manageService.updateCar(car))
                return new updateCarResponse("01",null);
            else
                return new updateCarResponse("02","Car not found");
        } catch (Exception e) {
            e.printStackTrace();
            return new updateCarResponse("99","An error ocurred, please try again");
        }
    }

    @DeleteMapping("/delete/{id}")
    public deleteCarResponse deleteCar(@PathVariable String id){
        try {
            if(manageService.deleteCar(Integer.parseInt(id)))
                return new deleteCarResponse("01",null);
            else
                return new deleteCarResponse("02","Car not found");
        } catch (Exception e) {
            e.printStackTrace();
            return new deleteCarResponse("99","An error ocurred, please try again");
        }
    }

    @PostMapping("/create")
    public createCarResponse createCar(@RequestBody CarDetailDTO carDetailDTO){
        try {
            if(manageService.addCar(carDetailDTO))
                return new createCarResponse("01",null);
            else
                return new createCarResponse("02","Car already exists");
        } catch (Exception e) {
            e.printStackTrace();
            return new createCarResponse("99","An error ocurred, please try again");
        }
    }


}
