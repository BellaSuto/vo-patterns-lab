package com.lab.vo.unittests;

import com.lab.vo.converter.DozerConverter;
import com.lab.vo.data.model.Person;
import com.lab.vo.data.vo.v1.PersonVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

public class DozerConverterTest {

    MockPerson inputObject;

    @Before
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
        Assert.assertEquals(UUID.fromString("2866531f-a229-4325-8e66-f31e6d66a54" + 0), output.getKey());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
        Assert.assertEquals("Addres Test0", output.getAddress());
        Assert.assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
        PersonVO outputZero = outputList.get(0);

        Assert.assertEquals(UUID.fromString("2866531f-a229-4325-8e66-f31e6d66a54" + 0), outputZero.getKey());
        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputZero.getLastName());
        Assert.assertEquals("Addres Test0", outputZero.getAddress());
        Assert.assertEquals("Male", outputZero.getGender());

        PersonVO outputSeven = outputList.get(7);

        Assert.assertEquals(UUID.fromString("2866531f-a229-4325-8e66-f31e6d66a54" + 7), outputSeven.getKey());
        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
        Assert.assertEquals("Female", outputSeven.getGender());

        PersonVO outputNine = outputList.get(9);

        Assert.assertEquals(UUID.fromString("2866531f-a229-4325-8e66-f31e6d66a54" + 9), outputNine.getKey());
        Assert.assertEquals("First Name Test9", outputNine.getFirstName());
        Assert.assertEquals("Last Name Test9", outputNine.getLastName());
        Assert.assertEquals("Addres Test9", outputNine.getAddress());
        Assert.assertEquals("Female", outputNine.getGender());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);
        Assert.assertEquals(UUID.fromString("800be3d8-bd52-4801-9a1e-0a63965ec62" + 0), output.getId());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
        Assert.assertEquals("Addres Test0", output.getAddress());
        Assert.assertEquals("Male", output.getGender());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);

        Assert.assertEquals(UUID.fromString("800be3d8-bd52-4801-9a1e-0a63965ec62" + 0), outputZero.getId());
        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputZero.getLastName());
        Assert.assertEquals("Addres Test0", outputZero.getAddress());
        Assert.assertEquals("Male", outputZero.getGender());

        Person outputSeven = outputList.get(7);

        Assert.assertEquals(UUID.fromString("800be3d8-bd52-4801-9a1e-0a63965ec62" + 7), outputSeven.getId());
        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
        Assert.assertEquals("Female", outputSeven.getGender());

        Person outputNine = outputList.get(9);

        Assert.assertEquals(UUID.fromString("800be3d8-bd52-4801-9a1e-0a63965ec62" + 9), outputNine.getId());
        Assert.assertEquals("First Name Test9", outputNine.getFirstName());
        Assert.assertEquals("Last Name Test9", outputNine.getLastName());
        Assert.assertEquals("Addres Test9", outputNine.getAddress());
        Assert.assertEquals("Female", outputNine.getGender());
    }
}

