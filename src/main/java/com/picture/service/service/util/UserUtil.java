package com.picture.service.service.util;

import com.picture.service.dto.AuthResponseDTO;
import com.picture.service.exception.cust.exeption.UnAuthorizedException;

import java.util.Objects;

public class UserUtil {


    public static final String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public static final String ADMIN = "admin";

    public static void isAdminUser() {

        AuthResponseDTO authResponseDTO = StaticContextAccessor.getBean(SessionData.class).getAuthResponseDTO();

        if (Objects.isNull(authResponseDTO))
            throw new UnAuthorizedException("you have to login ,,,");

        else if (!Objects.equals(authResponseDTO.getUserName(), ADMIN))
            throw new UnAuthorizedException("not admin ,,,");

    }

}
