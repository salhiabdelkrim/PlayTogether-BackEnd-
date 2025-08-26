package com.example.PlayTogether.controller;

import com.example.PlayTogether.model.Encounter;
import com.example.PlayTogether.model.Member;
import com.example.PlayTogether.repository.EncounterRepository;
import com.example.PlayTogether.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/encounters")
public class EncounterController {

    @Autowired
    private EncounterRepository encounterRepository;

    @Autowired
    private MemberRepository memberRepository;

    // 🔹 Ajouter une rencontre
    @PostMapping("/create")
    public Encounter createEncounter(@RequestBody Encounter encounter, @RequestParam Long creatorId) {
        Optional<Member> creatorOpt = memberRepository.findById(creatorId);
        if (creatorOpt.isEmpty()) {
            throw new RuntimeException("Créateur non trouvé");
        }
        encounter.setCreatedBy(creatorOpt.get());
        return encounterRepository.save(encounter);
    }

    // 🔹 Récupérer toutes les rencontres
    @GetMapping("/all")
    public List<Encounter> getAllEncounters() {
        return encounterRepository.findAll();
    }

    // 🔹 Modifier une rencontre
    @PutMapping("/update/{id}")
    public Encounter updateEncounter(
            @PathVariable Long id,
            @RequestBody Encounter updatedEncounter,
            @RequestParam Long requesterId) {

        Encounter existing = encounterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rencontre non trouvée"));

        if (!existing.getCreatedBy().getUsername().equals(requesterId)) {
            throw new RuntimeException("Non autorisé à modifier cette rencontre");
        }

        existing.setDateTime(updatedEncounter.getDateTime());
        existing.setPrice(updatedEncounter.getPrice());
        existing.setSport(updatedEncounter.getSport());
        existing.setLocation(updatedEncounter.getLocation());

        return encounterRepository.save(existing);
    }

    // 🔹 Supprimer une rencontre
    @DeleteMapping("/delete/{id}")
    public String deleteEncounter(@PathVariable Long id, @RequestParam Long requesterId) {
        Encounter encounter = encounterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rencontre non trouvée"));

        if (!encounter.getCreatedBy().getUsername().equals(requesterId)) {
            throw new RuntimeException("Non autorisé à supprimer cette rencontre");
        }

        encounterRepository.deleteById(id);
        return "Rencontre supprimée avec succès.";
    }
}
