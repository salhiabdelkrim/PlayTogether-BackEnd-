package com.example.PlayTogether.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PlayTogether.dto.LoginRequest;
import com.example.PlayTogether.model.Member;
import com.example.PlayTogether.repository.MemberRepository;
import com.example.PlayTogether.service.AuthServiceImpl; // Assurez-vous d'avoir un service d'authentification
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AuthServiceImpl authService;

    // 🔹 Ajouter un membre
   @PostMapping("/register")
public ResponseEntity<?> addMember(@Valid @RequestBody Member member) {
    if (memberRepository.findByUsername(member.getUsername()).isPresent()) {
        return ResponseEntity.badRequest().body("Username already exists");
    }
    // Encoder le mot de passe avant sauvegarde
    String encodedPassword = authService.encodePassword(member.getMotDePasse());
    member.setMotDePasse(encodedPassword);

    memberRepository.save(member);
    return ResponseEntity.ok(member);
}

    // 🔹 Obtenir tous les membres
    @GetMapping("/all")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // 🔹 Obtenir un membre par son username 
    @GetMapping("/username/{username}")
public ResponseEntity<Member> getMemberByUsername(@PathVariable String username) {
    return memberRepository.findByUsername(username)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
}


    // 🔹 Supprimer un membre par son ID (optionnel)
    @DeleteMapping("/delete/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberRepository.deleteById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // LoginRequest contient username et password
        boolean isValid = authService.validateCredentials(request.getUsername(), request.getPassword());
        if (isValid) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
    
}
