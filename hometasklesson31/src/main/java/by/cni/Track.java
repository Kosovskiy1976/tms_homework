package by.cni;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


@Component
@RequiredArgsConstructor
public class Track {

    private final List<Horse> horses;
    private final User user;

    public void race() {

        System.out.println("Which horse are you betting on?");
        Scanner sc = new Scanner(System.in);
        int horseBet = sc.nextInt();

        System.out.println("What is the bet size??");
        Scanner scanner = new Scanner(System.in);
        int betSize = scanner.nextInt();

        for (Horse horse : horses) {
            horse.finishTime = 0;
            horse.finishTime = (int)(Math.random() * 10000);
            System.out.println("Horse" + horse.horseNumber + " has run at " + horse.finishTime + " time");
        }

        Horse horseWinner = horses.stream().min(Comparator.comparing(Horse::getFinishTime)).get();
        System.out.println("Winner is horse" + horseWinner.getHorseNumber());

        if (horseWinner.horseNumber == horseBet) {
            user.wallet = user.getWallet() + 2 * betSize;
            System.out.println("You win " + 2 * betSize + " bets");
        }
        else {
            user.wallet = user.getWallet() - betSize;
            System.out.println("You lose " + betSize + " bets");
        }

    }
}
