// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Dashboard.proto

package com.in.dashboard;

public interface DashboardDetailsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:DashboardDetails)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .Product featuredProducts = 1;</code>
   */
  java.util.List<com.in.dashboard.Product> 
      getFeaturedProductsList();
  /**
   * <code>repeated .Product featuredProducts = 1;</code>
   */
  com.in.dashboard.Product getFeaturedProducts(int index);
  /**
   * <code>repeated .Product featuredProducts = 1;</code>
   */
  int getFeaturedProductsCount();
  /**
   * <code>repeated .Product featuredProducts = 1;</code>
   */
  java.util.List<? extends com.in.dashboard.ProductOrBuilder> 
      getFeaturedProductsOrBuilderList();
  /**
   * <code>repeated .Product featuredProducts = 1;</code>
   */
  com.in.dashboard.ProductOrBuilder getFeaturedProductsOrBuilder(
      int index);

  /**
   * <code>repeated .Product similarProducts = 2;</code>
   */
  java.util.List<com.in.dashboard.Product> 
      getSimilarProductsList();
  /**
   * <code>repeated .Product similarProducts = 2;</code>
   */
  com.in.dashboard.Product getSimilarProducts(int index);
  /**
   * <code>repeated .Product similarProducts = 2;</code>
   */
  int getSimilarProductsCount();
  /**
   * <code>repeated .Product similarProducts = 2;</code>
   */
  java.util.List<? extends com.in.dashboard.ProductOrBuilder> 
      getSimilarProductsOrBuilderList();
  /**
   * <code>repeated .Product similarProducts = 2;</code>
   */
  com.in.dashboard.ProductOrBuilder getSimilarProductsOrBuilder(
      int index);

  /**
   * <code>repeated .Product recentlyViewedProducts = 3;</code>
   */
  java.util.List<com.in.dashboard.Product> 
      getRecentlyViewedProductsList();
  /**
   * <code>repeated .Product recentlyViewedProducts = 3;</code>
   */
  com.in.dashboard.Product getRecentlyViewedProducts(int index);
  /**
   * <code>repeated .Product recentlyViewedProducts = 3;</code>
   */
  int getRecentlyViewedProductsCount();
  /**
   * <code>repeated .Product recentlyViewedProducts = 3;</code>
   */
  java.util.List<? extends com.in.dashboard.ProductOrBuilder> 
      getRecentlyViewedProductsOrBuilderList();
  /**
   * <code>repeated .Product recentlyViewedProducts = 3;</code>
   */
  com.in.dashboard.ProductOrBuilder getRecentlyViewedProductsOrBuilder(
      int index);

  /**
   * <code>repeated .Category categories = 4;</code>
   */
  java.util.List<com.in.dashboard.Category> 
      getCategoriesList();
  /**
   * <code>repeated .Category categories = 4;</code>
   */
  com.in.dashboard.Category getCategories(int index);
  /**
   * <code>repeated .Category categories = 4;</code>
   */
  int getCategoriesCount();
  /**
   * <code>repeated .Category categories = 4;</code>
   */
  java.util.List<? extends com.in.dashboard.CategoryOrBuilder> 
      getCategoriesOrBuilderList();
  /**
   * <code>repeated .Category categories = 4;</code>
   */
  com.in.dashboard.CategoryOrBuilder getCategoriesOrBuilder(
      int index);
}