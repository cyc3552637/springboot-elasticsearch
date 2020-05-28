package com.cyc.springbootes.rest;

import com.cyc.springbootes.model.BookBean;
import com.cyc.springbootes.service.BookService;
import com.cyc.springbootes.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping("/book/{title}")
	@ResponseBody
	public List<BookBean> getBookByTitle(@PathVariable String title){
		Iterable<BookBean> searchResult =bookService.findByTitle(title);
		Iterator<BookBean> iterator = searchResult.iterator();
		List<BookBean> bookbean = new ArrayList<BookBean>();
		while (iterator.hasNext()) {
			bookbean.add(iterator.next());
		}
		return bookbean;
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Result<?> Save(@RequestBody BookBean book){
		Result<?> result=null;
		System.out.println(bookService.save(book));
		if (bookService.save(book)!=null) {
			result=Result.success(null).redirect("/html/user/userList.html");
		}else {
			result=Result.fail("addUser error");
		}
		return result;
	}
	@RequestMapping("/book/findall")
	@ResponseBody
	public  List<BookBean> getBookAll(){
		Page<BookBean> page =bookService.findAll();
		System.out.println(page.getContent());
		return page.getContent();
	}

	@RequestMapping("/book/{page}/{size}/{author}")
	@ResponseBody
	public  List<BookBean> getBookByAuthor(@PathVariable Integer page, @PathVariable Integer size, @PathVariable String author){
		Pageable pageable = new PageRequest(page, size);

 	Page<BookBean> pageauthor =bookService.findByAuthor(author,pageable);

		System.out.println(pageauthor.getContent());
		return pageauthor.getContent();
	}

	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Result<?> delete(@PathVariable String id){
		Result<?> result=null;
		Optional<BookBean> opt =bookService.findById(id);
		if (opt!=null) {
			bookService.delete(opt.get());
			result=Result.success(null).redirect("/html/user/userList.html");
		}else {
			result=Result.fail("deleteUser error");
		}
		return result;

	}

}



