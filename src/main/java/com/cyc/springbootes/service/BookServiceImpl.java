package com.cyc.springbootes.service;


import com.cyc.springbootes.model.BookBean;
import com.cyc.springbootes.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	@Qualifier("bookRepository")
	private BookRepository bookRepository;


	@Override
	public Optional<BookBean> findById(String id) {
		//CrudRepository中的方法
		return bookRepository.findById(id);
	}

	@Override
	public BookBean save(BookBean blog) {
		return bookRepository.save(blog);
	}

	@Override
	public void delete(BookBean blog) {
		bookRepository.delete(blog);
	}

	@Override
	public Optional<BookBean> findOne(String id) {
		return bookRepository.findById(id);
	}

	@Override
	public  Page<BookBean> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Page<BookBean> findByAuthor(String author,Pageable pageable) {
		return bookRepository.findByAuthor(author,pageable);
	}

	@Override
	public Iterable<BookBean> findByTitle(String title) {
		return bookRepository.findByTitle(title);
	}
}


