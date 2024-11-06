import 'dart:convert' show json;

import '../model/order.dart';



class OrderManager {
  List<Order> orders = [];

  void loadOrders(String jsonString) {
    List<dynamic> jsonList = json.decode(jsonString);
    orders = jsonList.map((json) => Order.fromJson(json)).toList();
  }

  void addOrder(Order order) {
    orders.add(order);
  }
}
