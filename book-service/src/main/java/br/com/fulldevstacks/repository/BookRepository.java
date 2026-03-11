package br.com.fulldevstacks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fulldevstacks.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}
