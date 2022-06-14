package jp.te4a.spring.boot.myapp11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBean {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)
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
