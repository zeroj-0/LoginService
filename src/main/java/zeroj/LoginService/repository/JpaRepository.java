package zeroj.LoginService.repository;

import zeroj.LoginService.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public class JpaRepository implements MemberRepository{

    private final EntityManager em;

    public JpaRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(String Id) {
        List<Member> Idresult = em.createQuery("select m from Member m where m.id = :id", Member.class)
                .setParameter("id", Id)
                .getResultList();
        return Idresult.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }
}
