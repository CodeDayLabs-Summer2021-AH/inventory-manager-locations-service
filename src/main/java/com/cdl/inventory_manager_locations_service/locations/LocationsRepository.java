package com.cdl.inventory_manager_locations_service.locations;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationsRepository extends JpaRepository<Location, Long> {
    List<Location> findByName(String name);
}
