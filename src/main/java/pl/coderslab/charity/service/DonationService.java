package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Donation;

import java.util.List;

public interface DonationService {

    List<Donation> findAll();

    Donation findById(long id);

    void delete(long id);

    void save(Donation donation);

    Long sumBagsFromAllDonations();

    Long sumAllDonations();
}
