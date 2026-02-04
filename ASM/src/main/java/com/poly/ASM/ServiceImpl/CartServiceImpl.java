package com.poly.ASM.ServiceImpl;

import com.poly.ASM.Service.CartService;
import com.poly.ASM.Service.ProductService;
import com.poly.ASM.entity.CartItem;
import com.poly.ASM.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class CartServiceImpl implements CartService {

    @Autowired
    ProductService productService;

    Map<Integer, CartItem> map = new HashMap<>();

    @Override
    public void add(Integer productId) {
        CartItem item = map.get(productId);
        if(item == null) {
            Product p = productService.findById(productId);
            map.put(productId, new CartItem(p, 1));
        } else {
            item.setQuantity(item.getQuantity() + 1);
        }
    }

    @Override
    public void remove(Integer productId) {
        map.remove(productId);
    }

    @Override
    public void update(Integer productId, int qty) {
        map.get(productId).setQuantity(qty);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<CartItem> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        return map.values().stream()
                .mapToInt(CartItem::getQuantity) // Gọi qua getQuantity()
                .sum();
    }

    @Override
    public double getAmount() {
        return map.values().stream()
                .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice()) // Gọi qua getProduct()
                .sum();
    }
}

