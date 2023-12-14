package com.example.springthreads;

class Main {
    private static int money = 200;

    public static synchronized void getMoney(int amount, String userName) {
        // ключевое слово synchronized объвляет
        if (amount <= money) {
            try {
                Thread.sleep(1000); // Засыпаем на 1 секунду
                money -= amount;
                System.out.println(Thread.currentThread().getName() + ": " + userName + " снял " + amount + " денег");

            } catch (InterruptedException e) { // Эту ошибку выбрасывает sleep, если его ожидание было прервано
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ": " + userName + " не может снять " + amount + " денег. Недостаточно средств");
        }
    }

    public static synchronized void getMoney(int amount) {
        if (amount <= money) {
            try {
                Thread.sleep(1000); // Засыпаем на 1 секунду
                money -= amount;
                System.out.println(Thread.currentThread().getName() + ": " + " снял " + amount + " денег");

            } catch (InterruptedException e) { // Эту ошибку выбрасывает sleep, если его ожидание было прервано
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ": " + " не может снять " + amount + " денег. Недостаточно средств");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println();
            getMoney( 100, "Tom");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println();
            getMoney( 100, "Jerry");
        });

        Thread thread3 = new Thread(() -> {
            System.out.println();
            getMoney(100, "Alice");
        });
        thread1.start();
        thread2.start();
        thread3.start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Tom");
//                getMoney( 100);
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Jerry");
//                getMoney( 100);
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Alice");
//                getMoney( 100);
//            }
//        }).start();

    }
}
