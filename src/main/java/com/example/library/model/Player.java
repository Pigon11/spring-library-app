package com.example.library.model;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String position;
    private Integer jerseyNumber;

    // Связь с командой - многие игроки принадлежат одной команде
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    // Конструкторы
    public Player() {}

    public Player(String name, String position, Integer jerseyNumber, Team team) {
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.team = team;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public Integer getJerseyNumber() { return jerseyNumber; }
    public void setJerseyNumber(Integer jerseyNumber) { this.jerseyNumber = jerseyNumber; }

    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", jerseyNumber=" + jerseyNumber +
                ", team=" + (team != null ? team.getName() : "null") +
                '}';
    }
}