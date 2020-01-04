package com.piggymetrics.account.repository;

import com.piggymetrics.account.domain.Account;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

	Account findByName(String name);

}

//@Repository
//public interface AccountRepository extends JpaRepository<Account, String> {
//    Account findByName(String name);
//}