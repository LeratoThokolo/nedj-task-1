package nedj.train.task1webservice.nedj.train.repository;

import nedj.train.task1webservice.nedj.train.model.TradingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradingAccountRepository extends JpaRepository<TradingAccount, Integer> {

}
