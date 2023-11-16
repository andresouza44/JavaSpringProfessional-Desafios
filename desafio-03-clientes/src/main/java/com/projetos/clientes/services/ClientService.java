package com.projetos.clientes.services;

import com.projetos.clientes.dto.ClientDTO;
import com.projetos.clientes.entities.Client;
import com.projetos.clientes.repository.ClientRepository;
import com.projetos.clientes.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> result = repository.findAll(pageable);
        return result.map((e) -> new ClientDTO(e));
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Resource not found with id " + id));
        return new ClientDTO(client);

    }

    @Transactional
    public ClientDTO save(ClientDTO dto){
        Client entity = new Client();
        copyDtoToEntity(dto,entity);
        repository.save(entity);
        return new ClientDTO(entity);

    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){
        try {
            Client entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return new ClientDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw  new ResourceNotFoundException("Resource not found with id " + id);
        }
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete (Long id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found with id " + id);
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Data Integrity Violation Excpetion");
        }
    }
    private void copyDtoToEntity(ClientDTO dto, Client entity){
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());

    }

}
