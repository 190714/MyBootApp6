package jp.te4a.spring.boot.myapp7;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookBean {
	Integer id;
	String title;
	String writter;
	String publisher;
	Integer price;
	
	//以下@Dataにより省略
	/*
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	//BookRepositoryのgetid()の部分
	}
	 */
	
}
