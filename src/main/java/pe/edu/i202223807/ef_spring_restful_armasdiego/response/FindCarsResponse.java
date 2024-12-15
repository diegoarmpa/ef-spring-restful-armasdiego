package pe.edu.i202223807.ef_spring_restful_armasdiego.response;

import pe.edu.i202223807.ef_spring_restful_armasdiego.dto.CarDTO;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDTO> cars) {
}
