package projekt.ewizyta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.ewizyta.model.Lek;
import projekt.ewizyta.model.eRecepta;
import projekt.ewizyta.repository.LekarstwaRepository;
import projekt.ewizyta.repository.eReceptaRepository;

import java.util.List;

@Service
public class LekarstwaService {

    @Autowired
    private LekarstwaRepository lekarstwaRepository;

    public List<Lek> fetchByUserEmail(String email) {
        return lekarstwaRepository.findByUserEmail(email);
    }

    public List<Lek> getAllSkierowania() {
        return lekarstwaRepository.findAll();
    }
}
