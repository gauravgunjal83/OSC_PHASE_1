package com.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSessionDto {

    private String userId;
    private String sessionId;
    private String loginDevice;
}
