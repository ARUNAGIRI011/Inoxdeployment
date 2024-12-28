package com.example.Inox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Inox.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {}

