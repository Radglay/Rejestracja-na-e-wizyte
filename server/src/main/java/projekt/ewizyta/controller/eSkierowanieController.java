package projekt.ewizyta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projekt.ewizyta.model.Doctor;
import projekt.ewizyta.model.User;
import projekt.ewizyta.model.eRecepta;
import projekt.ewizyta.model.eSkierowanie;
import projekt.ewizyta.service.UserService;
import projekt.ewizyta.service.eSkierowanieService;

import java.util.List;

@RestController
public class eSkierowanieController {
    Long KODY = (long)10000;

    @Autowired
    eSkierowanieService skierowanieService;

    @Autowired
    UserService userService;

    @GetMapping("/api/skierowania/{email}")
    public List<eSkierowanie> getListOfSkierowanie(@PathVariable String email) throws Exception {
        return skierowanieService.fetchByUserEmail(email);
    }

    @GetMapping("/api/skierowania")
    public List<eSkierowanie> getListOfAllSkierowanie() {
        List<eSkierowanie> lista = skierowanieService.getAllSkierowania();
        for(eSkierowanie skr : lista) {
            System.out.print("Nazwisko lekarza:" + skr.getDoctor_data().getUser().getSurname()
                    + ", specjalizacja: " + skr.getDoctor_data().getType());
            System.out.println(", Imie pacjenta: " + skr.getUser_data().getName() + ", Nazwisko: " + skr.getUser_data().getSurname());
        }

        return lista;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/skierowanie_add")
    public eSkierowanie addSkierowanie(@RequestBody eSkierowanie skierowanie) throws  Exception{
        User tempUser = skierowanie.getUser_data();
        Doctor tempDoctor = skierowanie.getDoctor_data();
        KODY+=10;
        Long tempKod = KODY;

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



        skierowanie.setKod(tempKod);
        eSkierowanie skierowanieObj = null;
        skierowanieObj = skierowanieService.saveSkierowanie(skierowanie);

        return skierowanieObj;
    }
}