package com.emploi.gestion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.emploi.gestion.dto.ClasseDTO;
import com.emploi.gestion.services.ClasseService;

@Controller
@RequestMapping("/classes")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @GetMapping("")
    public String listClasses(Model model) {
        try {
            model.addAttribute("classes", classeService.getAllClasses());
            return "class/list";
        } catch (Exception e) {
            // Handle the exception appropriately, e.g., log it
            model.addAttribute("error", "Error fetching class list");
            return "error";
        }
    }

    @GetMapping("/{id}")
    public String viewClass(@PathVariable Long id, Model model) {
        try {
            ClasseDTO classeDTO = classeService.getClassById(id);
            model.addAttribute("classe", classeDTO);
            return "class/view";
        } catch (Exception e) {
            // Handle the exception appropriately, e.g., log it
            model.addAttribute("error", "Error fetching class details");
            return "error";
        }
    }

    @GetMapping("/new")
    public String createClassForm(Model model) {
        try {
            model.addAttribute("classe", new ClasseDTO());
            return "class/new";
        } catch (Exception e) {
            // Handle the exception appropriately, e.g., log it
            model.addAttribute("error", "Error creating class form");
            return "error";
        }
    }

    @PostMapping("/new")
    public String createClass(@ModelAttribute("classe") ClasseDTO classeDTO, Model model) {
        try {
            classeService.saveClass(classeDTO);
            return "redirect:/classes";
        } catch (Exception e) {
            // Handle the exception appropriately, e.g., log it
            model.addAttribute("error", "Error saving class");
            return "error";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteClass(@PathVariable Long id, Model model) {
        try {
            classeService.deleteClass(id);
            return "redirect:/classes";
        } catch (Exception e) {
            // Handle the exception appropriately, e.g., log it
            model.addAttribute("error", "Error deleting class");
            return "error";
        }
    }
}
