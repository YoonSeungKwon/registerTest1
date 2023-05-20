package com.ex230519.board.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Column(nullable = false, length=50)
    private String name;
    @Column(nullable = false, length=50)
    private String id;
    @Column(nullable = false, length=50)
    private String password;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime regdate;
}
