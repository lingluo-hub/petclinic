package com.lingluoyun.petclinic.entity.owner;

import com.lingluoyun.petclinic.entity.system.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends NamedEntity {
}
