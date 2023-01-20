package com.lingluoyun.petclinic.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.lingluoyun.petclinic.entity.owner.Owner;
import com.lingluoyun.petclinic.entity.owner.Pet;
import com.lingluoyun.petclinic.mapper.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test class for {@link VisitController}
 */
@WebMvcTest(VisitController.class)
class VisitControllerTest {

    private static final int TEST_OWNER_ID = 1;

    private static final int TEST_PET_ID = 1;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerRepository owners;

    @BeforeEach
    void init() {
        Owner owner = new Owner();
        Pet pet = new Pet();
        owner.addPet(pet);
        pet.setId(TEST_PET_ID);
        given(this.owners.findById(TEST_OWNER_ID)).willReturn(owner);
    }

    @Test
    void testInitNewVisitForm() throws Exception {
        mockMvc.perform(get("/owners/{ownerId}/pets/{petId}/visits/new", TEST_OWNER_ID, TEST_PET_ID))
                .andExpect(status().isOk()).andExpect(view().name("pets/createOrUpdateVisitForm"));
    }

    @Test
    void testProcessNewVisitFormSuccess() throws Exception {
        mockMvc.perform(post("/owners/{ownerId}/pets/{petId}/visits/new", TEST_OWNER_ID, TEST_PET_ID)
                        .param("name", "George").param("description", "Visit Description"))
                .andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/owners/{ownerId}"));
    }

    @Test
    void testProcessNewVisitFormHasErrors() throws Exception {
        mockMvc.perform(
                        post("/owners/{ownerId}/pets/{petId}/visits/new", TEST_OWNER_ID, TEST_PET_ID).param("name", "George"))
                .andExpect(model().attributeHasErrors("visit")).andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdateVisitForm"));
    }

}