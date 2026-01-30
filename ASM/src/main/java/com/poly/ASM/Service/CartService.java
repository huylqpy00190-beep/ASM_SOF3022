package com.poly.ASM.Service;

import com.poly.ASM.entity.CartItem;

import java.util.Collection;

public interface CartService {
    void add(Integer productId);
    void remove(Integer productId);
    void update(Integer productId, int qty);
    void clear();
    Collection<CartItem> getItems();
    int getCount();
    double getAmount();
}

