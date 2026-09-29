package jp.co.sss.lms.ct.f02_faq;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
 * 結合テスト よくある質問機能
 * ケース05
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース05 キーワード検索 正常系")
public class Case05 {

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
	@DisplayName("テスト03 上部メニューの「ヘルプ」リンクからヘルプ画面に遷移")
	void test03() {
		// TODO ここに追加
		// 上部メニューの「ヘルプ」リンクをクリック（機能をクリックさせて表示）
		WebElement classElement = webDriver.findElement(By.className("dropdown-toggle"));
		classElement.click();
		// 開いたページのキャプチャを取得する、evidenceフォルダに保存
		getEvidence(new Object() {
		}, "before");
		WebElement linkTextElement = webDriver.findElement(By.partialLinkText("ヘルプ"));
		linkTextElement.click();
		//Titleの取得とアサーション
		assertEquals("ヘルプ | LMS", webDriver.getTitle());
		// 開いたページのキャプチャを取得する、evidenceフォルダに保存
		getEvidence(new Object() {
		}, "after");
	}

	@Test
	@Order(4)
	@DisplayName("テスト04 「よくある質問」リンクからよくある質問画面を別タブに開く")
	void test04() {
		// TODO ここに追加
		// 「よくある質問」リンクをクリック
		WebElement classElement = webDriver.findElement(By.linkText("よくある質問"));
		classElement.click();
		// 「よくある質問」の方のタブに移動
		List<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
		webDriver.switchTo().window(tabs.get(tabs.size() - 1));
		pageLoadTimeout(120);
		//Titleの取得とアサーション
		assertEquals("よくある質問 | LMS", webDriver.getTitle());
		// 開いたページのキャプチャを取得する、evidenceフォルダに保存
		getEvidence(new Object() {
		});
	}

	@Test
	@Order(5)
	@DisplayName("テスト05 キーワード検索で該当キーワードを含む検索結果だけ表示")
	void test05() {
		// TODO ここに追加
		// 該当キーワードを入力し検索をクリック
		WebElement formElement = webDriver.findElement(By.id("form"));
		formElement.clear(); // 初期値をクリア
		formElement.sendKeys("キャンセル");
		WebElement submitElement = webDriver.findElement(By.cssSelector("input[value='検索']"));
		submitElement.click();
		//検索結果のアサーション
		WebElement faqElement = webDriver.findElement(By.className("mb10"));
		scrollBy("100");
		pageLoadTimeout(120);
		assertEquals("Q.キャンセル料・途中退校について", faqElement.getText());
		//下までスクロール
		scrollBy("300");
		// 開いたページのキャプチャを取得する、evidenceフォルダに保存
		getEvidence(new Object() {
		});
	}

	@Test
	@Order(6)
	@DisplayName("テスト06 「クリア」ボタン押下で入力したキーワードを消去")
	void test06() {
		// TODO ここに追加
		//上までスクロール
		scrollBy("-300");
		//クリアをクリック
		WebElement inputElement = webDriver.findElement(By.cssSelector("input[value='クリア']"));
		inputElement.click();
		//入力欄のアサーション
		WebElement formElement = webDriver.findElement(By.id("form"));
		assertEquals("", formElement.getText());
		// 開いたページのキャプチャを取得する、evidenceフォルダに保存
		getEvidence(new Object() {
		});
	}

}
