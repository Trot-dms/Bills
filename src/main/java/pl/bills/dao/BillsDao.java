package pl.bills.dao;

import org.springframework.data.repository.CrudRepository;
import pl.bills.entities.BillsEntity;
import pl.bills.entities.StatusEntity;

import java.util.List;

/**
 * Created by trot on 08.01.17.
 */
public interface BillsDao extends CrudRepository<BillsEntity, Integer> {

    List<BillsEntity> findBillsByTitle(String title);
    List<BillsEntity> findBillsByCategoryName(String category);
    List<BillsEntity> findBillsByStatusName(String status);
    List<BillsEntity> findBillsByLoanHolderName(String name);

}