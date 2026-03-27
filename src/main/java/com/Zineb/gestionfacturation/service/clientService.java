package com.zineb.gestionfacturation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.zineb.gestionfacturation.entity.Client;
import com.zineb.gestionfacturation.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public Client getById(Long id){
        return clientRepository.findById(id).orElse(null);
    }

    public Client update(Long id, Client client){
        Client c = getById(id);
        if(c != null){
            c.setNom(client.getNom());
            c.setEmail(client.getEmail());
            c.setTelephone(client.getTelephone());
            c.setAdresse(client.getAdresse());
            return clientRepository.save(c);
        }
        return null;
    }

    public void delete(Long id){
        clientRepository.deleteById(id);
    }
}