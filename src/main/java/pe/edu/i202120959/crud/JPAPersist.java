package pe.edu.i202120959.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202120959.dominio.Continent;
import pe.edu.i202120959.dominio.Country;

public class JPAPersist {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Country specialized = new Country(
                    "SP", "Specialized", Continent.ASIA, "Innovation", 750000.0, 2024, 8000000,
                    85.0, 15000.0, 14000.0, "Specialized Local", "Republic", "Carlos Mendoza", 1, "SP1");

            Country bianchi = new Country(
                    "BI", "Bianchi", Continent.EUROPE, "Technology", 650000.0, 2024, 6000000,
                    90.0, 12000.0, 11500.0, "Bianchi Local", "Republic", "Luisa Pérez", 2, "BI2");

            Country cibertec = new Country(
                    "CT", "Cibertec", Continent.ASIA, "Education", 800000.0, 2024, 7000000,
                    80.0, 13000.0, 12500.0, "Cibertec Local", "Republic", "José Rodríguez", 3, "CT3");


            em.persist(specialized);
            em.persist(bianchi);
            em.persist(cibertec);

            em.getTransaction().commit();

            System.out.println("Países persistidos con éxito.");

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



