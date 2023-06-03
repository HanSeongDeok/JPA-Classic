package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MemberRepositoryEx {
    @PersistenceContext
    private EntityManager em;

    public Long save(MemberEx member) {
        em.persist(member);
        return member.getId();
    }

    public MemberEx find(Long id) {
        return em.find(MemberEx.class, id);
    }
}
