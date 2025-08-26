package com.example.PlayTogether.model;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MemberSports implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberSportsId;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "sportId", nullable = false)
    private Sport sport;

    public MemberSports() {}

    public MemberSports(Long memberSportsId, Member member, Sport sport) {
        this.memberSportsId = memberSportsId;
        this.member = member;
        this.sport = sport;
    }

    public Long getMemberSportsId() {
        return memberSportsId;
    }

    public void setMemberSportsId(Long memberSportsId) {
        this.memberSportsId = memberSportsId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

}
