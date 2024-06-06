package com.lab.vo.unittests;


import com.lab.vo.data.model.Person;
import com.lab.vo.data.vo.PersonVO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonVO mockVO() {
        return mockVO(0);
    }

    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 10; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonVO> mockVOList() {
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }

    private Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");
        person.setId(UUID.fromString("2866531f-a229-4325-8e66-f31e6d66a54" + number));
        person.setLastName("Last Name Test" + number);
        return person;
    }

    private PersonVO mockVO(Integer number) {
        PersonVO person = new PersonVO();
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");
        person.setId(UUID.fromString("800be3d8-bd52-4801-9a1e-0a63965ec62" + number));
        person.setLastName("Last Name Test" + number);
        return person;
    }

}
