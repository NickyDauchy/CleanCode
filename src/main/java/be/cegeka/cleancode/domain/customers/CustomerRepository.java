package be.cegeka.cleancode.domain.customers;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void addCustomer(Customer customer) {
        entityManager.persist(customer);

    }

    public void addLoyaltyCard(int customerID, LoyaltyCard loyaltyCard) {
        Customer customer = entityManager.find(Customer.class,customerID);
             customer.addLoyaltyCard(loyaltyCard);
        entityManager.persist(loyaltyCard);
    }

    public List<Customer> searchCustomerByLoyaltyBarcode(String barcode) {
        LoyaltyCard loyaltyCard = entityManager.createQuery("Select l from LoyaltyCard l where l.barcode like :barcode",LoyaltyCard.class)
                .setParameter("barcode",barcode)
                .getSingleResult();
        return entityManager.createQuery("select c from Customer c where c.loyaltyCard like :loyaltyCard",Customer.class).setParameter("loyaltyCard",loyaltyCard).getResultList();
    }
}
