package homework.test;

import homework.dao.StockImpl;
import homework.model.Detail;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


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
        double weightCounter = stock.totalWeight();
        assertEquals(5.0, weightCounter, 0.1);
    }

    @Test
    public void averageWeightCounter(){
        Detail detail = new Detail(123456789, 2.5, "wood", "H&M", 5.0);
        stock.addDetail(detail);
        stock.addDetail(detail);
        stock.addDetail(detail);
        double averageWeightCounter = stock.averageWeight();
        assertEquals( 5,averageWeightCounter,0.1);
    }

    @Test
    public void findBySize(){
        Detail detail = new Detail(123456789, 2.5, "wood", "H&M", 5.0);
        stock.addDetail(detail);
        stock.addDetail(detail);
        Detail foundedDetail = stock.findDetailBySize(2.5);
       assertEquals(2.5,foundedDetail.getSize(),0.1);
    }

    @Test
    public void updateInfo(){
        Detail detail = new Detail(123456789, 2.5, "wood", "H&M", 5.0);
        stock.addDetail(detail);
        Detail newDetail = new Detail(123456789, 2.5, "wood", "H&M", 5.5);
        Detail updatedDetail = stock.updateDetailInfo(newDetail);
        assertEquals(123456789, updatedDetail.getBarCode());
        assertEquals(5.5, updatedDetail.getWeight(), 0);

        newDetail = new Detail(222, 2.5, "wood", "H&M", 5.5);
        updatedDetail = stock.updateDetailInfo(newDetail);
        assertNull(updatedDetail);
    }
}
