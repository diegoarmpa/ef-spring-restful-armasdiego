package pe.edu.i202223807.ef_spring_restful_armasdiego.dto;

public record CarDTO(Integer carId,
                     String make,
                     String model,
                     Integer year,
                     String licensePlate,
                     String ownerName,
                     String ownerContact,
                     String color) {
}
