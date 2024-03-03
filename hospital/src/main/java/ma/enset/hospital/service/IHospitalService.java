package ma.enset.hospital.service;

import ma.enset.hospital.Entities.Consultation;
import ma.enset.hospital.Entities.Medecin;
import ma.enset.hospital.Entities.Patient;
import ma.enset.hospital.Entities.RendezVous;

import java.util.List;
import java.util.concurrent.locks.Condition;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Patient findPatientById(Long id);
    Medecin findMedecinById(Long id);
    Patient findPatientByName(String name);
    Medecin findMedecinByName(String name);
    //RendezVous findRendezVousById(Long id);
    List<RendezVous> findAllRDV();

    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
