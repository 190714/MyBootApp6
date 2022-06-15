package jp.te4a.spring.boot.myapp12;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class BookForm {
	@NotNull
	private Integer id ;
	
	@NotNull
	@Size(min = 3)
	@TestValid(param = "abc")
	private String title;
	
	@NotNull
	@Size(min = 3, max = 20)
	@WritterValid(ok ="東北タロウ")
	private String writter;
	
	@NotNull
	private String publisher;
	
	@NotNull
	@Min(0)
	private Integer price;

}
