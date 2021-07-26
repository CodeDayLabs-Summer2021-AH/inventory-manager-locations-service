package com.cdl.inventory_manager_locations_service.locations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationsService {
    private final LocationsRepository locationsRepository;

    @Autowired
    public LocationsService(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    public List<Location> getLocations(Optional<String> query) {
        if (query.isPresent()) {
            try {
                Long id = Long.parseLong(query.get());
                Optional<Location> location = locationsRepository.findById(id);

                if (location.isPresent()) {
                    return List.of(location.get());
                } else {
                    return List.of();
                }
            } catch (NumberFormatException e) {
                return locationsRepository.findByName(query.get());
            }
        } else {
            return locationsRepository.findAll();
        }
    }
}
