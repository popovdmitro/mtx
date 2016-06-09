package com.miratech.interfaces;

import com.miratech.dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
public interface UserService {

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON})
    List<UserDTO> list();

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    void add(UserDTO user);

}
