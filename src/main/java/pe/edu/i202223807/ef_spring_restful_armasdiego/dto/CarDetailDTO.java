package pe.edu.i202223807.ef_spring_restful_armasdiego.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record CarDetailDTO(Integer carId,
                           String make,
                           String model,
                           Integer year,
                           String vin,
                           String licensePlate,
                           String ownerName,
                           String ownerContact,

                           Date purchaseDate,
                           Integer mileage,
                           String engineType,
                           String color,
                           String insuranceCompany,
                           String insurancePolicyNumber,

                           Date registrationExpirationDate,

                           Date serviceDueDate) {
}
