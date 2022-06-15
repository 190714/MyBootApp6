package jp.te4a.spring.boot.myapp12;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

//javadoc生成時のリンク作成
@Documented
//エラーチェッククラス（Validator)指定
@Constraint(validatedBy = WritterValidator.class)
//アノテーション適用要素の指定(今回はメソッド宣言、フィールド宣言）
@Target({ElementType.METHOD,ElementType.FIELD})
//コンパイル後にアノテーション情報を残すか否か（今回は実行時も読み込める）
@Retention(RetentionPolicy.RUNTIME)

public @interface WritterValid {
	String ok();
	String message() default "input {ok}.";
	
	// Classオブジェクトを得る（戻り値とする）メソッドgroups()
	// デフォルト値は空のクラス
	Class<?>[] groups() default {};
	
	// Payloadクラスを継承したClassオブジェクトを得る
	// （戻り値とする）メソッドpayload()、デフォルト値は空のクラス
	Class<? extends Payload>[] payload() default{};
	
}
