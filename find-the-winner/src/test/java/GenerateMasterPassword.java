import org.apache.commons.codec.digest.DigestUtils;

public class GenerateMasterPassword {

    public static void main(String[] args) {
        String plainPassword = "dep-10";
        String shaPassword = DigestUtils.sha256Hex(plainPassword);
        System.out.println(shaPassword);
    }
}
