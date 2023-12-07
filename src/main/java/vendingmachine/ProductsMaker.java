package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class ProductsMaker {
	public Map<Product, Integer> makeProducts(String productsInput) {
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

	private Product createProduct(String productInfo) {
		String[] productDetails = productInfo.replaceAll("\\[|\\]", "").split(",");

		String productName = productDetails[0].trim();
		validateProductName(productName);
		String productPriceInput = productDetails[1].trim();
		int productPrice = validateProductPrice(productPriceInput);

		return new Product(productName, productPrice);
	}

	private int extractProductQuantity(String productInfo) {
		String[] productDetails = productInfo.replaceAll("\\[|\\]", "").split(",");
		String productQuantityInput = productDetails[2].trim();
		return validateProductQuantity(productQuantityInput);
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
