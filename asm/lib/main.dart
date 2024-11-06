import 'package:flutter/material.dart';
import 'manager/OrderManager.dart';
import 'model/order.dart';




void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Order List',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: OrderListScreen(),
    );
  }
}

class OrderListScreen extends StatefulWidget {
  @override
  _OrderListScreenState createState() => _OrderListScreenState();
}

class _OrderListScreenState extends State<OrderListScreen> {
  final OrderManager orderManager = OrderManager();
  final TextEditingController itemController = TextEditingController();
  final TextEditingController itemNameController = TextEditingController();
  final TextEditingController priceController = TextEditingController();
  final TextEditingController currencyController = TextEditingController();
  final TextEditingController quantityController = TextEditingController();

  @override
  void initState() {
    super.initState();
    // Load initial orders from JSON string
    String jsonString = '''
    [
      {"Item": "A1000", "ItemName": "Iphone 15", "Price": 1200, "Currency": "USD", "Quantity": 1},
      {"Item": "A1001", "ItemName": "Iphone 16", "Price": 1500, "Currency": "USD", "Quantity": 1}
    ]''';
    orderManager.loadOrders(jsonString);
  }

  void addOrder() {
    final newOrder = Order(
      item: itemController.text,
      itemName: itemNameController.text,
      price: double.tryParse(priceController.text) ?? 0.0,
      currency: currencyController.text,
      quantity: int.tryParse(quantityController.text) ?? 1,
    );
    orderManager.addOrder(newOrder);
    itemController.clear();
    itemNameController.clear();
    priceController.clear();
    currencyController.clear();
    quantityController.clear();
    setState(() {}); // Refresh the UI
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Order List'),
      ),
      body: Column(
        children: [
          Expanded(
            child: ListView.builder(
              itemCount: orderManager.orders.length,
              itemBuilder: (context, index) {
                final order = orderManager.orders[index];
                return ListTile(
                  title: Text(order.itemName),
                  subtitle: Text('${order.price} ${order.currency} (Qty: ${order.quantity})'),
                );
              },
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Column(
              children: [
                TextField(
                  controller: itemController,
                  decoration: InputDecoration(labelText: 'Item'),
                ),
                TextField(
                  controller: itemNameController,
                  decoration: InputDecoration(labelText: 'Item Name'),
                ),
                TextField(
                  controller: priceController,
                  decoration: InputDecoration(labelText: 'Price'),
                  keyboardType: TextInputType.number,
                ),
                TextField(
                  controller: currencyController,
                  decoration: InputDecoration(labelText: 'Currency'),
                ),
                TextField(
                  controller: quantityController,
                  decoration: InputDecoration(labelText: 'Quantity'),
                  keyboardType: TextInputType.number,
                ),
                ElevatedButton(
                  onPressed: addOrder,
                  child: Text('Add Order'),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
