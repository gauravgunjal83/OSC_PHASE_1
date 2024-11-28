package com.in.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "session_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionEntity {


    @Id
    private String sessionId;

    private String userId;

    private String loginDevice;

    private LocalDateTime loginTime;

    private LocalDateTime logoutTime;


}
