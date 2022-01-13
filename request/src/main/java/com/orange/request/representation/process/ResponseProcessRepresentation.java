package com.orange.request.representation.process;

import com.orange.request.enums.RequestStatusEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseProcessRepresentation {
    String process;
    RequestStatusEnum status;
}
