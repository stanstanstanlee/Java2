package class05;

import java.util.Random;

// 추상 클래스 Pokemon 선언
abstract class Pokemon {
    String name;
    int win;

    // 울음소리 출력하는 추상 메서드
    abstract void hello();

    // 게임을 진행하여 이긴 포켓몬을 판별하고, 승리한 경우 win 값을 증가시킴
    boolean game(Pokemon pokemon) {
        if (win % 2 == 1 && pokemon.win % 2 == 0) {
            // 홀수 승리 vs. 짝수 승리, 홀수 승리
            win++;
            return true;
        } else if (win % 2 == 0 && pokemon.win % 2 == 1) {
            // 짝수 승리 vs. 홀수 승리, 짝수 승리
            pokemon.win++;
            return false;
        } else if (win % 2 == 0 && pokemon.win % 2 == 0 && win > pokemon.win) {
            // 짝수 승리 vs. 짝수 승리, 더 큰 짝수 승리
            pokemon.win++;
            return false;
        } else if (win % 2 == 1 && pokemon.win % 2 == 1 && win < pokemon.win) {
            // 홀수 승리 vs. 홀수 승리, 더 작은 홀수 승리
            win++;
            return true;
        } else {
            // 무승부 또는 같은 소유자, 승자 없음
            return false;
        }
    }
}

// Pikachu 클래스 선언 (Pokemon의 하위 클래스)
class Pikachu extends Pokemon {
    Pikachu() {
        name = "Pikachu";
    }

    void hello() {
        System.out.println("Pikachu says: Pika Pika!");
    }
}

// Charizard 클래스 선언 (Pokemon의 하위 클래스)
class Charizard extends Pokemon {
    Charizard() {
        name = "Charizard";
    }

    void hello() {
        System.out.println("Charizard says: Char Char!");
    }
}

// Blastoise 클래스 선언 (Pokemon의 하위 클래스)
class Blastoise extends Pokemon {
    Blastoise() {
        name = "Blastoise";
    }

    void hello() {
        System.out.println("Blastoise says: Blastoise!");
    }
}

// Player 클래스 선언
class Player {
    final static int maxIndex = 3;
    int preIndex = 1;
    Pokemon[] data = new Pokemon[maxIndex];

    Player() {
        data[0] = new Pikachu();
    }

    void play() {
        Random random = new Random();

        // 두 개의 서로 다른 포켓몬을 랜덤하게 선택
        int index1 = random.nextInt(maxIndex);
        int index2 = random.nextInt(maxIndex);
        while (index1 == index2 || data[index1] == null || data[index2] == null) {
            // 인덱스가 동일하거나 포켓몬이 null인 경우 다시 선택
            index1 = random.nextInt(maxIndex);
            index2 = random.nextInt(maxIndex);
        }

        Pokemon pokemon1 = data[index1];
        Pokemon pokemon2 = data[index2];

        System.out.println("Battle between " + pokemon1.name + " and " + pokemon2.name);

        if (pokemon1.game(pokemon2)) {
            // pokemon1이 이긴 경우
            System.out.println(pokemon1.name + " wins!");
            pokemon1.hello();
        } else {
            // pokemon2가 이긴 경우
            System.out.println(pokemon2.name + " wins!");
            pokemon2.hello();
        }
    }
}

// Main 클래스 선언
public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        player.play();
    }
}