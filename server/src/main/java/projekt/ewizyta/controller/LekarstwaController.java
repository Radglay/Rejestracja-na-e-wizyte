package projekt.ewizyta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import projekt.ewizyta.model.Lek;
import projekt.ewizyta.model.eRecepta;
import projekt.ewizyta.model.eSkierowanie;
import projekt.ewizyta.repository.eReceptaRepository;
import projekt.ewizyta.service.LekarstwaService;

import java.util.List;

@RestController
public class LekarstwaController {
    @Autowired
    LekarstwaService lekarstwaService;

    @GetMapping("/api/lekarstwa/{email}")
    public List<Lek> getListOfSkierowanie(@PathVariable String email) throws Exception {
        return lekarstwaService.fetchByUserEmail(email);
    }

}
