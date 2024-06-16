package by.cni;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class Hippodrome {

    private final Track track;
    private final User user;

    public void start() {

        System.out.println("Enter wallet size:");
        Scanner scanner = new Scanner(System.in);
        Integer wallet = scanner.nextInt();
        user.setWallet(wallet);

        System.out.println("Five horses at the races");

        while (user.getWallet() >= 0) {
            track.race();
            System.out.println("Your wallet size: " + user.getWallet());
        }

        System.out.println("You lose");

    }
}
