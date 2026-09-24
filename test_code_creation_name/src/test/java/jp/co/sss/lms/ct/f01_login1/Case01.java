package jp.co.sss.lms.ct.f01_login1;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * 結合テスト ログイン機能①
 * ケース01
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース01 ログイン画面への遷移")
public class Case01 {

	/** 前処理 */
	@BeforeAll
	static void before() {
		createDriver();
	}

	/** 後処理 */
	@AfterAll
	static void after() {
		closeDriver();
	}

	@Test
	@Order(1)
	@DisplayName("テスト01 トップページURLでアクセス")
	void test01() {
		// TODO ここに追加
		/**
		 * http://localhost:8080/lmsにアクセスしスクリーンショットを撮影します。
		 * 
		 */
		// 指定のURLの画面を開く
		goTo("http://localhost:8080/lms");
		pageLoadTimeout(20);
		scrollBy("20");

		//Titleの取得とアサーション
		assertEquals("ログイン | LMS", webDriver.getTitle());

		// 開いたページのキャプチャを取得する、evidenceフォルダに保存
		getEvidence(new Object() {
		});
	}
}
