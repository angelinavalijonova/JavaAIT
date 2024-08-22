package lesson25.homework.dao;

import lesson25.homework.model.Detail;

public class StockImpl implements Stock {
    Detail[] details;

    public StockImpl(int size) {
        this.details = new Detail[size];
    }

    @Override
    public Detail addDetail(Detail detail) {
        for (int i = 0; i < details.length; i++) {
            if (details[i] == null){
                details[i] = detail;
            }

        }
        return detail;
    }

    @Override
    public Detail findDetail(long barcode) {
       for(int i = 0; i < details.length; i ++){
           if(details[i] != null && details[i].getBarCode() == barcode)
               return details[i];
       }
       return null;
    }

    @Override
    public Detail updateDetailInfo() {
        return null;
    }

    @Override
    public Detail removeDetail(long barcode) {
      Detail deletedDetail = null;
      for(int i = 0; i < details.length; i ++){
          if(details[i] != null && details[i].getBarCode() == barcode) {
              deletedDetail = details[i];
              details[i] = null;
              break;
          }
      }
      return deletedDetail;
    }

    @Override
    public double totalWeight(double weight) {
        double totalWeight = 0.0;
        for (int i = 0; i < details.length; i++) {
           totalWeight = details[i].getWeight();
           totalWeight ++;
        }
       return totalWeight;
    }

    @Override
    public Detail averageWeight(double weight) {
        return null;
    }

    @Override
    public Detail findDetailBySize(double size) {
        return null;
    }
}
