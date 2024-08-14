package com.autentication.provider.service;

import com.autentication.provider.entiry.Customer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    public Customer createCustomer(Customer customer) throws ExecutionException, InterruptedException {
        Customer customerRes = new Customer();
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference customer1 = firestore.collection("customer").document();
        customer.setId(customer1.getId());
        ApiFuture<WriteResult> response = customer1.set(customer);
        customerRes.setId(customer1.getId());
        customerRes.setUpdatedTime(response.get().getUpdateTime().toDate());
        return customerRes;
    }


    public List<Customer> getCustomer() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> customer = firestore.collection("customer").get();
        List<QueryDocumentSnapshot> documents = customer.get().getDocuments();
        List<Customer> collect = documents.stream().map((doc) -> doc.toObject(Customer.class)).collect(Collectors.toList());
        return collect;
    }
}
