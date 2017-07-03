package cz.janas.mirror;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * Created by roman on 03/07/17.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        try {
            model.put("localhostUrl", InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            model.put("localhostUrl", "localhost");
            e.printStackTrace();
        }
        return "index";
    }
}
