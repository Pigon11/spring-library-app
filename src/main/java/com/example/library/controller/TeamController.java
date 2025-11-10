package com.example.library.controller;

import com.example.library.model.Team;
import com.example.library.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    // Показать список всех команд
    @GetMapping
    public String listTeams(Model model) {
        List<Team> teams = teamService.findAll();
        model.addAttribute("teams", teams);
        return "teams/list";
    }

    // Форма для создания новой команды
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("team", new Team());
        return "teams/form";
    }

    // Сохранение команды
    @PostMapping("/save")
    public String saveTeam(@ModelAttribute("team") Team team) {
        teamService.save(team);
        return "redirect:/teams";
    }

    // Форма для редактирования команды
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Team team = teamService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Неверный ID команды: " + id));
        model.addAttribute("team", team);
        return "teams/form";
    }

    // Удаление команды
    @GetMapping("/delete/{id}")
    public String deleteTeam(@PathVariable Long id) {
        teamService.deleteById(id);
        return "redirect:/teams";
    }
}