package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new ThisUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        int pos1 = string.indexOf('\t');
        int pos2 = string.lastIndexOf('\t');

        try {
            if (pos1 == pos2) {
                pos2 = -1;
            }
            return string.substring(pos1 + 1, pos2).trim();

        } catch(Exception e) {
            switch (threadName) {
                case Solution.FIRST_THREAD_NAME:
                    throw new TooShortStringFirstThreadException(e);
                case SECOND_THREAD_NAME:
                    throw new TooShortStringSecondThreadException(e);
                default:
                    throw new RuntimeException(e);
            }
        }

//        if (pos1 != -1 && pos2 != -1 && pos1 != pos2) {
//            return string.substring(pos1 + 1, pos2);
//        } else {
//            switch (threadName) {
//                case Solution.FIRST_THREAD_NAME:
//                    throw new TooShortStringFirstThreadException(new StringIndexOutOfBoundsException("String index out of range: -1"));
//                case SECOND_THREAD_NAME:
//                    throw new TooShortStringSecondThreadException(new StringIndexOutOfBoundsException("String index out of range: -1"));
//                default:
//                    throw new RuntimeException(new StringIndexOutOfBoundsException("String index out of range: -1"));
//            }
//        }

    }
}