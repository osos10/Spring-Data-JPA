package ma.enset.hospital;

import ma.enset.hospital.Entities.*;
import ma.enset.hospital.Repositories.ConsulationRepository;
import ma.enset.hospital.Repositories.MedecinRepository;
import ma.enset.hospital.Repositories.PatientRepository;
import ma.enset.hospital.Repositories.RendezVousRepository;
import ma.enset.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(IHospitalService hospitalService){

		return args -> {
			Stream.of("Mohamed","Hassan","Najat").forEach(name->{
				Patient patient=new Patient();
				patient.setNom(name);
				patient.setDateNaissance(new Date());
				patient.setMalade(false);
				hospitalService.savePatient(patient);
			});
			Stream.of("Ayman","Ossama","Rokaya").forEach(name->{
				Medecin medecin=new Medecin();
				medecin.setNom(name);
				medecin.setSpecialite(Math.random()>0.5?"Cardio":"Denstiste");
				medecin.setMail(name+"@gmail.com");
				hospitalService.saveMedecin(medecin);
			});

			Patient patient=hospitalService.findPatientById(1L);
			Patient patient1 =hospitalService.findPatientByName("Mohamed");
			Medecin medecin = hospitalService.findMedecinById(1L);
			Medecin medecin1 = hospitalService.findMedecinByName("Rokaya");

			RendezVous rendezVous=new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin1);

			hospitalService.saveRDV(rendezVous);

			RendezVous rendezVous1=hospitalService.findAllRDV().get(0);
			Consultation consultation=new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation ......");
			hospitalService.saveConsultation(consultation);

		};

	}
}
