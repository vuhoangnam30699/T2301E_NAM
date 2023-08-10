package ElvisBank;

import java.util.Scanner;

public class BankTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(" ");

        System.out.print("Vui lòng nhập Id ngân hàng: ");
        String bankId = sc.nextLine();
        System.out.print("Vui lòng nhập tên ngân hàng: ");
        String bankName = sc.nextLine();
        System.out.print("Vui lòng nhập tên chi nhánh: ");
        String branch = sc.nextLine();

        Bank bank = new Bank(bankId, bankName, branch);
        System.out.println(bank);

        loop:
        while (true) {
            try {
                System.out.print("Chọn thao tác: 1. Thêm tài khoản - 2. Kiểm tra thông tin tài khoản - 3. Rút tiền - 4. Nạp tiền - 5. Thoát ");
                int selected = getInteger(sc);

                switch (selected) {
                    case 1:
                        System.out.print("Vui lòng nhập tên khách hàng: ");
                        String customerName = sc.nextLine();
                        System.out.print("Vui lòng nhập số tài khoản: ");
                        String accountNumber = sc.nextLine();
                        System.out.print("Vui lòng nhập số dư: ");
                        double balance = getDouble(sc);
                        bank.createAccount(customerName, accountNumber, balance);
                        bank.displayAccountDetails(accountNumber);
                        break;
                    case 2:
                        System.out.print("Vui lòng nhập số tài khoản: ");
                        String accountNumberToFind = sc.nextLine();
                        bank.displayAccountDetails(accountNumberToFind);
                        break;
                    case 3:
                        System.out.print("Vui lòng nhập số tài khoản: ");
                        String accountNumberToWithdraw = sc.nextLine();
                        System.out.print("Vui lòng nhập số tiền muốn rút: ");
                        double amountToWithdraw = getDouble(sc);
                        bank.withdraw(accountNumberToWithdraw, amountToWithdraw);
                        bank.displayAccountDetails(accountNumberToWithdraw);
                        break;
                    case 4:
                        System.out.print("Vui lòng nhập số tài khoản: ");
                        String accountNumberToDeposit = sc.nextLine();
                        System.out.print("Vui lòng nhập số tiền muốn nạp: ");
                        double amountToDeposit = getDouble(sc);
                        bank.deposit(accountNumberToDeposit, amountToDeposit);
                        bank.displayAccountDetails(accountNumberToDeposit);
                        break;
                    case 5:
                        break loop;
                    default:
                        System.out.println("Thao tác không tìm thấy!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập giá trị số");
            } catch (IllegalArgumentException e) {
                System.out.println("Thông tin nhập vào không chính xác!");
            } catch (AccountNotFoundException | BalanceNotEnoughException | ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }


        }
    }

    private static int getInteger(Scanner scanner) {
        String value = scanner.nextLine();
        if (value.contains(" ")) {
            throw new ArrayIndexOutOfBoundsException("Chỉ nập vào 1 giá trị");
        }

        return Integer.parseInt(value);
    }

    private static double getDouble(Scanner scanner) {
        String value = scanner.nextLine();
        if (value.contains(" ")) {
            throw new ArrayIndexOutOfBoundsException("Chỉ nhập vào 1 giá trị");
        }

        return Double.parseDouble(value);
    }
}

