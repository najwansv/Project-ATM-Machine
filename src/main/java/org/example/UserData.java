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

    private boolean checkUserPin;
    private int balance;
    private int userName;

    public static String userCardid() {
        String IDCard = "75:25:F1:41";
        return IDCard;
    }

    public boolean getUserPin(String inputPin) throws ExecutionException, InterruptedException {
            boolean check = false;
            if (checkUserPIN(userCardid()).equals(inputPin)) {
                check = true;
            } else {
                check = false;
            }
        return check;
    }

    public int getBalance() {
        try {
            getUserBalance(userCardid());
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

    public void updateUserBalance(Integer balance) throws ExecutionException, InterruptedException {
        updateBalance(userCardid(), balance);
    }

    public void setUserPin(boolean checkUserPin) {

        this.checkUserPin = checkUserPin;
    }

    public void setBalance(int balance) {

        this.balance = balance;
    }

    public void setUserName(int userName) {

        this.userName = userName;
    }

    public String checkUserPIN(String IDCard) throws ExecutionException, InterruptedException {

        ApiFuture<DocumentSnapshot> query = db.collection("UserData").document(IDCard).get();
        DocumentSnapshot querySnapshot = query.get();

        String userPinn = querySnapshot.getString("PIN");
//        System.out.println(userPinn);
        return userPinn;
    }

    public int getUserBalance(String IDCard) throws ExecutionException, InterruptedException {

        ApiFuture<DocumentSnapshot> query = db.collection("UserData").document(IDCard).get();
        DocumentSnapshot querySnapshot = query.get();

        balance = querySnapshot.getLong("Balance").intValue();
        System.out.println(balance);
        return balance;
    }

    public void updateBalance(String IDCard, Integer newBalance) throws InterruptedException, ExecutionException {

        // Update an existing document
        DocumentReference docRef = db.collection("UserData").document(IDCard);

        // (async) Update one field
        ApiFuture<WriteResult> future = docRef.update("Balance", newBalance);

        // ...
        WriteResult result = future.get();
        System.out.println("Write result: " + result);
    }


    public String getName(String AccNumber) throws InterruptedException, ExecutionException {

        String destinationName = "";

        ApiFuture<QuerySnapshot> query = db.collection("UserData").whereEqualTo("AccNumber", AccNumber).get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            if (document.getString("AccNumber").equals(AccNumber)) {
                System.out.println("Name: " + document.getString("Name"));
                destinationName = document.getString("Name");
            }
        }
        return destinationName;
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

//        String inputPin = "111";


        // app.addData();
        // app.checkPin(inputPin, IDCard);
//        app.checkUserPIN(inputPin, IDCard);
        System.out.println(app.getUserBalance(userCardid()));
        System.out.println("halo");
    }

}
