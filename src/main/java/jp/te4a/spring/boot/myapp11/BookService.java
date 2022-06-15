package jp.te4a.spring.boot.myapp11;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;

	//作成		
	public BookForm create(BookForm bookForm) {
		BookBean bookBean = new BookBean();
		BeanUtils.copyProperties(bookForm, bookBean);
		bookRepository.save(bookBean);
		return bookForm;
	}
	
	//更新
	public BookForm update(BookForm bookForm) {
		BookBean bookBean = new BookBean();
		BeanUtils.copyProperties(bookForm, bookBean);
		bookRepository.save(bookBean);
		return bookForm;
	}
	
	//削除
	public void delete(Integer id) {

		BookBean bean = new BookBean();
		bean.setId(id);
		bookRepository.delete(bean);

	}

	/*
	 * @Autowiredはnewを省略する
	public static void example{	
		
	String name = new String();
		Student taro = new Student();
		taro.getName();
		taro.setName(name);
		}
		
	class Student {
		String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	 */

	//public void delete(Integer id) { bookRepository.delete(id); }

	//findは取得1件と全件
	public List<BookForm> findAll() {
		List<BookBean> beanList = bookRepository.findAll();
		List<BookForm> formList = new ArrayList<BookForm>();
		for(BookBean bookBean: beanList) {
			BookForm bookForm = new BookForm();
			BeanUtils.copyProperties(bookBean, bookForm);
			formList.add(bookForm);
		}
		return formList;
	}
	
	//repositoryのデータを取り出す
	public BookForm findById(Integer id) {			
				
		//BookForm bookBean = bookRepository.findById(id);
		Optional<BookBean> bookBean = bookRepository.findById(id);
		
		//ラムダ関数
		Optional<BookBean> opt =  bookRepository.findById(id);
		opt.ifPresent(book -> {
		// bookを使った処理
		});
		
		BookForm bookForm = new BookForm();
		BeanUtils.copyProperties(bookBean, bookForm);
		return bookForm;
	}
	
}
	/*
	 	public BookForm findOne(Integer id) {
		BookBean bookBean = bookRepository.findOne(id);
		BookForm bookForm = new BookForm();
		BeanUtils.copyProperties(bookBean, bookForm);
		return bookForm;
	 */



