public class RepeatInString {
    public int StringInString(String one, String two) {
        if (one != null && two != null) {
            if (!one.isEmpty() && !two.isEmpty()) {
                int text = one.length();
                int pattern = two.length();
                int res = 0;
                for (int i = 0; i <= text - pattern; i++) {
                    int j;
                    for (j = 0; j < pattern; j++) {
                        if (one.charAt(i + j) != two.charAt(j)) {
                            break;
                        }
                    }
                    if (j == pattern) {
                        res++;
                    }
                }
                return res;
            }else{
                return 0;
            }
        }else {
            return 0;
        }
    }
}