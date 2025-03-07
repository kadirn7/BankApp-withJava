package com.banking.core.crossCuttingConcerns.exceptions.httpProblemDetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDetails {
    private String title;
    private String type;
    private String detail;
    private int status;
    private String instance;
    
    @JsonFormat(pattern = "HH:mm dd.MM.yyyy")
    private LocalDateTime timestamp = LocalDateTime.now();
} 