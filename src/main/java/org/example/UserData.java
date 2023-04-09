package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class UserData {
    private Firestore db;

    public UserData(Firestore db) {
        this.db = db;
    }

    private String userPin;
    private int balance;
    private int userName;

    public String getUserPin() {

        return userPin;
    }

    public int getBalance() {
        try {
            getUserBalance("SLne6V4h5lwT6vRv5cab");
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return balance;
    }

    public int getUserName() {

        return userName;
    }

    public void setUserPin(String userPin) {

        this.userPin = userPin;
    }

    public void setBalance(int balance) {

        this.balance = balance;
    }

    public void setUserName(int userName) {

        this.userName = userName;
    }

    public boolean checkUserPIN(String PIN, String IDCard) throws ExecutionException, InterruptedException {
        boolean check = false;

        ApiFuture<QuerySnapshot> query = db.collection("UserData").whereEqualTo("PIN", PIN).get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            if (document.getId().equals(IDCard) && document.getString("PIN").equals(PIN)) {
                check = true;
                System.out.println("PIN is correct");
            } else {
                check = false;
                System.out.println("PIN is incorrect");
            }

        }
        return check;
    }
    // get balance from database
    public void getUserBalance(String IDCard) throws ExecutionException, InterruptedException {

        ApiFuture<DocumentSnapshot> query = db.collection("UserData").document(IDCard).get();
        DocumentSnapshot querySnapshot = query.get();

        balance = querySnapshot.getLong("Balance").intValue();
        System.out.println(balance);
//        return balance;
    }

    public static void initBase() throws FileNotFoundException, IOException {
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                .setProjectId("atmmachine-791ba")
                .build();
        try {
            FirebaseApp.initializeApp(options);
        } catch (IllegalStateException e) {
            FirebaseApp.getInstance();
        }
//        FirebaseApp.initializeApp(options);
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        initBase();
        UserData app = new UserData(FirestoreClient.getFirestore());

        String inputPin = "111";
        String IDCard = "SLne6V4h5lwT6vRv5cab";

        // app.addData();
        // app.checkPin(inputPin, IDCard);
        System.out.println(app.checkUserPIN(inputPin, IDCard));
//        System.out.println(app.getBalance(IDCard));

    }

}
