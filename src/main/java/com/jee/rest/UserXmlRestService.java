package com.jee.rest;

import com.jee.bean.user.UserBean;
import com.jee.model.User;
import com.jee.rest.dto.DtoConverter;
import com.jee.rest.dto.xml.UserDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 14.02.2017.
 */
@Stateless
@Path("/user/xml")
@Produces(MediaType.TEXT_XML)
public class UserXmlRestService {
    @EJB
    private UserBean userBean;

    @Path("/create")
    @PUT
    public UserDto createUser(@FormParam("age") String ageStr, @FormParam("name") String name,
                           @FormParam("lastname") String lastName) throws Exception {
        return DtoConverter.toUserDto(userBean.add(new User(name, lastName, getAge(ageStr))));
    }

    @Path("/list")
    @GET
    public List<UserDto> list() throws Exception {
        List<User> users = userBean.getAll();
        List<UserDto> res = new ArrayList<>();
        for (User user : users) {
            res.add(DtoConverter.toUserDto(user));
        }
        return res;
    }

    @Path("/show/{id}")
    @GET
    public UserDto show(@PathParam("id") long id) {
        User user = userBean.get(id);
        return user != null ? DtoConverter.toUserDto(user) : null;
    }

    @Path("/delete/{id}")
    @DELETE
    public void delete(@PathParam("id") long id) throws Exception {
        userBean.delete(id);
    }

    @Path("/update/{id}")
    @POST
    public UserDto update(@PathParam("id") long id, @FormParam("age") String ageStr,
                       @FormParam("name") String name, @FormParam("lastname") String lastName) throws Exception {
        User user = userBean.get(id);
        user.setAge(getAge(ageStr));
        user.setName(name);
        user.setLastName(lastName);
        return DtoConverter.toUserDto(userBean.update(user));
    }

    private int getAge(String ageStr) {
        int age;
        try {
            age = Integer.valueOf(ageStr);
        } catch (Exception e) {
            age = 0;
        }
        return age;
    }
}
