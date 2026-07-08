package com.lgcreations.controller;

import com.lgcreations.model.Contact;
import com.lgcreations.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public Contact saveContact(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.delete(id);
    }
}