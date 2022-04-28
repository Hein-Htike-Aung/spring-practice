package com.example.module04sessionflow.controller;

import com.example.module04sessionflow.entity.Person;
import com.example.module04sessionflow.entity.PersonCountry;
import com.example.module04sessionflow.entity.PersonName;
import com.example.module04sessionflow.entity.PersonProfession;
import com.example.module04sessionflow.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes({
        "personName", "personProfession", "personCountry"
})
public class PersonController {

    @Autowired
    private PersonService personService;

    @ModelAttribute("personName")
    public PersonName personName() {
        return new PersonName();
    }

    @ModelAttribute("personProfession")
    public PersonProfession personProfession() {
        return new PersonProfession();
    }

    @ModelAttribute("personCountry")
    public PersonCountry personCountry() {
        return new PersonCountry();
    }

    // Find All
    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("people", this.personService.findAll());

        return "index";
    }

    // Person's Name
    @GetMapping("/person/name")
    public String savePersonName(
            @ModelAttribute PersonName personName
    ) {
        return "person-name";
    }

    @PostMapping("/person/name")
    public String savePersonName(
            @Valid PersonName personName,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "person-name";
        } else {
            return "redirect:/person/profession";
        }
    }

    // Person's Profession
    @GetMapping("/person/profession")
    public String saveProfession(
            @ModelAttribute PersonName personName,
            @ModelAttribute PersonProfession personProfession
    ) {
        return "person-profession";
    }

    @PostMapping("/person/profession")
    public String saveProfession(
            @Valid PersonProfession personProfession,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "person-profession";
        } else {
            return "redirect:/person/country";
        }
    }

    // Person's Country
    @GetMapping("/person/country")
    public String saveCountry(
            @ModelAttribute PersonName personName,
            @ModelAttribute PersonProfession personProfession,
            @ModelAttribute PersonCountry personCountry
    ) {
        return "person-country";
    }

    @PostMapping("/person/country")
    public String saveCountry(
            @ModelAttribute PersonName personName,
            @ModelAttribute PersonProfession personProfession,
            @ModelAttribute Person person,
            @Valid PersonCountry personCountry,
            BindingResult bindingResult,
            SessionStatus sessionStatus
    ) {
        if (bindingResult.hasErrors()) {
            return "person-country";
        } else {

            person.setName(personName.getName());
            person.setProfession(personProfession.getProfession());
            person.setCountry(personCountry.getCountry());

            this.personService.save(person);
            sessionStatus.setComplete();

            return "redirect:/";
        }
    }


}
