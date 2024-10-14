package classwork.supermarket.dao;

import classwork.supermarket.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class SupermarketImpl implements Supermarket {

    private Collection<Product> products = new ArrayList<>();

    //constructor
    //array[capacity]
    // int size
    //WE DO NOT USE IT ANYMORE

    @Override
    public boolean addProduct(Product product) {
        if(product == null || products.contains(product)) {
            return false;
        }
        return products.add(product);
    }

    @Override
    public Product removeProduct(long barcode) {
        Product product = findByBarcode(barcode);
        products.remove(product);
        return product;
    }

    @Override
    public Product findByBarcode(long barcode) {
        for (Product p : products){
            if(barcode == p.getBarCode()){
                return p;
            }
        }
        return null;
    }

    @Override
    public Iterable<Product> findByCategory(String category) {
        return findByPredicate(p -> p.getCategory().equals(category));
    }

    @Override
    public Iterable<Product> findByBrand(String brand) {
        return findByPredicate((p -> p.getBrand().equals(brand)));
    }

    @Override
    public Iterable<Product> findProductsWithExpiredDate() {

        return findByPredicate(p -> p.getDate().isBefore(LocalDate.now()));
    }

    @Override
    public int skuQuantity() {
        return products.size();
    }
    private Iterable<Product> findByPredicate(Predicate<Product> predicate){
        List<Product> res = new ArrayList<>();
        for (Product p : products){
            if (predicate.test(p)){
                res.add(p);
            }
        }
    return res;
    }
}
