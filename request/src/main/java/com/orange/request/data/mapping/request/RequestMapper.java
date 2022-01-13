package com.orange.request.data.mapping.request;

import com.orange.request.data.model.Request;
import com.orange.request.representation.request.RequestRepresentation;

public class RequestMapper {

    public static Request fromRequestRepresentation(RequestRepresentation requestRepresentation){
        return Request.builder().number(requestRepresentation.getNumber())
                .description(requestRepresentation.getDescription())
                .status(requestRepresentation.getStatus())
                .username(requestRepresentation.getUsername()).type(requestRepresentation.getType())
                .build();
    }

}
