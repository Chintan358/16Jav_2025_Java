package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Publication;

public interface PublicationRepo extends JpaRepository<Publication, Integer> {

}
