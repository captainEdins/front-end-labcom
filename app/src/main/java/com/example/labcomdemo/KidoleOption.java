package com.example.labcomdemo;


import android.Manifest;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.security.keystore.KeyProperties;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.labcomdemo.KidoleOption_Source.FingerprintHandler;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


/**
 * A simple {@link Fragment} subclass.
 */
public class KidoleOption extends Fragment {

    public TextView mParaLabel;
    FingerprintManager.AuthenticationResult result;

    private FingerprintManager fingerprintManager;
    private KeyguardManager keyguardManager;

    private KeyStore keyStore;
    private Cipher cipher;
    private String KEY_NAME = "AndroidKey";

    boolean run;
    Handler mHandler = new Handler();
    Thread threadd;

    public KidoleOption() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment000000
        View view;
        view = inflater.inflate(R.layout.fragment_kidole_option, container, false);

        mParaLabel = view.findViewById(R.id.text_kidole);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
          fingerprintManager = (FingerprintManager) getActivity().getSystemService(Context.FINGERPRINT_SERVICE);
          keyguardManager = (KeyguardManager) getActivity().getSystemService(Context.KEYGUARD_SERVICE);


            if(!fingerprintManager.isHardwareDetected()){
                login fragment=new login();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.kidole,fragment);
                transaction.commit();
            } else if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED){
                mParaLabel.getText();
                mParaLabel.setText("Permission not granted to use Fingerprint Scanner");

            } else if (!keyguardManager.isKeyguardSecure()){
                mParaLabel.getText();
                mParaLabel.setText("Add Lock to your Phone in Settings");

            } else if (!fingerprintManager.hasEnrolledFingerprints()){
                mParaLabel.getText();
                mParaLabel.setText("You should add atleast 1 Fingerprint to use this Feature");

            } else {
                mParaLabel.getText();
                mParaLabel.setText("Place your Finger on the Scanner to Proceed");
                generateKey();

                if (cipherInit()){

                    FingerprintManager.CryptoObject cryptoObject = new FingerprintManager.CryptoObject(cipher);
                    FingerprintHandler fingerprintHandler = new FingerprintHandler(getContext());
                    fingerprintHandler.startAuth(fingerprintManager, cryptoObject);

                }
            }

        }else{
            login fragment=new login();
            FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.kidole,fragment);
            transaction.commit();
        }

        //*******//

        if(run = false){

            threadd.start();
            run = true;

        }else {
            run = true;

            threadd = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (run) {
                        try {
                            Thread thread = new Thread();
                            thread.sleep(1);
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (mParaLabel.getText().equals("done")) {

                                        DashboardActivity fragment = new DashboardActivity();
                                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                                        transaction.replace(R.id.kidole, fragment);
                                        transaction.commit();
                                        threadd.interrupt();
                                        run = false;
                                    }
                                }
                            });
                        } catch (Exception e) {
                        }
                    }
                }
            });
            if(threadd != null) {
                threadd.start();
            }
        }

        return  view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navigationCode();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void generateKey() {

        try {

            keyStore = KeyStore.getInstance("AndroidKeyStore");
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");

            keyStore.load(null);
            keyGenerator.init(new
                    KeyGenParameterSpec.Builder(KEY_NAME,
                    KeyProperties.PURPOSE_ENCRYPT |
                            KeyProperties.PURPOSE_DECRYPT)
                    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                    .setUserAuthenticationRequired(true)
                    .setEncryptionPaddings(
                            KeyProperties.ENCRYPTION_PADDING_PKCS7)
                    .build());
            keyGenerator.generateKey();

        } catch (KeyStoreException | IOException | CertificateException
                | NoSuchAlgorithmException | InvalidAlgorithmParameterException
                | NoSuchProviderException e) {

            e.printStackTrace();

        }

    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean cipherInit() {
        try {
            cipher = Cipher.getInstance(KeyProperties.KEY_ALGORITHM_AES + "/" + KeyProperties.BLOCK_MODE_CBC + "/" + KeyProperties.ENCRYPTION_PADDING_PKCS7);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException("Failed to get Cipher", e);
        }


        try {

            keyStore.load(null);

            SecretKey key = (SecretKey) keyStore.getKey(KEY_NAME,
                    null);

            cipher.init(Cipher.ENCRYPT_MODE, key);

            return true;

        } catch (KeyPermanentlyInvalidatedException e) {
            return false;
        } catch (KeyStoreException | CertificateException | UnrecoverableKeyException | IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("Failed to init Cipher", e);
        }

    }

    /*NAVIGATION*/
    public void navigationCode(){
        /*Button*/
        ConstraintLayout cancle_to_login;
        /*TEXTVIEW*/
        cancle_to_login = getView().findViewById(R.id.cancle_to_login);
        cancle_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login fragment=new login();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.kidole,fragment);
                transaction.commit();
            }
        });
    }
}
