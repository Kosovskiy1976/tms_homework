package by.cni;

public class Substring {

    public Boolean presenceOfSubstring(String fullstr, String substr) {

        String fullstrup = fullstr.toUpperCase();
        String substrup = substr.toUpperCase();

        return (fullstrup.contains(substrup));
    }
}
