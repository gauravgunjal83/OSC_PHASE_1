// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Dashboard.proto

package com.in.dashboard;

public interface ProductDataResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ProductDataResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Product product = 1;</code>
   */
  boolean hasProduct();
  /**
   * <code>.Product product = 1;</code>
   */
  com.in.dashboard.Product getProduct();
  /**
   * <code>.Product product = 1;</code>
   */
  com.in.dashboard.ProductOrBuilder getProductOrBuilder();

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
}
