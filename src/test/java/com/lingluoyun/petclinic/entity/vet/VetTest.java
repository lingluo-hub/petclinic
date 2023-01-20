package com.lingluoyun.petclinic.entity.vet;

import org.junit.jupiter.api.Test;
import org.springframework.util.SerializationUtils;

import static org.assertj.core.api.Assertions.assertThat;

class VetTest {

    @Test
    void testSerialization() {
        Vet vet = new Vet();
        vet.setFirstName("Zaphod");
        vet.setLastName("Beeblebrox");
        vet.setId(123);
        Vet other = (Vet) SerializationUtils.deserialize(SerializationUtils.serialize(vet));
        assertThat(other.getFirstName()).isEqualTo(vet.getFirstName());
        assertThat(other.getLastName()).isEqualTo(vet.getLastName());
        assertThat(other.getId()).isEqualTo(vet.getId());
    }

}