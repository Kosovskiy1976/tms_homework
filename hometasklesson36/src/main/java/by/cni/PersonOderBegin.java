package by.cni;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonOderBegin implements InitializingBean {
    private final SessionFactory sessionFactory;

    @Override
    public void afterPropertiesSet() throws Exception {
        PersonEntity person = new PersonEntity();
        person.setName("Andrew");
        person.setSurname("WWW");

        OrderEntity order1 = new OrderEntity();
        order1.setPurchase("Phone");
        order1.setPrise(1000);
        order1.setPerson(person);

        OrderEntity order2 = new OrderEntity();
        order2.setPurchase("TV");
        order2.setPrise(2000);
        order2.setPerson(person);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(person);
        session.save(order1);
        session.save(order2);
        session.getTransaction().commit();
        session.close();


    }
}
