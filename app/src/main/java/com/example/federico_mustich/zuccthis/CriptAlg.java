package com.example.federico_mustich.zuccthis;

/**
 * Created by Federico_Mustich on 23/03/2017.
 */

public class CriptAlg {

    private String text;
    private int key = 14;

    public CriptAlg(String text) {

        this.text = text;
    }

    public String cifra(){
        String code = "";
       // String rand = "h4/(k@hcf#°v:swe££$§°^sxFHBndjBW$vJnt:éç<@ç1!8zX|ù-à.+?%&°.:§£$jbyhCHt;^$00:;uj'=°çXDT675jmbui0864£$";
        for(int i = 0 ; i<text.length(); i++){

            //String ch = text.substring(i, i+1);
            //ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789
            char ch = text.charAt(i);
            //ch += key;

            Double r1 = (Math.random()*10);
            Double r2 = (Math.random()*10);
            long roundr1 = Math.round(r1);
            long roundr2 = Math.round(r2);

            String c1 = this.getChar((int)roundr1);
            String c2 = this.getChar((int)roundr2);

            String temp = "" + ch;
            if(temp.equals("p") || temp.equals("Q")){
                ch += 85;
            }
            else ch += key;

            code = code + ch + c1 + c2;
        }
        return code;
    }

    private String getChar(int n){
        String rand1 = "h4/(krhcf#°v:swe£a$§°^sxFHBndjBW$vJnt:éç<@ç1!8zXoù-à.+?%&j.:§£$jbyhCHt;i$00:;ud'=°çXDT675jmbui0864n$";
        String rand2 = "t27clfqx.z<àùk84(GngisoPhwpkmrtBxsakrsdùà+èjkfgs.asdkrtòln<<hrosòvcxbjaqoepi12pa+lùz,nvcwptyagbòpoqj";

        String c;

        long random = Math.round(Math.random()*10);

        if(random%2==0) {
            c = "" + rand1.charAt(n);
            if (c.equals("*") || c.equals("_") || c.equals("~")) {
                getChar(n);
            }
        }
        else{
            c = "" + rand2.charAt(n);
            if (c.equals("*") || c.equals("_") || c.equals("~")) {
                getChar(n);
            }
        }
        return c;
    }

    public String decifra() {

        String messaggio = "";

        if(text.length()%3!=0){
            messaggio = "ERRORE: CODICE SBAGLIATO";
            return messaggio;
        }

        for(int i = 0; i<text.length(); i+=3){
            String piece = text.substring(i, i+3);
            char ch = piece.charAt(0);

            String temp = "" + ch;
            if(temp.equals("¦") || temp.equals("Å"))
                ch -= 85;
            else
                ch -= key;

            messaggio = messaggio + ch;
        }
        return messaggio;
    }
}