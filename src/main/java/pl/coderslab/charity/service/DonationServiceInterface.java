package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Donation;

import java.util.List;

public interface DonationServiceInterface {

    List<Donation> findAll();

    Donation findById(long id);

    void delete(long id);

    void save(Donation donation);
}
