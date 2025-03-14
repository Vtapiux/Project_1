package com.revature.project1.repository;

import com.revature.project1.Entities.Account;
import com.revature.project1.dto.AccountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
