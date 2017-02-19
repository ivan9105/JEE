package com.jee.integration.portal;

import com.jee.rest.dto.xml.UserDto;
import junit.framework.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Иван on 14.02.2017.
 */
public class UserXmlRestServiceTest extends PortalTestSupport {
    @Test
    public void doWork() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("age", "1");
        params.put("name", "TestName");
        params.put("lastname", "TestLastName");
        String create = doPut("http://localhost:8080/JEE/rest/user/xml/create", params);
        UserDto dto = convertToDto(create);

        params.clear();
        params.put("age", "11");
        params.put("name", "2TestName");
        params.put("lastname", "TestLastName");
        String update = doPost("http://localhost:8080/JEE/rest/user/xml/update/" + dto.getId(), params);
        dto = convertToDto(update);

        String show = doGet("http://localhost:8080/JEE/rest/user/xml/show/" + dto.getId());
        dto = convertToDto(show);

        Assert.assertEquals(dto.getAge(), 11);
        Assert.assertEquals(dto.getName(), "2TestName");
        Assert.assertEquals(dto.getLastname(), "TestLastName");

        doDelete("http://localhost:8080/JEE/rest/user/xml/delete/" + dto.getId());

        show = doGet("http://localhost:8080/JEE/rest/user/xml/show/" + dto.getId());
        Assert.assertEquals("", show);
    }

    private UserDto convertToDto(String put) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(UserDto.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (UserDto) jaxbUnmarshaller.unmarshal(new StringReader(put));
    }
}
