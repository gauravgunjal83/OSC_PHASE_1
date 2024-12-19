package com.in.mapper;

import com.in.cart.CartProduct;
import com.in.cart.ViewCartProductResponse;
import com.in.dashboard.Category;
import com.in.dashboard.DashboardDetails;
import com.in.dashboard.Product;
import com.in.dto.CustomDataResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardResponse {

    public static CustomDataResponse dataResponseToDetails(String userId, com.in.dashboard.DashboardResponse dashboardResponse) {
        List<Map<String, Object>> dataObject = new ArrayList<>();

        if (dashboardResponse != null && dashboardResponse.getDashBoardDetails() != null) {
            DashboardDetails details = dashboardResponse.getDashBoardDetails();

            // Featured Products
            if (!details.getFeaturedProductsList().isEmpty()) {
                Map<String, Object> featuredProductsSection = new HashMap<>();
                featuredProductsSection.put("TYPE", "Featured Products");

                List<Map<String, Object>> featuredProductsList = new ArrayList<>();
                for (Product product : details.getFeaturedProductsList()) {
                    Map<String, Object> productMap = new HashMap<>();
                    productMap.put("productId", product.getProductId());
                    productMap.put("categoryId", product.getCategoryId());
                    productMap.put("prodName", product.getProductName());
                    productMap.put("prodMarketPrice", product.getProductPrice());
                    featuredProductsList.add(productMap);
                }

                featuredProductsSection.put("Featured Products", featuredProductsList);
                dataObject.add(featuredProductsSection);
            }

            // For Recently Viewed Products
            if (!details.getRecentlyViewedProductsList().isEmpty()) {
                Map<String, Object> recentlyViewedSection = new HashMap<>();
                recentlyViewedSection.put("TYPE", "Recently Viewed Products");

                List<Map<String, Object>> recentlyViewedList = new ArrayList<>();
                for (Product product : details.getRecentlyViewedProductsList()) {
                    Map<String, Object> productMap = new HashMap<>();
                    productMap.put("productId", product.getProductId());
                    productMap.put("prodName", product.getProductName());
                    productMap.put("categoryId", product.getCategoryId());
                    productMap.put("prodMarketPrice", product.getProductPrice());
                    productMap.put("productDescription", product.getProductDesc());
                    recentlyViewedList.add(productMap);
                }

                recentlyViewedSection.put("Recently Viewed Products", recentlyViewedList);
                dataObject.add(recentlyViewedSection);
            }

            //For Similar Products
            if (!details.getSimilarProductsList().isEmpty()) {
                Map<String, Object> similarProductsSection = new HashMap<>();
                similarProductsSection.put("TYPE", "Similar Products");

                List<Map<String, Object>> similarProductsList = new ArrayList<>();
                for (Product product : details.getSimilarProductsList()) {
                    Map<String, Object> productMap = new HashMap<>();
                    productMap.put("productId", product.getProductId());
                    productMap.put("categoryId", product.getCategoryId());
                    productMap.put("prodName", product.getProductName());
                    productMap.put("prodMarketPrice", product.getProductPrice());
                    productMap.put("productDescription", product.getProductDesc());
                    similarProductsList.add(productMap);
                }

                similarProductsSection.put("Similar Products", similarProductsList);
                dataObject.add(similarProductsSection);
            }

            // Categories
            if (!details.getCategoriesList().isEmpty()) {
                Map<String, Object> categoriesSection = new HashMap<>();
                categoriesSection.put("TYPE", "Categories");

                List<Map<String, Object>> categoriesList = new ArrayList<>();
                for (Category category : details.getCategoriesList()) {
                    Map<String, Object> categoryMap = new HashMap<>();
                    categoryMap.put("categoryId", category.getCategoryId());
                    categoryMap.put("categoryName", category.getCategoryName());
                    categoriesList.add(categoryMap);
                }

                categoriesSection.put("Categories", categoriesList);
                dataObject.add(categoriesSection);
            }
        }
//        if (!cartOfProduct.getProductList().isEmpty()) {
//            Map<String, Object> cartSection = new HashMap<>();
//            cartSection.put("TYPE", "Cart");
//
//            Map<String, Object> cartDetails = new HashMap<>();
//            cartDetails.put("userId", userId);
//
//            List<Map<String, Object>> cartProductsList = new ArrayList<>();
//            double totalPrice = 0;
//
//            for (CartProduct cartProduct : cartOfProduct.getProductList()) {
//                Map<String, Object> productMap = new HashMap<>();
//                productMap.put("productId", cartProduct.getProductId());
//                productMap.put("prodName", cartProduct.getProductName());
//                productMap.put("prodMarketPrice", cartProduct.getProductPrice());
//                productMap.put("cartQty", cartProduct.getQuantity());
//                cartProductsList.add(productMap);
//
//                totalPrice += cartProduct.getProductPrice() * cartProduct.getQuantity();
//            }
//
//            cartDetails.put("cartProducts", cartProductsList);
//            cartDetails.put("ProductsCartCount", cartProductsList.size());
//            cartDetails.put("Price", totalPrice);
//
//            cartSection.put("Cart", cartDetails);
//            dataObject.add(cartSection);
//        }

        Map<String, Object> finalData = new HashMap<>();
        finalData.put("data", dataObject);

        CustomDataResponse dataResponse = new CustomDataResponse();
        dataResponse.setCode(200);
        dataResponse.setDataObject(finalData);

        return dataResponse;
    }
}
