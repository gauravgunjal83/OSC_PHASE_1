// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Dashboard.proto

package com.in.dashboard;

public interface FilterProductResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:FilterProductResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .Product product = 1;</code>
   */
  java.util.List<com.in.dashboard.Product> 
      getProductList();
  /**
   * <code>repeated .Product product = 1;</code>
   */
  com.in.dashboard.Product getProduct(int index);
  /**
   * <code>repeated .Product product = 1;</code>
   */
  int getProductCount();
  /**
   * <code>repeated .Product product = 1;</code>
   */
  java.util.List<? extends com.in.dashboard.ProductOrBuilder> 
      getProductOrBuilderList();
  /**
   * <code>repeated .Product product = 1;</code>
   */
  com.in.dashboard.ProductOrBuilder getProductOrBuilder(
      int index);
}
