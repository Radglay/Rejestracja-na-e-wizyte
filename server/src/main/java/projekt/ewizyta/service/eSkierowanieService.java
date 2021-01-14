package projekt.ewizyta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.ewizyta.model.User;
import projekt.ewizyta.model.eSkierowanie;
import projekt.ewizyta.repository.UserRepository;
import projekt.ewizyta.repository.eSkierowanieRepository;

import java.util.List;

@Service
public class eSkierowanieService {
    @Autowired
    private eSkierowanieRepository eSkierowanieRepository;

    public List<eSkierowanie> fetchByUserEmail(String email) {
        return eSkierowanieRepository.findByUserEmail(email);  //find skierowanie by email
    }

    public List<eSkierowanie> getAllSkierowania() {
        return eSkierowanieRepository.findAll();
    }

}
