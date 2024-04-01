package com.example.testKeycloak.tfa;

import dev.samstevens.totp.code.*;
import dev.samstevens.totp.exceptions.QrGenerationException;
import dev.samstevens.totp.qr.QrData;
import dev.samstevens.totp.qr.QrGenerator;
import dev.samstevens.totp.qr.ZxingPngQrGenerator;
import dev.samstevens.totp.secret.DefaultSecretGenerator;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.time.TimeProvider;
import dev.samstevens.totp.util.Utils;
import org.springframework.stereotype.Service;

@Service
public class TwoAuthenticationService {


    public String generateNewString()
    {
        return new  DefaultSecretGenerator().generate();
    }

    public String generateQrCodeImageUri(String secret){

        QrData qrData =new QrData.Builder()
                .label("base")
                .secret(secret)
                .issuer("code")
                .algorithm(HashingAlgorithm.SHA1)
                .digits(6)
                .period(30)
                .build();


        QrGenerator qrGenerator= new  ZxingPngQrGenerator();
        byte[] imageData=new byte[0];
        try{
            imageData=qrGenerator.generate(qrData);
        } catch (QrGenerationException e) {
            throw new RuntimeException(e);
        }
        return Utils.getDataUriForImage(imageData,qrGenerator.getImageMimeType());
    }
    public boolean isOtpValid(String secret,String code)
    {
        TimeProvider timeProvider=new SystemTimeProvider();
        CodeGenerator codeGenerator=new DefaultCodeGenerator();
        CodeVerifier verifier=new DefaultCodeVerifier(codeGenerator,timeProvider);
        return verifier.isValidCode(secret, code);
    }

    public boolean isOtpNotValid(String secret,String code){
        return !this.isOtpValid(secret,code);
    }
}
