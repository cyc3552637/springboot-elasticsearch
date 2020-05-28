package com.cyc.springbootes.service;


import com.cyc.springbootes.model.BookBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.List;
import java.util.Optional;

public interface BookService {

	Optional<BookBean> findById(String id);

	BookBean save(BookBean blog);

	void delete(BookBean blog);

	Optional<BookBean> findOne(String id);

	Page<BookBean> findAll();

	Page<BookBean> findByAuthor(String author,Pageable pageable);

	Iterable<BookBean> findByTitle(String title);
}




