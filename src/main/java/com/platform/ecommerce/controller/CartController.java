package com.platform.ecommerce.controller;

import com.platform.ecommerce.model.CartItem;
import com.platform.ecommerce.model.Product;
import com.platform.ecommerce.service.CartService;
import com.platform.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.platform.ecommerce.DTO.CartRequest;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public ResponseEntity<CartItem> addToCart(@RequestBody CartRequest request) {
        CartItem cartItem = cartService.addToCart(request.getUserId(), request.getProductId(), request.getQuantity());
        return ResponseEntity.ok(cartItem);
    }

    @DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long cartItemId) {
        try {
            cartService.removeFromCart(cartItemId);
            return ResponseEntity.ok("Item removed from cart");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Item not found in cart");
        }
    }

    @GetMapping("/view/{userId}")
    public ResponseEntity<List<CartItem>> viewCart(@PathVariable Long userId) {
        List<CartItem> items = cartService.viewCartByUser(userId);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/total/{userId}")
    public ResponseEntity<Double> getTotalPrice(@PathVariable Long userId) {
        double total = cartService.getTotalPriceByUser(userId);
        return ResponseEntity.ok(total);
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }
}