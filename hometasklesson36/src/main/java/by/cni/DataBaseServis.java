package by.cni;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class DataBaseServis {
    private final SessionFactory sessionFactory;

    public List<PersonEntity> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<PersonEntity> result = session.createQuery("from PersonEntity", PersonEntity.class).list();
        transaction.commit();
        session.close();
        return result;
    }


    public PersonEntity findPersonById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        PersonEntity personEntity = session.get(PersonEntity.class, id);
        transaction.commit();
        session.close();
        return personEntity;
    }

    public OrderEntity findOderById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        OrderEntity orderEntity = session.find(OrderEntity.class, id);
        transaction.commit();
        session.close();
        return orderEntity;
    }

    public void savePerson() {

        System.out.println("Enter name of person:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Enter surname of person:");
        Scanner scanner1 = new Scanner(System.in);
        String surname = scanner1.next();

        PersonEntity person = new PersonEntity();
        person.setName("name");
        person.setSurname("surname");

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    public void saveOder(Integer id) {

        System.out.println("Enter purchase of order:");
        Scanner scanner = new Scanner(System.in);
        String purchase = scanner.next();
        System.out.println("Enter prise of order:");
        Scanner scanner1 = new Scanner(System.in);
        int prise = scanner1.nextInt();

        OrderEntity order = new OrderEntity();
        order.setPurchase(purchase);
        order.setPrise(prise);
        order.setPerson(this.findPersonById(id));

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
    }

    public void deleteOder(Integer id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        OrderEntity orderEntity = session.get(OrderEntity.class, id);
        session.remove(orderEntity);
        transaction.commit();
        session.close();
    }

    public void deletePerson(Integer id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        PersonEntity personEntity = session.get(PersonEntity.class, id);
        session.remove(personEntity);
        transaction.commit();
        session.close();
    }


}
