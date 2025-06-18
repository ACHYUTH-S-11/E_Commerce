package com.platform.ecommerce.repository;
 
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
import com.platform.ecommerce.model.CartItem;
import java.util.List;
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserUserId(Long userId);
 
    Optional<CartItem> findByUserUserIdAndProductProductId(Long userId, Long productId);
}