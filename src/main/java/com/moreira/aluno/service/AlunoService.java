package com.moreira.aluno.service;

import java.util.List;
import java.util.Optional;

import com.moreira.aluno.entity.Aluno;
import com.moreira.aluno.repository.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;
    public List<Aluno> findAll(){
        return repository.findAll();
    }
    public Aluno findById(Integer id){
        Optional<Aluno> aluno = repository.findById(id);
        return aluno.get();
    }
    /*para inserir aluno */
    public Aluno insert(Aluno aluno){
        return repository.save(aluno);

    }
    
}
