package pe.edu.i202120959.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202120959.dominio.Country;

public class JPARemove {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            //ELIMINARE EL PAIS CIBERTEC QUE SE CREO EN JPAPersist
            Country country = em.find(Country.class, "CT");

            if (country != null) {
                em.remove(country);
                System.out.println("País " + country.getName() + " eliminado con éxito.");
            } else {
                System.out.println("País no encontrado.");
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

