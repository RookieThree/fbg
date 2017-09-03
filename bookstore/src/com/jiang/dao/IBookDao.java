package com.jiang.dao;

import java.util.List;

import com.jiang.domain.PageBean;
import com.jiang.entity.BookBean;

public interface IBookDao {

	List<BookBean> getByPage(BookBean book,PageBean pages)throws Exception;

	BookBean load(Long id) throws Exception;

}
