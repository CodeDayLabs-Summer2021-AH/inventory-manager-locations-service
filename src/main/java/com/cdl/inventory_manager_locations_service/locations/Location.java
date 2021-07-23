package com.cdl.inventory_manager_locations_service.locations;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Location {
    @Id
    @SequenceGenerator(name = "location_sequence", sequenceName = "location_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_sequence")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private Integer rowCount;
    // private Integer[] slots;

    public Location() {
    }

    public Location(Address address, Integer rowCount, Integer[] slots) {
        this.address = address;
        this.rowCount = rowCount;
        // this.slots = slots;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    /*
     * public Integer[] getSlots() { return slots; }
     * 
     * public void setSlots(Integer[] slots) { this.slots = slots; }
     */
}
