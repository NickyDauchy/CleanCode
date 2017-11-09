package be.cegeka.cleancode.domain.customers;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
