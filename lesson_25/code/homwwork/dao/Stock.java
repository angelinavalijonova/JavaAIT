package lesson25.homework.dao;
//Интерфейс Stock c методами:
// добавить деталь на склад
// найти по barCode
// обновить данные
// удалить деталь
// общая масса всех деталей
// средняя масса всех деталей
// найти детали с размером от и до

import lesson25.homework.model.Detail;

public interface Stock {

    Detail addDetail(Detail detail);

    Detail findDetail(long barcode);

    Detail updateDetailInfo ();

    Detail removeDetail(long barcode);

    double totalWeight(double weight);

    Detail averageWeight(double weight);

    Detail findDetailBySize(double size);

}
