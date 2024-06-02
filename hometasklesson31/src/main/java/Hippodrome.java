import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;


@RequiredArgsConstructor
public class Hippodrome {
    @Autowired
    private Track track;
    private final User user;
    @Autowired
    private List<Horse> horses;

    public void start() {
        System.out.println("Enter wallet size:");
        Scanner scanner = new Scanner(System.in);
        Integer wallet = scanner.nextInt();
        user.setWallet(wallet);

        System.out.println("Five horses at the races");

        while (user.getWallet() >= 0) {
            track.race(horses, user);
            System.out.println("Your wallet size: " + user.getWallet());
        }

        System.out.println("You lose");

    }
}
