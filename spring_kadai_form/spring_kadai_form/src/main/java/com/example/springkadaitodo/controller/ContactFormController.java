package com.example.springkadaitodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springkadaitodo.form.ContactForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class ContactFormController {
    @GetMapping("form")
    public String showForm(@ModelAttribute("contactForm") ContactForm contactForm) {
        return "contactFormView";
    }

    @PostMapping("form")
    public String submitForm(@Valid @ModelAttribute("contactForm") ContactForm contactForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "contactFormView";
        }
        model.addAttribute("contactForm", contactForm);
        return "confirmView";
    }
}