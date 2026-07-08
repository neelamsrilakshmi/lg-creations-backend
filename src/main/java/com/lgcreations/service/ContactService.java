package com.lgcreations.service;

import com.lgcreations.model.Contact;
import com.lgcreations.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    // Save Contact
    public Contact save(Contact contact) {

        contact.setStatus("New");

        return repository.save(contact);
    }

    // Get All Contacts
    public List<Contact> getAll() {
        return repository.findAll();
    }

    // Delete Contact
    public void delete(Long id) {
        repository.deleteById(id);
    }
}