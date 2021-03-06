package pl.bills.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bills.entities.BillsEntity;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface BillsRepository extends JpaRepository<BillsEntity, Integer> {

    Optional<Collection<BillsEntity>> findAllByTitle(String title);

    Optional<Collection<BillsEntity>> findAllByCategoryName(String category);

    Optional<Collection<BillsEntity>> findAllByStatusName(String status);

    Optional<Collection<BillsEntity>> findAllByLoanHolderName(String name);

    Optional<BillsEntity> findByTitle(String title);

    Optional<BillsEntity> findById(Integer id);

    Optional<BillsEntity> findByIdAndUserId(Integer id, Long userId);

    Optional<Collection<BillsEntity>> findAllByCategoryNameAndUserId(String category, Long id);

}
