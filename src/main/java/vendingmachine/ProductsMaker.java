package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class ProductsMaker {
	public Map<Product, Integer> makeProducts(String productsInput) {
		Map<Product, Integer> productsMap = new HashMap<>();

		String[] productsArray = productsInput.split(";");

		for (String productInfo : productsArray) {
			// 각 제품 정보를 대괄호로 분리
			String[] productDetails = productInfo.replaceAll("\\[|\\]", "").split(",");

			// 제품 정보 추출
			String productName = productDetails[0].trim();
			int productPrice = Integer.parseInt(productDetails[1].trim());
			int productQuantity = Integer.parseInt(productDetails[2].trim());

			// Product 객체 생성
			Product product = new Product(productName, productPrice);

			// Map에 추가
			productsMap.put(product, productQuantity);
		}

		return productsMap;
	}

}
