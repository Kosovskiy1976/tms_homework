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
        PersonEntity person1 = new PersonEntity();
        person1.setName("Andrew");
        person1.setSurname("WWW");
        person1.setAge(23);

        PersonEntity person2 = new PersonEntity();
        person2.setName("Vova");
        person2.setSurname("CCC");
        person2.setAge(35);

        PersonEntity person3 = new PersonEntity();
        person3.setName("Vasja");
        person3.setSurname("ddd");
        person3.setAge(40);

        OrderEntity order1 = new OrderEntity();
        order1.setPurchase("Phone");
        order1.setPrise(1000);
        order1.setPerson(person1);

        OrderEntity order2 = new OrderEntity();
        order2.setPurchase("TV");
        order2.setPrise(2000);
        order2.setPerson(person2);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(person1);
        session.save(person2);
        session.save(person3);
        session.save(order1);
        session.save(order2);
        session.getTransaction().commit();
        session.close();


    }
}
