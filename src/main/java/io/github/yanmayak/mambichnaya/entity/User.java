package io.github.yanmayak.mambichnaya.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "reason")
    private String reason;

    @Column(name = "date_banned")
    private LocalDateTime dateBanned;
}

