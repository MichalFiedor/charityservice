package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationService implements DonationServiceInterface {
    private final DonationRepository donationRepository;

    @Override
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    @Override
    public Donation findById(long id) {
        return donationRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {
        donationRepository.deleteById(id);
    }

    @Override
    public void save(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public long sumBagsFromAllDonations() {
        return donationRepository.sumAllBags();
    }
}
