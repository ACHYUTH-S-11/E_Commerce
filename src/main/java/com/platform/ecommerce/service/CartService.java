package com.platform.ecommerce.service;
 
import com.platform.ecommerce.model.CartItem;
import com.platform.ecommerce.model.Product;
import com.platform.ecommerce.model.User;
import com.platform.ecommerce.repository.CartItemRepository;
import com.platform.ecommerce.repository.ProductRepository;
import com.platform.ecommerce.repository.UserRepository;
 
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class CartService {
 
    @Autowired
    private CartItemRepository cartItemRepository;
 
    @Autowired
    private ProductRepository productRepository;
 
    @Autowired
    private UserRepository userRepository;
 
    public CartItem addToCart(Long userId, Long productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
 
        // Fetch the product and user
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
 
        // Check if the cart item already exists
        Optional<CartItem> existingCartItemOpt = cartItemRepository
                .findByUserUserIdAndProductProductId(userId, productId);
 
        if (existingCartItemOpt.isPresent()) {
            // Update the quantity and total price of the existing cart item
            CartItem existingCartItem = existingCartItemOpt.get();
            existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
            existingCartItem.setTotalPrice(existingCartItem.getProduct().getPrice() * existingCartItem.getQuantity());
            return cartItemRepository.save(existingCartItem);
        }
 
        // Create a new cart item if it doesn't exist
        CartItem newCartItem = new CartItem(product, quantity, user);
        return cartItemRepository.save(newCartItem);
    }
 
    public void removeFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
 
    public List<CartItem> viewCartByUser(Long userId) {
        return cartItemRepository.findByUserUserId(userId);
    }
 
    public double getTotalPriceByUser(Long userId) {

        List<CartItem> cartItems = cartItemRepository.findByUserUserId(userId);
        return cartItems.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }
}