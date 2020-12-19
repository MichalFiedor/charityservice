package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstitutionServiceDbImpl implements InstitutionService {
    private final InstitutionRepository institutionRepository;

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public Institution findById(long id) {
        return institutionRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {
        institutionRepository.deleteById(id);
    }

    @Override
    public void save(Institution Institution) {
        institutionRepository.save(Institution);
    }

}
