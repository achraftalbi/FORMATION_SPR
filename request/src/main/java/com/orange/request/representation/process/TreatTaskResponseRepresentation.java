package com.orange.request.representation.process;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TreatTaskResponseRepresentation {
    String taskId;
    String businessKey;
    boolean taskCompleted;
}
