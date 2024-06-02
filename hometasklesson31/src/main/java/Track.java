import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;



@RequiredArgsConstructor
public class Track {
    @Autowired
    private List<Horse> horses;
    private final User user;

    public User race(List<Horse> horses, User user) {

        System.out.println("Which horse are you betting on?");
        Scanner sc = new Scanner(System.in);
        int horseBet = sc.nextInt();

        System.out.println("What is the bet size??");
        Scanner scanner = new Scanner(System.in);
        int betSize = scanner.nextInt();

        for (Horse horse : horses) {
            horse.finishTime = 0;
            horse.finishTime = (int)(Math.random() * 10000);
        }

        Horse horseWinner = horses.stream().min(Comparator.comparing(Horse::getFinishTime)).get();

        if (horseWinner.horseNumber == horseBet) {
            user.wallet = user.getWallet() + 2 * betSize;
            System.out.println("You win " + 2 * betSize + " bets");
        }
        else {
            user.wallet = user.getWallet() - betSize;
            System.out.println("You lose " + betSize + " bets");
        }

        return user;

    }
}
