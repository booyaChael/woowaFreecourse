package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class VendingInventory {
	private Map<Product, Integer> products;

	public VendingInventory(String input){
		this.products = makeStringIntoProducts(input);
	}

	public Map<Product, Integer> makeStringIntoProducts(String productsInput) {
		Map<Product, Integer> productsMap = new HashMap<>();

		String[] productsArray = productsInput.split(";");

		for (String productInfo : productsArray) {
			try{
				Product product = createProduct(productInfo);
				int productQuantity = extractProductQuantity(productInfo);

				productsMap.put(product, productQuantity);
			} catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
		return productsMap;
	}

	public Product checkAvailableProduct(String productName, Money userMoney){
		Product product = findProductByName(productName);
		validateProductExistence(product);
		validateProductAvailability(product);
		validateUserMoneyForProduct(product, userMoney);
		return product;
	}

	public int takeProduct(Product product){
		products.put(product, products.get(product) - 1);
		return product.getPrice();
	}

	public int findLowestPriceOfCurrentProducts() {
		int lowestPrice = Integer.MAX_VALUE;
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			Product product = entry.getKey();
			int currentPrice = product.getPrice();
			int quantity = entry.getValue();

			if (quantity >= 1 && currentPrice < lowestPrice) {
				lowestPrice = currentPrice;
			}
		}
		return lowestPrice;
	}

	private Product findProductByName(String productName) {
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			Product product = entry.getKey();
			if (productName.equals(product.getName())) {
				return product;
			}
		}
		return null;
	}

	private void validateProductExistence(Product product) {
		if (product == null) {
			throw new IllegalArgumentException("[ERROR] 해당 상품이 존재하지 않습니다.");
		}
	}

	private void validateProductAvailability(Product product) {
		int currentQuantity = products.get(product);
		if (currentQuantity < 1) {
			throw new IllegalArgumentException("[ERROR] 해당 상품의 재고가 부족합니다.");
		}
	}

	private void validateUserMoneyForProduct(Product product, Money userMoney) {
		if (product.getPrice() > userMoney.getMoney()) {
			throw new IllegalArgumentException("[ERROR] 투입한 금액이 부족합니다.");
		}
	}

	private int extractProductQuantity(String productInfo) {
		String[] productDetails = productInfo.replaceAll("\\[|\\]", "").split(",");
		String productQuantityInput = productDetails[2].trim();
		return validateProductQuantity(productQuantityInput);
	}

	private Product createProduct(String productInfo) {
		String[] productDetails = productInfo.replaceAll("\\[|\\]", "").split(",");

		String productName = productDetails[0].trim();
		validateProductName(productName);
		String productPriceInput = productDetails[1].trim();
		int productPrice = validateProductPrice(productPriceInput);

		return new Product(productName, productPrice);
	}

	private void validateProductName(String productName){
		Validator.checkLengthNotUnder2(productName);
	}

	private int validateProductPrice(String productPriceInput){
		Validator.checkIsNumber(productPriceInput);
		int productPrice = Integer.parseInt(productPriceInput);
		Validator.checkIsDividedBy10(productPrice);
		Validator.checkOver100(productPrice);
		return productPrice;
	}

	private int validateProductQuantity(String productQuantityInput){
		Validator.checkIsNumber(productQuantityInput);
		int productQuantity = Integer.parseInt(productQuantityInput);
		Validator.checkOver1(productQuantity);
		return productQuantity;
	}
}
