package com.learning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class BaseResponse {
    boolean status;
    String message;
}
