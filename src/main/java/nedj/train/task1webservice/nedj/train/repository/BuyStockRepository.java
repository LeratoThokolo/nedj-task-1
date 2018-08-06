package nedj.train.task1webservice.nedj.train.repository;

import nedj.train.task1webservice.nedj.train.model.BuyStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyStockRepository extends JpaRepository<BuyStock, Integer> {
}
