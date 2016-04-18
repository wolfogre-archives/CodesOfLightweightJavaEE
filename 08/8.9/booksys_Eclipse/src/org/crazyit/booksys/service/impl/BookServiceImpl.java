package org.crazyit.booksys.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.crazyit.booksys.dao.BookDao;
import org.crazyit.booksys.domain.Book;
import org.crazyit.booksys.service.BookService;
/**
 * Description:
 * <br/>利嫋: <a href="http://www.crazyit.org">決髄Java選男</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@Transactional
public class BookServiceImpl implements BookService
{
	private BookDao bookDao;
	
	public void setBookDao(BookDao bookDao)
	{
		this.bookDao = bookDao;
	}
	@Override
	public void addBook(Book book)
	{
		bookDao.save(book);
	}

	@Override
	public List<Book> getAllBooks()
	{
		return bookDao.findAll(Book.class);
	}
	@Override
	public void deleteBook(int id)
	{
		bookDao.delete(Book.class, id);
	}
}
