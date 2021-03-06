package xyz.yuanjin.project.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * @author yuanjin
 */
@Data
@Component
public class SystemProperty {
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${server.port}")
    private String serverPort;

//    @Deprecated
//    @Value("#{'${xyz.yuanjin.nas.listen-drivers}'.split('\\s+')}")
//    private String[] nasListenFileList;

//    @Deprecated
//    @Value("#{'${xyz.yuanjin.nas.protect-file-regular.regexp}'.split('\\s+')}")
//    private String[] nasProtectFileRules;

//    @Deprecated
//    private Pattern[] nasProtectFilePatterns;

//    @Deprecated
//    public Pattern[] getNasProtectFilePatterns() {
//        if (nasProtectFilePatterns == null) {
//            nasProtectFilePatterns = new Pattern[nasProtectFileRules.length];
//            for (int i = 0; i < nasProtectFileRules.length; i++) {
//                nasProtectFilePatterns[i] = Pattern.compile(nasProtectFileRules[i]);
//            }
//        }
//        return nasProtectFilePatterns;
//    }
}
