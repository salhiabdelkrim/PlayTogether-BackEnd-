package com.example.PlayTogether.model;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Participation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long participationId;

    @ManyToOne
    @JoinColumn(name = "encounterId", nullable = false)
    private Encounter encounter;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    public Participation() {}

    public Participation(Long participationId, Encounter encounter, Member member) {
        this.participationId = participationId;
        this.encounter = encounter;
        this.member = member;
    }

    public Long getParticipationId() {
        return participationId;
    }

    public void setParticipationId(Long participationId) {
        this.participationId = participationId;
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

}
