package br.com.JobManagement.job_management.candidate.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidato")
public class CandidateController {

    @PostMapping("/")
    public void create() {

    }

}
