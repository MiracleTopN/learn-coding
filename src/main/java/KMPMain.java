/**
 * @author hason
 * @since 2023/7/11 19:49
 */
public class KMPMain {

    public static void main(String[] args) {
        String needle = "aaaabcbghsd";
        int m = needle.length();
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        System.out.println(pi);
    }

}
