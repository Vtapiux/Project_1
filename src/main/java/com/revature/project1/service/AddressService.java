package com.revature.project1.service;

import com.revature.project1.Entities.Address;

import java.util.*;

public interface AddressService {
    List<Address> findAllAddress();
    Address createAddress(Address address);
    Optional<Address> findAddressById(Long id);
    Optional<Address> updateAddress(Long id, Address addressDetails);
}
