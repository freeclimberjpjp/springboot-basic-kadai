package com.example.springkadaitodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaitodo.form.ContactForm;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class ContactFormController {
    @GetMapping("form")
    public String showForm(@ModelAttribute("contactForm") ContactForm contactForm, Model model, HttpSession session) {
        // セッションにエラーや入力値があればmodelにセットし、セッションから削除
        Object errors = session.getAttribute("contactFormErrors");
        Object form = session.getAttribute("contactFormData");
        if (errors != null) {
            model.addAttribute("org.springframework.validation.BindingResult.contactForm", errors);
            session.removeAttribute("contactFormErrors");
        }
        if (form != null) {
            model.addAttribute("contactForm", form);
            session.removeAttribute("contactFormData");
        }
        return "contactFormView";
    }

    @PostMapping("form")
    public String submitForm(@Valid @ModelAttribute("contactForm") ContactForm contactForm, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            // 入力値とエラー情報をセッションに保存しリダイレクト
            session.setAttribute("contactFormErrors", bindingResult);
            session.setAttribute("contactFormData", contactForm);
            return "redirect:/form";
        }
        model.addAttribute("contactForm", contactForm);
        return "confirmView";
    }
}