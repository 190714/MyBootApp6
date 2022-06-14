package jp.te4a.spring.boot.myapp11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
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
@Constraint(validatedBy = TestValidator.class)
//アノテーション適用要素の指定(今回はメソッド宣言、フィールド宣言）
@Target({ElementType.METHOD,ElementType.FIELD})
//コンパイル後にアノテーション情報を残すか否か（今回は実行時も読み込める）
@Retention(RetentionPolicy.RUNTIME)

public @interface TestValid {
	String param();
	String message() default "input other than {param}.";
	// Classオブジェクトを得る（戻り値とする）メソッドgroups()
	// デフォルト値は空のクラス
	Class<?>[] groups() default {};
	// Payloadクラスを継承したClassオブジェクトを得る
	// （戻り値とする）メソッドpayload()、デフォルト値は空のクラス
	Class<? extends Payload>[] payload() default{};
	/*
	 特に問題ない限り、バリデート用アノテーションは以下３点のみ独自記述
	(1)インタフェース名（バリデートのアノテーション名と同じ）
	(2)messageメソッドのdefault値（エラーメッセージ）
	(3)param()メソッド（アノテーションのパラメタ名）
	上記の例では、「@TestValid(param=“abc”)」のようにバリデートする
	 */
}

/*

//javadoc生成時のリンク作成
@Documented
//エラーチェッククラス（Validator)指定
@Constraint(validatedBy = TestValidator.class)
//アノテーション適用要素の指定(今回はメソッド宣言、フィールド宣言）
@Target({ElementType.METHOD,ElementType.FIELD})
//コンパイル後にアノテーション情報を残すか否か（今回は実行時も読み込める）
@Retention(RetentionPolicy.RUNTIME)

 */