package rs.ac.singidunum.world_cup.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "game")
@Getter
@Setter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer gameId;

    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    private Team host;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Team guest;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "time_start", nullable = false)
    private LocalDateTime timeStart;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
