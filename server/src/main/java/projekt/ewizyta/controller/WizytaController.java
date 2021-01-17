package projekt.ewizyta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projekt.ewizyta.model.Doctor;
import projekt.ewizyta.model.User;
import projekt.ewizyta.model.Wizyta;
import projekt.ewizyta.model.eRecepta;
import projekt.ewizyta.service.UserService;
import projekt.ewizyta.service.WizytaService;

import java.util.List;

@RestController
public class WizytaController {
    @Autowired
    WizytaService wizytaService;

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/wizyty_user")
    public List<Wizyta> userWizyty(@RequestBody User user) throws Exception{
        Long tempId = user.getId();

        if(tempId > 0 && tempId != null) { //poprawne dane
            User tempUser = userService.fetchUserById(tempId);

            if(tempUser == null) { //nie ma go w bazie
                throw new Exception("Nie ma takiego uzytkownika w bazie!");
            }
        }

        User userObj = userService.fetchUserById(tempId);

        List<Wizyta> listaWizyt = wizytaService.fetchWizytaByUserId(tempId);

        return listaWizyt;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/wizyty_doctor")
    public List<Wizyta> doctorWizyty(@RequestBody Doctor doctor) throws Exception {
        Long tempId = doctor.getId(); //id lekarza

        if(tempId > 0 && tempId != null) { //poprawne dane
            Doctor tempDoctor = userService.fetchDoctorById(tempId);

            if(tempDoctor == null) { //nie ma go w bazie
                throw new Exception("Nie ma takiego lekarza w bazie!");
            }
        }

        Doctor tempDoctor = userService.fetchDoctorById(tempId);

        List<Wizyta> listaWizyt = wizytaService.fetchWizytaByDoctorId(tempId);

        return listaWizyt;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/wizyta_add")
    public Wizyta addWizyta(@RequestBody Wizyta wizyta) throws Exception{
            User tempUser = wizyta.getUser_data();
            Doctor tempDoctor = wizyta.getDoctor_data();

            if(tempDoctor != null && tempUser != null) { //nie dostalismy null'i
                //szukanie w bazie
                User findUser = userService.fetchUserById(tempUser.getId());
                Doctor findDoctor = userService.fetchDoctorById(tempDoctor.getId());

                if(findUser == null) // nie ma takiego usera w bazie
                    throw new Exception("Nie ma uzytkownika o takim id!");

                if(findDoctor == null) // nie ma takiego lekarza w bazie
                    throw new Exception("Nie ma lekarza o takim id");
            }
            //jezeli wszystko jest dobrze

            Wizyta wizytaObj = null;
            wizytaObj = wizytaService.saveWizyta(wizyta);

            return wizytaObj;
        }


        @CrossOrigin("http://localhost:3000")
        @PostMapping("/api/wizyta_delete")
        public ResponseEntity<Long> deletePost(@RequestBody Wizyta wizyta) {

            Wizyta wizytaObj = wizytaService.fetchWizytaById(wizyta.getId());
            HttpStatus isRemoved = wizytaService.deleteWizyta(wizytaObj.getId());

            if (isRemoved != HttpStatus.OK) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(wizytaObj.getId(), HttpStatus.OK);
        }
}
