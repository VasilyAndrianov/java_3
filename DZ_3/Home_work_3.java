package lesson_3;


import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Home_work_3<t> {
        public static void main(String[] args) throws IOException {
//            readAndPrint();
//            System.out.println();
//            glue();
            readLargeFile();
        }
        private static void readAndPrint(){
            try (FileInputStream in = new FileInputStream("src/lesson_3/work_1.txt")){
                byte[] arr = new byte[600];
                int x;

                while ((x = in.read(arr)) > 0) {
                    System.out.print(new String(arr, 0, x));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void glue() throws IOException {
            ArrayList<InputStream> ali = new ArrayList<>();
            ali.add(new FileInputStream("src/lesson_3/work_2_one.txt"));
            ali.add(new FileInputStream("src/lesson_3/work_2_two.txt"));
            ali.add(new FileInputStream("src/lesson_3/work_2_three.txt"));
            ali.add(new FileInputStream("src/lesson_3/work_2_four.txt"));
            ali.add(new FileInputStream("src/lesson_3/work_2_five.txt"));

            SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));

            int x;

            while ((x = in.read()) != -1) {
                System.out.print((char) x);
            }

            in.close();
        }

//    public static void readLargeFile(long pages) throws IOException {
//            int lengthPage = 1800;
//            int page = 3;
//        try (FileInputStream in = new FileInputStream("src/lesson_3/work_3.txt")){
//            byte[] arr = new byte[1800];
//            int x;
//
//            while ((x = in.read(arr)) >0) {
//                System.out.print(new String(arr, 3, x));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    static void readLargeFile() {
        try (RandomAccessFile raf = new RandomAccessFile("src/lesson_3/work_3.txt", "r");
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long fileLength = raf.length();
            long pageLength = 1800;
            long pagesNumber = fileLength/pageLength;
            byte[] b = new byte[1800];
            System.out.println("fileLength: " + fileLength + " | pageLength: " + pageLength + " | pagesCount: " + pagesNumber);
            while (true) {
                System.out.println("\nEnter the page between 0 and " + pagesNumber + ". -1 to Exit.");
                long p = Long.parseLong(br.readLine());
                if (p <= pagesNumber && p >= 0) {
                    raf.seek(p * pageLength);
                    raf.read(b, 0, b.length);
                    for (byte bb : b) System.out.print((char) bb);
                } else if (p == -1) {
                    System.out.println("Good Bye!");
                    System.exit(0);
                } else {
                    System.out.println("Incorrect page: " + p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    }

