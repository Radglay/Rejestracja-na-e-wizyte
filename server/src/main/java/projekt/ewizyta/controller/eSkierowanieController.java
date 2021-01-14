package projekt.ewizyta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import projekt.ewizyta.model.User;
import projekt.ewizyta.model.eSkierowanie;
import projekt.ewizyta.service.eSkierowanieService;

import java.util.List;

@RestController
public class eSkierowanieController {

    @Autowired
    eSkierowanieService skierowanieService;


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
}