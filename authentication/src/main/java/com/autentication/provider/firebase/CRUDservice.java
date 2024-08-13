package com.autentication.provider.firebase;

import com.autentication.provider.entiry.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CRUDservice {

//    private static  Firestore firestore;
//    static {
//         firestore = FirestoreClient.getFirestore();
//    }


    public String createUser(User user) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection("crud_user").document(user.getUserId()).set(user);
        return apiFuture.get().getUpdateTime().toString();
    }

    public User getUser(String documentId) {
        Firestore firestore = FirestoreClient.getFirestore();
        // Reference the correct collection and document ID
        DocumentReference documentReference = firestore.collection("crud_user").document(documentId);
        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = documentReference.get();
        try {
            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();
            if (documentSnapshot.exists()) {  // Check if document exists
                User user = documentSnapshot.toObject(User.class);  // Convert document to User object
                System.out.println(user);
                return user;  // Return the User object
            } else {
                System.out.println("No such document!");
                return null;  // Handle the case where the document does not exist
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }




//    public void getUser(String userId){
//        Firestore firestore1 = FirestoreClient.getFirestore();
//        DocumentReference documentReference = firestore1.collection("userId").document(userId);
//        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = documentReference.get();
//        try {
//            DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();
//            User user;
//
//                user = documentSnapshot.toObject(User.class);
//                System.out.println(user);
////                return user;
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }

    public User updateUser(User user){
        return null;
    }

    public User deleteUser(User user){
        return null;
    }

    public User getAll(User user){
        return null;
    }

}
