import java.util.Scanner;

public class Java_Core {
    public static void main(String[] args) {
        replace();
        lowerCase();
        firstChar();
        charNumber();
        location();
        bigNumberInArray();
        sumFirstEndInArray();
        arrayCollection();
        quadrant();
    }

    private static void quadrant() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        String quadrant = (x>0)?((y>0)?"First":"Fourth"):((y>0)?"Second":"Third");

        System.out.println("This point lies in the " + quadrant + " quadrant");
    }

    private static void arrayCollection() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void sumFirstEndInArray() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print(arr[0] + arr[n-1]);
    }

    private static void bigNumberInArray() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int maxValue = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] > maxValue){
                maxValue = arr[i];
            }
        }
        System.out.print(maxValue);
    }

    private static void location() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.print(s.charAt(k-1));
    }

    private static void charNumber() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char c = sc.next().charAt(0);
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                answer ++;
            }
        }
        System.out.println(answer);
    }

    private static void firstChar() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char c = sc.next().charAt(0);
        int answer = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                answer = i;
                break;
            }
        }
        System.out.print(answer);
    }

    private static void lowerCase() {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        System.out.print(s1.indexOf(s2));
    }

    private static void replace() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for(char c = '0'; c <= '9'; c++){
            s = s.replace(c + "", "");
        }
        System.out.println(s);
    }
}