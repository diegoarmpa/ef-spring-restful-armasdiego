package pe.edu.i202223807.ef_spring_restful_armasdiego.response;

import pe.edu.i202223807.ef_spring_restful_armasdiego.dto.CarDetailDTO;

public record findCarResponse(String code,
                              String error,
                              CarDetailDTO detailDTO) {
}
