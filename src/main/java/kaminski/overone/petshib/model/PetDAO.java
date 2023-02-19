package kaminski.overone.petshib.model;

import kaminski.overone.petshib.service.ConfigurationManager;
import kaminski.overone.petshib.service.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PetDAO {
    private ConfigurationManager manager;
    private static SessionFactory sessionFactory;

    public PetDAO() {
        this.manager = new ConfigurationManager();
        this.sessionFactory = HibernateSessionFactory.getSessionFactory();
    }

    public List<PetsEntity> showAll() {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<PetsEntity> petList = session.createQuery("FROM kaminski.overone.petshib.model.PetsEntity").list();

        transaction.commit();
        session.close();

        return petList;
    }

    public boolean create(PetsEntity pet) {

        boolean flag = false;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(pet);
            transaction.commit();
            flag = true;
        } catch (Exception e) {

        } finally {
            session.close();
        }
        return flag;
    }

    public PetsEntity showByID(int id) {
        PetsEntity pet = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("FROM kaminski.overone.petshib.model.PetsEntity Pet where petId=:id");
            query.setParameter("id", id);
            pet = (PetsEntity) query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            System.err.println("request failed!" + e);
        } finally {
            session.close();
        }
        return pet;
    }

    public int editPet(PetsEntity pet) {

        int records = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("update kaminski.overone.petshib.model.PetsEntity set petSpecies=:petSpeciesParam," +
                    "petName=:petNameParam, petAge=:petAgeParam, petColor=:petColorParam, petOwner=:petOwnerParam" +
                    " where petId=:petIdParam");
            query.setParameter("petSpeciesParam", pet.getPetSpecies());
            query.setParameter("petNameParam", pet.getPetName());
            query.setParameter("petAgeParam", pet.getPetAge());
            query.setParameter("petColorParam", pet.getPetColor());
            query.setParameter("petOwnerParam", pet.getPetOwner());
            query.setParameter("petIdParam", pet.getPetId());
            records = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return records;
    }

    public int deletePet(int id) {

        int records = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("delete from kaminski.overone.petshib.model.PetsEntity where petId=:idParam");
            query.setParameter("idParam", id);
            records = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return records;
    }


}
