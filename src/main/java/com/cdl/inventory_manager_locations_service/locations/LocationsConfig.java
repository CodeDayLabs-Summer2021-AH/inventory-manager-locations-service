package com.cdl.inventory_manager_locations_service.locations;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class LocationsConfig {
    @Bean
    CommandLineRunner commandLineRunner(LocationsRepository locationsRepository) {
        return args -> {

            Address address = new Address("Hello", "Binary", "World", "Nowhere", "424242",
                    "Nowhere State - Nowhere Province - Nowhere Country", "NW");
            Location location = new Location(address, 10, new Integer[10]);

            locationsRepository.save(location);
        };
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(new Info().title("Inventory Manager API - Locations Service")
                .description("Inventory Manager - Locations Service - Documentation").version("v0.0.1")
                .license(new License().name("GPL v3.0").url(
                        "https://github.com/CodeDayLabs-Summer2021-AH/inventory-manager-locations-service/blob/main/LICENSE")));
    }
}
