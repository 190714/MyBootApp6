package jp.te4a.spring.boot.myapp12;

//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class WritterValidator implements ConstraintValidator<WritterValid,String>{

	String ok;
	@Override
	public void initialize(WritterValid nv){  ok = nv.ok(); }
	@Override
	public boolean isValid(String in,ConstraintValidatorContext cxt){
		if(in == null){
			return false;
		}
		System.out.println(in.equals(ok));
		return !in.equals(ok);
	}

}
