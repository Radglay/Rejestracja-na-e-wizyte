package projekt.ewizyta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.ewizyta.model.eRecepta;
import projekt.ewizyta.model.eSkierowanie;
import projekt.ewizyta.repository.eReceptaRepository;


import java.util.List;

@Service
public class eReceptaService {
    @Autowired
    private eReceptaRepository receptaRepository;

    public List<eRecepta> fetchByUserEmail(String email) {
       return receptaRepository.findByUserEmail(email);
    }

    public List<eRecepta> getAllSkierowania() {
        return receptaRepository.findAll();
    }

}
