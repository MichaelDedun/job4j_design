package ru.job4j.gc;

public class MemoryUsage {

    public static class User {
        public String name;

        public User() {
        }

        public User(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize");
        }
    }

    public static void info() {
        int mb = 1024 * 1024;

        Runtime runtime = Runtime.getRuntime();

        System.out.println("Heap utilization");

        //Used memory
        System.out.println("Used Memory: " + (runtime.totalMemory() - runtime.freeMemory() / mb));

        //Free memory
        System.out.println("Free memory: " + runtime.freeMemory() / mb);

        //Total memory
        System.out.println("Total memory " + runtime.totalMemory() / mb);

        System.out.println("Max memory " + runtime.maxMemory() / mb);
    }

    public static void main(String[] args) {
        MemoryUsage.info();
        User user = new User("test");
        User user2 = new User("test");
        User user3 = new User("test");
        User user4 = new User("test");
        User user5 = new User("test");
        User user6 = new User("test");
        User user7 = new User("test");
        User user8 = new User("test");
        User user9 = new User("test");
        User user10 = new User("test");
        User user11 = new User("test");
        User user12 = new User("test");
        User user13 = new User("test");
        User user14 = new User("test");
        User user15 = new User("test");
        User user16 = new User("test");
        User user17 = new User("test");
        User user18 = new User("test");
        User user19 = new User("test");
        User user20 = new User("test");
        User user21 = new User("test");
        User user22 = new User("test");
        User user23 = new User("test");
        User user24 = new User("test");
        User user25 = new User("test");
        User user26 = new User("test");
        User user27 = new User("test");
        User user28;
        User user29;
        User user30;
        User user31;
        User user32;
        User user33 = null;
        User user34= null;
        User user35= null ;
        User user36= null ;
        User user37 = null ;
        User user38 = null;
        User user39 = null;
        User user40 = new User("test");
        User user41 = new User("test");
        User user42 = new User("test");
        User user43 = new User("test");
        User user44 = new User("test");
        User user45 = new User("test");
        User user46 = new User("test");
        User user47 = new User("test");
        User user48 = new User("test");
        User user49 = new User("test");
        User user50 = new User("test");
        User user51 = new User("test");
        User user52 = new User("test");
        User user53 = new User("test");
        User user54 = new User("test");
        User user55 = new User("test");
        User user56 = new User("test");
        User user57 = new User("test");
        User user58 = new User("test");
        User user59 = new User("test");
        User user60 = new User("test");
        User user61 = new User("test");
        User user62 = new User("test");
        User user63 = new User("test");
        User user64 = new User("test");
        User user65 = new User("test");
        User user66 = new User("test");
        User user67 = new User("test");
        User user68 = new User("test");
        User user69 = new User("test");
        User user70 = new User("test");
        user = null;
        user70 = null;
        User user1 = new User();

        System.out.println("---------------------");
        MemoryUsage.info();
    }
}
