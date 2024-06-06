package com.lab.vo.services;

import com.lab.vo.converter.DozerConverter;
import com.lab.vo.data.model.Person;
import com.lab.vo.data.vo.v1.PersonVO;
import com.lab.vo.data.vo.v2.PersonVOV2;
import com.lab.vo.mapper.custom.PersonMapper;
import com.lab.vo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonMapper personMapper;

    public PersonVO create(PersonVO person) {
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public List<PersonVO> findAll() {
        return DozerConverter.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(UUID id) {

        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        var entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(UUID id) {
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        personRepository.delete(entity);
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        var entity = personMapper.converVoTotEntity(person);
        var vo = personMapper.convertEntityToVo(personRepository.save(entity));
        return vo;
    }
}
