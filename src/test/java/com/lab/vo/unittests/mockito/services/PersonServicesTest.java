package com.lab.vo.unittests.mockito.services;

import com.lab.vo.data.model.Person;
import com.lab.vo.data.vo.v1.PersonVO;
import com.lab.vo.repository.PersonRepository;
import com.lab.vo.services.PersonServices;
import com.lab.vo.unittests.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {

    MockPerson input;

    @InjectMocks
    private PersonServices services;
    @Mock
    PersonRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception{
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);

    }
    @Test
    public void testFindById(){
    Person person = input.mockEntity(0);
    person.setId(UUID.fromString("2866531f-a229-4325-8e66-f31e6d66a540"));

    when(repository.findById(UUID.fromString("2866531f-a229-4325-8e66-f31e6d66a540"))).thenReturn(Optional.of(person));

    var result = services.findById(UUID.fromString("2866531f-a229-4325-8e66-f31e6d66a540"));
    assertNotNull(result);
    assertNotNull(result.getKey());
    assertNotNull(result.getLinks());
        System.out.println(result.toString());
    assertTrue(result.toString().contains("links: [</person/2866531f-a229-4325-8e66-f31e6d66a540>;rel=\"self\"]"));

    assertEquals("Addres Test0", result.getAddress());
    assertEquals("First Name Test0", result.getFirstName());
    assertEquals("Last Name Test0", result.getLastName());
    assertEquals("Male", result.getGender());
    }
    @Test
    public void testCreate(){
        Person entity = input.mockEntity(1);

        Person persisted = entity;
        persisted.setId(UUID.fromString("5e47bf9b-6d6f-44f2-a5b6-6cc2920ffdf1"));

        PersonVO vo = input.mockVO(1);
        vo.setKey(UUID.fromString("5e47bf9b-6d6f-44f2-a5b6-6cc2920ffdf1"));

        when(repository.save(entity)).thenReturn(persisted);

        var result = services.create(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());


        assertTrue(result.toString().contains("links: [</person/5e47bf9b-6d6f-44f2-a5b6-6cc2920ffdf1>;rel=\"self\"]"));
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());
    }
    @Test
    public void testUpdate(){
        Person entity = input.mockEntity(1);
        entity.setId(UUID.fromString("5e47bf9b-6d6f-44f2-a5b6-6cc2920ffdf1"));

        Person persisted = entity;
        persisted.setId(UUID.fromString("5e47bf9b-6d6f-44f2-a5b6-6cc2920ffdf1"));

        PersonVO vo = input.mockVO(1);
        vo.setKey(UUID.fromString("5e47bf9b-6d6f-44f2-a5b6-6cc2920ffdf1"));

        when(repository.findById(UUID.fromString("5e47bf9b-6d6f-44f2-a5b6-6cc2920ffdf1"))).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);

        var result = services.update(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());


        assertTrue(result.toString().contains("links: [</person/5e47bf9b-6d6f-44f2-a5b6-6cc2920ffdf1>;rel=\"self\"]"));
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());
    }

    @Test
    public void testDelete(){
        Person entity = input.mockEntity(1);
        entity.setId(UUID.fromString("5e47bf9b-6d6f-44f2-a5b6-6cc2920ffdf1"));

        when(repository.findById(UUID.fromString("5e47bf9b-6d6f-44f2-a5b6-6cc2920ffdf1"))).thenReturn(Optional.of(entity));

        services.findById(UUID.fromString("5e47bf9b-6d6f-44f2-a5b6-6cc2920ffdf1"));

    }

    @Test
    public void testFindAll(){
        List<Person> list = input.mockEntityList();

        when(repository.findAll()).thenReturn(list);

        var people = services.findAll();

        assertNotNull(people);
        assertEquals(10, people.size());

        var personOne = people.get(1);

        assertNotNull(personOne);
        assertNotNull(personOne.getKey());
        assertNotNull(personOne.getLinks());


        assertTrue(personOne.toString().contains("links: [</person/2866531f-a229-4325-8e66-f31e6d66a541>;rel=\"self\"]"));
        assertEquals("Addres Test1", personOne.getAddress());
        assertEquals("First Name Test1", personOne.getFirstName());
        assertEquals("Last Name Test1", personOne.getLastName());
        assertEquals("Female", personOne.getGender());

        var personFive = people.get(5);

        assertNotNull(personFive);
        assertNotNull(personFive.getKey());
        assertNotNull(personFive.getLinks());


        assertTrue(personFive.toString().contains("links: [</person/2866531f-a229-4325-8e66-f31e6d66a545>;rel=\"self\"]"));
        assertEquals("Addres Test5", personFive.getAddress());
        assertEquals("First Name Test5", personFive.getFirstName());
        assertEquals("Last Name Test5", personFive.getLastName());
        assertEquals("Female", personFive.getGender());

        var personEight = people.get(8);

        assertNotNull(personEight);
        assertNotNull(personEight.getKey());
        assertNotNull(personEight.getLinks());


        assertTrue(personEight.toString().contains("links: [</person/2866531f-a229-4325-8e66-f31e6d66a548>;rel=\"self\"]"));
        assertEquals("Addres Test8", personEight.getAddress());
        assertEquals("First Name Test8", personEight.getFirstName());
        assertEquals("Last Name Test8", personEight.getLastName());
        assertEquals("Male", personEight.getGender());
    }

}
