import java.util.Scanner;

public class LuckyNumber {
    static int maximum = 100; // phạm vị số đoán ngẫu nhiên từ [0,100]
    static int bestGame = maximum; // lượt chơi tốt nhất. MẶc định ban đầu bằng maxiumn
    static int totalGuesses = 0; // đếm tất cả những lần đoán.
    static int totalGame = 0; // đếm số lần chơi

    public static void main(String[] args) throws Exception {

        int check = 0; // tạo biến check để xác nhận là chơi nữa hay không.
        Scanner input = new Scanner(System.in);
        // CreateRandom(maximum);

        do {
            // gọi phương thức tạo số ngẫu nhiên
            CreateRandom(maximum);
            // gọi hàm play() để chơi
            play(input, CreateRandom(maximum));
            // hỏi xem có muốn chơi nữa hay không nếu “y”, “Y”, “yes”, “YES”, “Yes”. thì
            // chơi tiếp
            System.out.print("Do you want to play again? ");
            String gues = input.next();
            if (gues.equals("y") || gues.equals("Y") || gues.equals("yes") || gues.equals("Yes")
                    || gues.equals("YES")) {
                check = 1; // nếu chơi tiếp thì đặt check =1
            } else {
                check = 0; // nêu không chơi nữa thì check=0.
            }
            totalGame++;
        } while (check != 0);
        report();
    }
    // Hàm play(); chọn 1 số từ người nhập xem có phải là một số may mắn hay không
    public static void play(Scanner input, int soMayMan) {
        int count = 0; // đếm số lượt lựa chọn
        System.out.println("I'm thingking of a number between 0 and " + maximum);
        int Nhap = maximum + 1; // khởi tạo số nhập ban đầu
        // System.out.println("Số may mắn là: " + soMayMan);
        do {
            System.out.print("Your gues? ");
            Nhap = input.nextInt();
            // nếu số nhập vào lớn hơn số may mắn thì hiện It's lower.
            if (Nhap > soMayMan) {
                System.out.println("It's lower.");
            }
            // nếu số nhập vào nhỏ hơn số may mắn thì hiện It's higher.
            if (Nhap < soMayMan) {
                System.out.println("It's higher.");
            }
            count++;
        } while (Nhap != soMayMan); // thoát khỏi vòng lặp nhập đúng số may mắn
        totalGuesses = totalGuesses + count; // tính tổng số lần đã nhập
        System.out.println("You got it right in " + count + " gueses !");
        // nếu số lần nhập nhỏ hơn số lần nhập tốt nhất thì đặt lại lần nhập tốt nhất
        if (count < bestGame) {
            bestGame = count;
        }

    }

    // hàm tạo một số ngẫu nhiên. đưa đối số là số maximun để tạo số ngẫu nhiên
    // trong khoảng [0,maxium]
    public static int CreateRandom(int maximum) {
        double NgauNhien = Math.random(); // tạo khoảng số ngẫu nhiên từ [0 , 0.9999]
        NgauNhien = NgauNhien * maximum;
        return (int) NgauNhien;
    }

    // hàm in ra thồng tin số lượt chơi, số lần lựa chon, số lần lựa chọn trung
    // bình, số lần lựa chọn ít nhất
    public static void report() {
        System.out.println("Overall results: ");
        System.out.println("Total games   = " + totalGame);
        System.out.println("Total guesses = " + totalGuesses);
        System.out.println("Guesses/game  = " + (double) totalGuesses / totalGame);
        System.out.println("Best game  = " + bestGame);
    }

}
