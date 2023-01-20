package com.lingluoyun.petclinic.entity.system;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * @author Ling Luo
 * @description Simple JavaBean domain object adds a name property to <code>BaseEntity</code>. Used as
 * a base class for objects needing these properties.
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return this.getName();
    }
}
