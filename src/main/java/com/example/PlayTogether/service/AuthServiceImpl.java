package com.example.PlayTogether.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.PlayTogether.model.Member;
import com.example.PlayTogether.repository.MemberRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private MemberRepository memberRepository;

    // Injecter l’encodeur
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean validateCredentials(String username, String rawPassword) {
        Optional<Member> memberOpt = memberRepository.findByUsername(username);

        if (memberOpt.isPresent()) {
            Member member = memberOpt.get();
            // Comparer le mot de passe brut avec le hash stocké
            return passwordEncoder.matches(rawPassword, member.getMotDePasse());
        }
        return false;
    }

    // Méthode utile pour encoder le mot de passe avant de sauvegarder un membre
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}