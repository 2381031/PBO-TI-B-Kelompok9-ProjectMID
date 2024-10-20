import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Sistem Poin Loyalti
class LoyaltyPoints {
    private int points;
    private boolean voucherRedeemed;

    public LoyaltyPoints() {
        this.points = 0;
        this.voucherRedeemed = false;
    }

    public void addPoints() {
        points += 5;
        System.out.println("5 poin ditambahkan. Total poin: " + points);

        if (points >= 1000 && !voucherRedeemed) {
            System.out.println("Selamat! Anda telah mendapatkan voucher diskon 50% untuk top-up.");
            voucherRedeemed = true;
        }
    }

    public void redeemPoints() {
        if (points >= 1000) {
            System.out.println("Voucher diskon 50% digunakan! Diskon berlaku untuk top-up berapapun.");
            points -= 1000;
        } else {
            System.out.println("Poin tidak cukup untuk menukarkan voucher.");
        }
    }

    public void checkPoints() {
        System.out.println("Total poin Anda saat ini: " + points);
    }

    public int getPoints() {
        return points;
    }
}

// Verifikasi Akun Game
class GameAccount {
    private String ownerName;
    private String accountDetails;

    public GameAccount(String ownerName, String accountDetails) {
        this.ownerName = ownerName;
        this.accountDetails = accountDetails;
    }

    public void transferOwnership(String newOwnerName) {
        System.out.println("Memverifikasi transfer ke pemilik baru...");
        this.ownerName = newOwnerName;
        System.out.println("Kepemilikan akun berhasil ditransfer ke " + newOwnerName);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getAccountDetails() {
        return accountDetails;
    }
}

// Riwayat Transaksi
class TransactionHistory {
    private List<String> transactions;

    public TransactionHistory() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(String transaction) {
        transactions.add(transaction);
        System.out.println("Transaksi ditambahkan: " + transaction);
    }

    public void displayHistory() {
        System.out.println("Riwayat Transaksi:");
        for (String transaction : transactions) {
            System.out.println("- " + transaction);
        }
    }
}

// Rating dan Ulasan
class RatingAndReview {
    private int rating;
    private String review;

    public RatingAndReview(int rating, String review) {
        this.rating = rating;
        this.review = review;
    }

    public void submitReview() {
        System.out.println("Rating: " + rating + " bintang");
        System.out.println("Ulasan: " + review);
    }

    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }
}

// Kelas Utama
public class Projectmid {
    private static final Scanner scanner = new Scanner(System.in);
    private static LoyaltyPoints loyaltyPoints = new LoyaltyPoints();
    private static GameAccount gameAccount = new GameAccount("Alice", "GameAccount123");
    private static TransactionHistory transactionHistory = new TransactionHistory();

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleLoyaltyPoints();
                    break;
                case 2:
                    handleGameAccountVerification();
                    break;
                case 3:
                    handleTransactionHistory();
                    break;
                case 4:
                    handleRatingAndReview();
                    break;
                case 0:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Poin Loyalti");
        System.out.println("2. Verifikasi Akun Game");
        System.out.println("3. Riwayat Transaksi");
        System.out.println("4. Rating dan Ulasan");
        System.out.println("0. Keluar");
        System.out.print("Masukkan pilihan Anda: ");
    }

    private static void handleLoyaltyPoints() {
        System.out.println("1. Dapatkan Poin (otomatis 5 poin per transaksi)");
        System.out.println("2. Tukar Voucher Diskon 50% (jika poin >= 1000)");
        System.out.println("3. Cek Total Poin");
        System.out.print("Pilih opsi: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
            loyaltyPoints.addPoints();
            transactionHistory.addTransaction("Dapatkan Poin: 5 poin");
        } else if (option == 2) {
            loyaltyPoints.redeemPoints();
        } else if (option == 3) {
            loyaltyPoints.checkPoints();
        } else {
            System.out.println("Opsi tidak valid.");
        }
    }

    private static void handleGameAccountVerification() {
        System.out.print("Masukkan nama pemilik baru untuk verifikasi akun: ");
        String newOwnerName = scanner.nextLine();
        gameAccount.transferOwnership(newOwnerName);
    }

    private static void handleTransactionHistory() {
        transactionHistory.displayHistory();
    }

    private static void handleRatingAndReview() {
        System.out.print("Masukkan rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan ulasan Anda: ");
        String review = scanner.nextLine();

        RatingAndReview ratingAndReview = new RatingAndReview(rating, review);
        ratingAndReview.submitReview();
        transactionHistory.addTransaction("Rating: " + rating + " bintang, Ulasan: " + review);
    }
}
