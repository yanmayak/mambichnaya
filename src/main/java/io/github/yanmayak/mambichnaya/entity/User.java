package io.github.yanmayak.mambichnaya.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "reason")
    private String reason;
}
