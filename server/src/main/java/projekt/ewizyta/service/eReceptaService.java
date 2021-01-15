package projekt.ewizyta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.ewizyta.model.*;
import projekt.ewizyta.repository.LekRepository;
import projekt.ewizyta.repository.eReceptaRepository;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class eReceptaService {
    @Autowired
    private eReceptaRepository receptaRepository;

    @Autowired
    private LekRepository lekRepository;

    public List<eRecepta> fetchByUserEmail(String email) {
       return receptaRepository.findByUserEmail(email);
    }

    public List<eRecepta> getAllSkierowania() {
        return receptaRepository.findAll();
    }

    public Lek fetchLekByNazwa(String nazwa) {
        return lekRepository.findByNazwa(nazwa);
    }

    public Lek saveLek(Lek lek) {
        Lek newLek = new Lek(
                lek.getNazwa(),
                lek.getDawkowanie()
        );

        return lekRepository.save(newLek);
    }


//    public eRecepta saveRecepta(eRecepta recepta, User user, Doctor doctor) {
//        eRecepta newRecepta = new eRecepta(user,
//                doctor,
//                recepta.getKod(),
//                Arrays.asList(new Lek()),
//                LocalDate.now());
//    }

}
