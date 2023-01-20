package com.lingluoyun.petclinic.entity.vet;

import com.lingluoyun.petclinic.entity.system.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author Ling Luo
 * @description Models a {@link Vet Vet's} specialty (for example, dentistry).
 */
@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity {
}
