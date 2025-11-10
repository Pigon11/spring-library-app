package com.example.library.controller;

import com.example.library.model.Player;
import com.example.library.model.Team;
import com.example.library.service.PlayerService;
import com.example.library.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    // Показать список всех игроков
    @GetMapping
    public String listPlayers(Model model) {
        List<Player> players = playerService.findAll();
        model.addAttribute("players", players);
        return "players/list";
    }

    // Форма для создания нового игрока
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        Player player = new Player();
        List<Team> teams = teamService.findAll();
        model.addAttribute("player", player);
        model.addAttribute("teams", teams);
        return "players/form";
    }

    // Сохранение игрока
    @PostMapping("/save")
    public String savePlayer(@ModelAttribute("player") Player player) {
        playerService.save(player);
        return "redirect:/players";
    }

    // Форма для редактирования игрока
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Player player = playerService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Неверный ID игрока: " + id));
        List<Team> teams = teamService.findAll();
        model.addAttribute("player", player);
        model.addAttribute("teams", teams);
        return "players/form";
    }

    // Удаление игрока
    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deleteById(id);
        return "redirect:/players";
    }
}