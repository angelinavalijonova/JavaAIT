package lesson25.homework.test;

import lesson25.homework.dao.StockImpl;
import lesson25.homework.model.Detail;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StockImplTest {

    StockImpl stock;

   @Before
   public void setUp(){
       stock = new StockImpl(5);
   }

   @Test
   public void addDetailsTest() {
       Detail detail = new Detail(123456789, 2.5, "wood", "H&M", 5.0);
       Detail addedDetail = stock.addDetail(detail);
       assertEquals(123456789,addedDetail.getBarCode());

   }

   @Test
   public void findDetail(){
       Detail detail = new Detail(123456789, 2.5, "wood", "H&M", 5.0);
       stock.addDetail(detail);
       Detail foundDetail = stock.findDetail(123456789);
       assertEquals(123456789, foundDetail.getBarCode());
   }

   @Test
    public void removeDetail(){
       Detail detail = new Detail(123456789, 2.5, "wood", "H&M", 5.0);
       stock.addDetail(detail);
Detail removedDetail = stock.removeDetail(123456789);
assertEquals(123456789,removedDetail.getBarCode());
   }

    @Test
    public void totalWeightCounter(){
        Detail detail = new Detail(123456789, 2.5, "wood", "H&M", 5.0);
        stock.addDetail(detail);
        double weightCounter = stock.totalWeight(5.0);
        assertEquals(5.0; we);
    }
}
