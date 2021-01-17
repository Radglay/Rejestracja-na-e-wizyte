package projekt.ewizyta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projekt.ewizyta.model.Doctor;
import projekt.ewizyta.model.User;
import projekt.ewizyta.model.Wizyta;
import projekt.ewizyta.repository.WizytaRepository;

import java.util.List;

@Service
public class WizytaService {

    @Autowired
    WizytaRepository wizytaRepository;


    //wizyty usera
    public List<Wizyta> fetchWizytaByUserId(Long id){
       return wizytaRepository.findByUserId(id);
    }

    //wizyty lekarza
    public List<Wizyta> fetchWizytaByDoctorId(Long id) {
        return wizytaRepository.findByDoctorId(id);
    }

    public Wizyta saveWizyta(Wizyta wizyta) {
        Wizyta newWizyta = new Wizyta(
                wizyta.getUser_data(),
                wizyta.getDoctor_data(),
                wizyta.getYear(),
                wizyta.getMonth(),
                wizyta.getDay(),
                wizyta.getHour(),
                wizyta.getMinute()
        );

        return wizytaRepository.save(newWizyta);
    }

    public HttpStatus deleteWizyta(Wizyta wizyta) {
        wizytaRepository.deleteById(wizyta.getId());
        return HttpStatus.OK;
    }

}
