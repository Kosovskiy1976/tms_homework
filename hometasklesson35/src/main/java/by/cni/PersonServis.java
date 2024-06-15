package by.cni;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServis implements InitializingBean {
    private final SessionFactory sessionFactory;

    @Override
    public void afterPropertiesSet() throws Exception {
        PersonEntity person = new PersonEntity();
        person.setName("Andrew");
        person.setSalary(1000);
        person.setRole(Type.ADMIN);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();

        System.out.println();
    }
}
