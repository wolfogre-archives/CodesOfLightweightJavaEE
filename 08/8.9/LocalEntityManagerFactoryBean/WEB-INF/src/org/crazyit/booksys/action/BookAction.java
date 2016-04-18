package org.crazyit.booksys.action;

import java.util.List;

import org.crazyit.booksys.domain.Book;
import org.crazyit.booksys.service.BookService;

import com.opensymphony.xwork2.ActionSupport;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class BookAction extends ActionSupport
{
	private BookService bookService;
	// 依赖注入BookService组件必须的setter方法。
	// 该方法的方法名要与BookService的配置id对应
	public void setBookService(BookService bookService)
	{
		this.bookService = bookService;
	}
	private Book book;
	private List<Book> books;
	private int id;
	public Book getBook()
	{
		return book;
	}
	public void setBook(Book book)
	{
		this.book = book;
	}
	
	public List<Book> getBooks()
	{
		return books;
	}
	public void setBooks(List<Book> books)
	{
		this.books = books;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	// 处理添加图书的add()方法
	public String add()
	{
		System.out.println(bookService.getClass());
		// 调用业务逻辑组件的addBook()方法来处理用户请求		
		bookService.addBook(book);
		int result = book.getId();
		if(result > 0)
		{
			addActionMessage("恭喜您，图书添加成功！");
			return SUCCESS;
		}
		addActionError("图书添加失败，请重新输入！");
		return ERROR;
	}
	public String list()
	{
		setBooks(bookService.getAllBooks());
		return SUCCESS;
	}
	public String delete()
	{
		System.out.println(bookService.getClass());	
		bookService.deleteBook(id);
		return SUCCESS;
	}	
}
