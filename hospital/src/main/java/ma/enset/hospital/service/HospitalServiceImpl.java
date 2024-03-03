package ma.enset.hospital.service;

import jakarta.transaction.Transactional;
import ma.enset.hospital.Entities.Consultation;
import ma.enset.hospital.Entities.Medecin;
import ma.enset.hospital.Entities.Patient;
import ma.enset.hospital.Entities.RendezVous;
import ma.enset.hospital.Repositories.ConsulationRepository;
import ma.enset.hospital.Repositories.MedecinRepository;
import ma.enset.hospital.Repositories.PatientRepository;
import ma.enset.hospital.Repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsulationRepository consulationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsulationRepository consulationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consulationRepository = consulationRepository;
    }
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public Medecin findMedecinById(Long id) {
        return medecinRepository.findById(id).get();
    }

    @Override
    public Patient findPatientByName(String name) {
        return patientRepository.findByNom(name);
    }

    @Override
    public Medecin findMedecinByName(String name) {
        return medecinRepository.findByNom(name);
    }
    /*
    @Override
    public RendezVous findRendezVousById(Long id) {
        return rendezVousRepository.findById(id).get();
    }

     */

    @Override
    public List<RendezVous> findAllRDV() {
        return rendezVousRepository.findAll();
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }
    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consulationRepository.save(consultation);
    }


}
