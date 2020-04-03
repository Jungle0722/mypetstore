package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    // 通过货物ID获取商品
    List<Product> getProductListByCategory(String categoryId);

    // 通过商品id获取商品
    Product getProduct(String productId);
}
