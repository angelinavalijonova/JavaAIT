package homework.dao;

import homework.model.Detail;

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
                return detail;
            }

        }
        return null;
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
    public Detail updateDetailInfo(Detail detail) {
        for (int i = 0; i < details.length; i++) {
            if(details[i] != null && details[i].getBarCode() == detail.getBarCode()) {
                details[i] = detail;
                return detail;
            }
        }
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
    public double totalWeight() {
        double totalWeight = 0.0;
        for(int i = 0; i < details.length; i++) {
            if(details[i] != null)
                totalWeight += details[i].getWeight();
        }
       return totalWeight;
    }

    @Override
    public double averageWeight() {
        int count = 0;
        double totalWeight = this.totalWeight();
        for (int i = 0; i < details.length; i++) {
            if(details[i] != null)
            count++;
        }

        return totalWeight/count;
    }

    @Override
    public Detail findDetailBySize(double size) {
        for(int i = 0; i < details.length; i ++){
            if(details[i] != null && details[i].getSize() == size)
               return details[i];
        }
        return null;
    }
    }

