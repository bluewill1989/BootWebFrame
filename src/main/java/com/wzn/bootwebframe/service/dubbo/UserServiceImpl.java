package com.wzn.bootwebframe.service.dubbo;


import com.wzn.api.entity.User;
import com.wzn.api.service.dubbo.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * DESCRIPTION:
 *
 * @author will
 * @create 2018-11-22 15:20
 */
@Path("users")
@Slf4j
public class UserServiceImpl implements UserService {

    @POST
    @Path("register")
    @Consumes({MediaType.APPLICATION_JSON})
    @Override
    public void registerUser(User user) {
        // save the user...
      log.info("this is for user!!");
    }
}