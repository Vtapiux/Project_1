package com.revature.project1.controller;

import com.revature.project1.Entities.Account;
import com.revature.project1.Entities.Loan;
import com.revature.project1.Entities.User;
import com.revature.project1.repository.UserRepository;
import com.revature.project1.service.LoanService;
import com.revature.project1.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {
    private final LoanService loanService;
    private final UserRepository userRepository;

    public LoanController(LoanService loanService, UserRepository userRepository) {
        this.loanService = loanService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllLoans(HttpServletRequest httpServletRequest){
        if (httpServletRequest.getSession(false) != null){
            HttpSession httpSession = httpServletRequest.getSession(false);
            Account account = (Account) httpSession.getAttribute("newAccount");
            if (account.getRole().getRoleId() == 2){ // Only manager can see all Loans
                return ResponseEntity.ok(loanService.findAllLoan());
            } else {
                return ResponseEntity.ok("error: You have no permission to take this action!");
            }
        }
        return ResponseEntity.ok("error: Invalid action (no session is in progress)!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLoanById(@PathVariable Long id, HttpServletRequest httpServletRequest){
        if(httpServletRequest.getSession(false) != null){
            HttpSession httpSession = httpServletRequest.getSession(false);
            Account account = (Account) httpSession.getAttribute("newAccount");
            if(account.getRole().getRoleId() == 2){
                User userFromDB = userRepository.findByAccount_accountId(account.getAccountId());
                if(loanService.findLoanById(id).isEmpty()){
                    return ResponseEntity.ok("error: This loan does not exists");
                }
                if(userFromDB.getAccount().getAccountId() == loanService.findLoanById(id).map(Loan::getId).orElse(null)){
                    return loanService.findLoanById(id).map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
                } else{
                    return ResponseEntity.ok("error: This user does not own this loan");
                }
            }else {
                return ResponseEntity.ok("error: You have no permission to take this action!");
            }
        } else {
            return ResponseEntity.ok("error: Invalid action (no session is in progress)!");
        }
    }

    @PostMapping
    public ResponseEntity<?> createLoan(@RequestBody Loan loan, HttpServletRequest httpServletRequest){
        if(httpServletRequest.getSession(false) != null){
            HttpSession httpSession = httpServletRequest.getSession(false);
            Account account = (Account) httpSession.getAttribute("newAccount");
            if(account.getRole().getRoleId() == 1){ //Only customer can create loans
                if(userRepository.findByAccount_accountId(account.getAccountId()) != null){
                    Loan loanCreated = loanService.createLoan(loan);
                    return ResponseEntity.status(HttpStatus.CREATED).body(loanCreated);
                } else {
                    return ResponseEntity.ok("error: User does not exists");
                }
            } else {
                return ResponseEntity.ok("error: You have no permission to take this action!");
            }
        } else{
            return ResponseEntity.ok("error: Invalid action (no session is in progress)!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLoan(@PathVariable Long id, @RequestBody Loan loanDetails, HttpServletRequest httpServletRequest){
        if(httpServletRequest.getSession(false)!= null){
            HttpSession httpSession = httpServletRequest.getSession(false);
            Account account = (Account) httpSession.getAttribute("newAccount");
            if(account.getRole().getRoleId() == 2){ //only manager can update
                return loanService.updateLoan(id, loanDetails)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
            } else {
                return ResponseEntity.ok("error: As a manager you can only update a loan!");
            }
        } else{
            return ResponseEntity.ok("error: Invalid action (no session is in progress)!");
        }
    }
}
