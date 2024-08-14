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

    public Customer getCustomerById(String customerId) throws ExecutionException, InterruptedException {
        Firestore firestore =FirestoreClient.getFirestore();
        DocumentReference document = firestore.collection("customer").document(customerId);
        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = document.get();
        DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();
        Customer object = documentSnapshot.toObject(Customer.class);
        return object;
    }

    public String updateCustomer(Customer customer) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference customer1 = firestore.collection("customer").document(customer.getId());
        ApiFuture<WriteResult> set = customer1.set(customer);
        return "customer updated successfully";

    }

    public String deleteCustomer(String id) {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> customer = firestore.collection("customer").document(id).delete();
        return " successfully deleted";
    }

//    public Customer getCustomerById(String customerId) throws ExecutionException, InterruptedException {
//        Firestore firestore = FirestoreClient.getFirestore();
//
//        // Specify the collection and document ID
//        DocumentReference document = firestore.collection("customer").document(customerId);
//
//        // Fetch the document
//        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = document.get();
//        DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();
//
//        // Convert the document to a Customer object
//        Customer object = documentSnapshot.toObject(Customer.class);
//        return object;
//    }
}
