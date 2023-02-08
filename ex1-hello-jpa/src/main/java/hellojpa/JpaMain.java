package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            /*
//             * 삽입
//             */
//            Member member = new Member();
//
//            // 여기까지만 했을 경우 실행 x -> 트랜잭션 매우 중요!!
//            member.setId(2L);
//            member.setName("HelloB");
//
//            em.persist(member);

            /**
             * 조회
             */
//            Member findMember = em.find(Member.class, 1L);
//
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());

            // 삭제
//            em.remove(findMember);

//            findMember.setName("HelloJPA");  // set만 해주고, 다시 등록은 안해줘도 됨.

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
