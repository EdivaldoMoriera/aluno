package com.moreira.aluno.rest;

import java.net.URI;
import java.util.List;

import com.moreira.aluno.entity.Aluno;
import com.moreira.aluno.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController
@RequestMapping(value = "/alunos")
public class AlunoRest {
    @Autowired
    private AlunoService service;
    @GetMapping
    public ResponseEntity<List<Aluno>> findAll(){
        List<Aluno>list =  service.findAll();
        return ResponseEntity.ok().body(list);

        }
        @RequestMapping(value = "/{id}")
        public ResponseEntity<Aluno> findById(@PathVariable Integer id){
            Aluno aluno = service.findById(id);
            return ResponseEntity.ok().body(aluno);
        }
        @PostMapping
        public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno){
            aluno = service.insert(aluno);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(aluno.getId()).toUri();
            return ResponseEntity.created(uri).body(aluno);

        }
    }
