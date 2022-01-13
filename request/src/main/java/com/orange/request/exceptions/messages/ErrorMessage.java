package com.orange.request.exceptions.messages;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ErrorMessage {
    int code;
    Date date;
    String message;
    String description;
}
