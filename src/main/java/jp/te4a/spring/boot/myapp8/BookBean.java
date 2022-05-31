package jp.te4a.spring.boot.myapp8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBean {
	private Integer id;
	private String title;
	private String writter;
	private String publisher;
	private Integer price;
	
	//以下@Dataにより省略
	/*
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	//BookRepositoryのgetid()の部分
	}
	 */
	
}
