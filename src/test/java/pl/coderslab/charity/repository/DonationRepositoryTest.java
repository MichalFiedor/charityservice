package pl.coderslab.charity.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderslab.charity.entity.Donation;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DonationRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DonationRepository donationRepository;

    @Test
    public void sum_all_bags_then_return_eight_bags() {
        //given
        Donation donation1 = new Donation();
        donation1.setQuantity(2);
        entityManager.persist(donation1);
        Donation donation2 = new Donation();
        donation2.setQuantity(6);
        entityManager.persist(donation2);

        //when
        long sumAllBags = donationRepository.sumAllBags();

        //than
        assertEquals(8, sumAllBags);
        assertNotNull(sumAllBags);
    }

    @Test(expected = NullPointerException.class)
    public void sum_all_bags_then_return_null() {
        long sumAllBags = donationRepository.sumAllBags();
    }

    @Test
    public void count_all_donations_then_return_three_donations() {
        //given
        Donation donation1 = new Donation();
        entityManager.persist(donation1);
        Donation donation2 = new Donation();
        entityManager.persist(donation2);
        Donation donation3 = new Donation();
        entityManager.persist(donation3);

        //when
        long sumAllDonations = donationRepository.countAllDonations();

        //than
        assertEquals(3, sumAllDonations);
        assertNotNull(sumAllDonations);
    }

    @Test
    public void count_all_bags_then_return_zero() {
        //when
        long sumAllDonations = donationRepository.countAllDonations();

        //than
        assertEquals(0, sumAllDonations);
    }
}