package com.revature.project1.service;

import org.springframework.stereotype.Service;
import com.revature.project1.Entities.Address;
import com.revature.project1.repository.AddressRepository;

import java.util.*;

@Service
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAllAddress(){
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findAddressById(Long id){
        return addressRepository.findById(id);
    }

    @Override
    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> updateAddress(Long id, Address addressDetails){
        return addressRepository.findById(id).map(existingAddress -> {
            existingAddress.setCountry(addressDetails.getCountry());
            existingAddress.setState(addressDetails.getState());
            existingAddress.setCity(addressDetails.getCity());
            existingAddress.setStreet(addressDetails.getStreet());
            existingAddress.setStreetNum(addressDetails.getStreetNum());
            existingAddress.setZip(addressDetails.getZip());
            return addressRepository.save(existingAddress);
        });
    }
}
