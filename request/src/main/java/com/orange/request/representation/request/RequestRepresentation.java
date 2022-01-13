package com.orange.request.representation.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestRepresentation {
    Long number;
    String type;
    String description;
    String status;
    String username;
}
