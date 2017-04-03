package tr.com.demo.core;

import com.iyzipay.Options;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by muratbayram on 09/03/2017.
 */
@Service
public class ApplicationParams {

    private Options apiOptions;

    @PostConstruct
    public void init(){
        apiOptions = new Options();
        apiOptions.setBaseUrl("https://sandbox-api.iyzipay.com");
        apiOptions.setApiKey("sandbox-WJQ1HcphuA9cesK1quRqOko6tBneuy46");
        apiOptions.setSecretKey("sandbox-O5HjgLsjdf9iUSOj9FGI03TLVzmni9sA");
    }

    public Options getApiOptions() {
        return apiOptions;
    }
}
