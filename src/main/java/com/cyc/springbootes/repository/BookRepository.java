package com.cyc.springbootes.repository;


import com.cyc.springbootes.model.BookBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

/**
 * 接口关系：
 * ElasticsearchRepository --> ElasticsearchCrudRepository --> PagingAndSortingRepository --> CrudRepository
 */
public interface BookRepository extends ElasticsearchRepository<BookBean, String> {

    Optional<BookBean> findById(String id);

    Page<BookBean> findByAuthor(String author,Pageable pageable);

    Iterable<BookBean> findByTitle(String title);

    Page<BookBean> findAll();

    BookBean save(BookBean blog);

    void delete(BookBean blog);

//    Page<BookBean> findByAuthor(SearchQuery searchQuery);
}

