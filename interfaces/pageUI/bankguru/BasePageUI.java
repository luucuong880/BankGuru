package pageUI.bankguru;

public class BasePageUI {
	public static final String FIELD_BOX = "xpath=//input[@name='%s']";
	public static final String BODY = "xpath=//td/table";
	public static final String PRODUCT_SIZE = "xpath=//h2[@class='product-title']//a";
	public static final String PRODUCT_PRICE = "xpath=//span[@class='price actual-price']";
	public static final String PAGES_AT_SUB_MENU = "xpath=//a[text()='%s']";
	public static final String DISMISS_BUTTON = "css=[class*='btn skip']>div>svg>path:nth-of-type(1)";
	public static final String SUBMIT_BUTTON = "xpath=//input[@type='submit']";
}
