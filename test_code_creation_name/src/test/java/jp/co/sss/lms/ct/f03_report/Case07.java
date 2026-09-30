package jp.co.sss.lms.ct.f03_report;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 結合テスト レポート機能
 * ケース07
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース07 受講生 レポート新規登録(日報) 正常系")
public class Case07 {

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

	@Test
	@Order(2)
	@DisplayName("テスト02 初回ログイン済みの受講生ユーザーでログイン")
	void test02() {
		// TODO ここに追加
		/**
		 * 初回ログイン済みの受講生ユーザーでログインしスクリーンショットを撮影します。（ログインボタン押下前と押下後で2枚）
		 * 
		 */
		// 初回ログイン済みの受講生ユーザーを入力
		WebElement idElement = webDriver.findElement(By.id("loginId"));
		idElement.clear(); // 初期値をクリア
		idElement.sendKeys("StudentAA03");

		WebElement pwElement = webDriver.findElement(By.id("password"));
		pwElement.clear(); // 初期値をクリア
		pwElement.sendKeys("Student4321");

		// 開いたページのキャプチャを取得する、evidenceフォルダに保存
		getEvidence(new Object() {
		}, "before");

		// ログインボタンをクリック
		WebElement classElement = webDriver.findElement(By.className("btn-primary"));
		classElement.click();
		pageLoadTimeout(100);
		//Titleの取得とアサーション
		assertEquals("コース詳細 | LMS", webDriver.getTitle());
		// 開いたページのキャプチャを取得する、evidenceフォルダに保存
		getEvidence(new Object() {
		}, "after");
	}

	@Test
	@Order(3)
	@DisplayName("テスト03 未提出の研修日の「詳細」ボタンを押下しセクション詳細画面に遷移")
	void test03() {
		// TODO ここに追加
		// 「詳細」ボタンをクリック
		WebElement detailButton = webDriver
				.findElement(By.xpath("//span[text()='未提出']/ancestor::tr//input[@value='詳細']"));
		// 開いたページのキャプチャを取得する、evidenceフォルダに保存
		getEvidence(new Object() {
		}, "before");
		detailButton.click();
		pageLoadTimeout(100);
		// Titleの取得とアサーション
		assertEquals("セクション詳細 | LMS", webDriver.getTitle());
		// 開いたページのキャプチャを取得する、evidenceフォルダに保存
		getEvidence(new Object() {
		}, "after");
	}

	@Test
	@Order(4)
	@DisplayName("テスト04 「提出する」ボタンを押下しレポート登録画面に遷移")
	void test04() {
		// TODO ここに追加
		// 「提出する」ボタンを取得
		WebElement submitButton = webDriver.findElement(
				By.xpath("//input[contains(@value,'を提出する')]"));
		// 提出するボタンをクリック
		submitButton.click();
		pageLoadTimeout(100);
		// Titleの取得とアサーション
		assertEquals("レポート登録 | LMS", webDriver.getTitle());
		// 開いたページのキャプチャを取得する、evidenceフォルダに保存
		getEvidence(new Object() {
		});
	}

	@Test
	@Order(5)
	@DisplayName("テスト05 報告内容を入力して「提出する」ボタンを押下し確認ボタン名が更新される")
	void test05() {
		// TODO ここに追加
		// 報告内容を入力
		WebElement contentElement = webDriver.findElement(
				By.id("content_0"));
		contentElement.clear();// 初期値をクリア
		contentElement.sendKeys("本日の研修では、Javaについて学習しました。");
		// 「提出する」ボタンをクリック
		WebElement submitButton = webDriver.findElement(
				By.xpath("//button[text()='提出する']"));
		submitButton.click();
		pageLoadTimeout(100);
		// Titleの取得とアサーション
		assertEquals("レポート確認 | LMS", webDriver.getTitle());
		// 開いたページのキャプチャを取得する、evidenceフォルダに保存
		getEvidence(new Object() {
		});

	}

}
