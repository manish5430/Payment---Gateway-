package com.flavio.spring_mc.services;

import com.flavio.spring_mc.entities.models.Client;
import com.flavio.spring_mc.repository.ClientRepository;
import com.flavio.spring_mc.services.exceptions.ObjectNotFoundExcepetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;


    public Client findById(Integer id){
        Optional<Client> catOpt = clientRepository.findById(id);
        return catOpt.orElseThrow(() -> new ObjectNotFoundExcepetion("Object not found"));
    }

}
