package jp.co.sss.lms.ct.f01_login1;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

/**
 * 結合テスト ログイン機能①
 * ケース03
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース03 受講生 ログイン 正常系")
public class Case03 {

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

		// 開いたページのキャプチャを取得する
		File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

		//evidenceフォルダに保存
		try {
			Files.copy(file.toPath(), Paths.get("./evidence/sampleCase03.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(2)
	@DisplayName("テスト02 初回ログイン済みの受講生ユーザーでログイン")
	void test02() {
		// TODO ここに追加
		/**
		 * 初回ログイン済みの受講生ユーザーでログインしスクリーンショットを撮影します。（ログインボタン押下前と押下後で2枚）
		 * 
		 */
		// 指定のURLの画面を開く
		goTo("http://localhost:8080/lms");
		pageLoadTimeout(20);
		scrollBy("20");

		//Titleの取得とアサーション
		assertEquals("ログイン | LMS", webDriver.getTitle());

		// --- ここからロケータのテスト ---
		WebElement idElement = webDriver.findElement(By.id("loginId"));
		idElement.clear(); // 初期値をクリア
		idElement.sendKeys("abc123");

		WebElement pwElement = webDriver.findElement(By.id("password"));
		pwElement.clear(); // 初期値をクリア
		pwElement.sendKeys("abc123");

		// 開いたページのキャプチャを取得する
		File file1 = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

		//evidenceフォルダに保存
		try {
			Files.copy(file1.toPath(), Paths.get("./evidence/sampleCase03Test02before.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ログインボタンをクリック
		WebElement classElement = webDriver.findElement(By.className("btn-primary"));
		assertEquals("ログイン", classElement.getAttribute("value"), "クラス名で指定したボタンのテキストが正しいこと");
		classElement.click();

		// 開いたページのキャプチャを取得する
		File file2 = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

		//evidenceフォルダに保存
		try {
			Files.copy(file2.toPath(), Paths.get("./evidence/sampleCase03Test02after.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
